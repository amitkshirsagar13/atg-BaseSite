package services.rest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Stub;
import org.apache.commons.io.IOUtils;
import org.apache.xmlbeans.XmlObject;

import services.CacheableXmlObject;
import services.WebServiceTools;
import services.rest.dto.CustomerRelatedInfoResponse;
import services.rest.dto.RestJsonResponse;
import atg.json.JSONException;
import atg.nucleus.ServiceException;
import atg.rest.client.RestClientException;
import atg.rest.client.RestConstants;
import atg.rest.client.RestResult;
import atg.rest.client.RestSession;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

/**
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * <pre>
 * @projectName MyAccount
 * Creation date: May 18, 2015
 * @author Amit Kshirsagar
 * @version 1.0
 * @since
 * 
 * <p><b>Modification History:</b><p>
 * 
 * 
 * </pre>
 */

public class CustomerRelatedInfoServiceTools extends WebServiceTools {

	/** The constant CACHE_MAX_ENTRIES. */
	public static final int CACHE_MAX_ENTRIES = 1000;

	/** The constant CACHE_TIMEOUT_MS. */
	public static final int CACHE_TIMEOUT_MS = 15000;

	/** The cached responses. */
	private Cache<CacheableXmlObject, XmlObject> mCachedResponses;

	/**
	 * Do start service.
	 * 
	 * @throws ServiceException
	 *             the service exception
	 * @see atg.nucleus.GenericService#doStartService()
	 */
	@Override
	public void doStartService() throws ServiceException {
		super.doStartService();
		try {
			initMainStub(this.getAbsoluteName());
			initCache();
		} catch (AxisFault e) {
			throw new ServiceException(e);
		}
	}

	/**
	 * Setup the main stub.
	 * 
	 * @param componentPath
	 *            the component path
	 * @throws AxisFault
	 *             the axis fault
	 * @throws ServiceException
	 *             the service exception
	 * @throws atg.nucleus.ServiceException
	 */
	private void initMainStub(String componentPath) throws AxisFault, ServiceException {
		mRestSession = RestSession.createSession(getRestServiceMetadata().getHost(),
				Integer.parseInt(getRestServiceMetadata().getPort()));
		mRestSession.setUseHttpsForLogin(false);
	}

	/**
	 * If this component is overridden, then initialize and use "otherStub".
	 * 
	 * @param componentPath
	 *            the component path
	 * @return the current stub
	 */
	private Stub getCurrentStub(String componentPath) {
		if (getWebService().isComponentOverridden(componentPath)) {
			try {
				initMainStub(componentPath);
			} catch (ServiceException e) {
				logWarning("Error occurred while trying to use overridden settings for " + this.getAbsoluteName()
						+ ". Using default stub instead of otherStub.", e);
			} catch (AxisFault e) {
				logWarning("Error occurred while trying to use overridden settings for " + this.getAbsoluteName()
						+ ". Using default stub instead of otherStub.", e);
			}
		}
		return mStub;
	}

	/**
	 * Inits the cache.
	 */
	private void initCache() {
		setCachedResponses(CacheBuilder.newBuilder().maximumSize(CACHE_MAX_ENTRIES)
				.expireAfterWrite(CACHE_TIMEOUT_MS, TimeUnit.MILLISECONDS).<CacheableXmlObject, XmlObject> build());
	}

	/**
	 * Gets the cached responses.
	 * 
	 * @return the cached responses
	 */
	public Cache<CacheableXmlObject, XmlObject> getCachedResponses() {
		return mCachedResponses;
	}

	/**
	 * Sets the cached responses.
	 * 
	 * @param pCachedResponses
	 *            the cached responses
	 */
	public void setCachedResponses(Cache<CacheableXmlObject, XmlObject> pCachedResponses) {
		mCachedResponses = pCachedResponses;
	}

	public CustomerRelatedInfoResponse retriveCustomerRelatedInfo(String pCustomerNumber) throws JSONException {
		CustomerRelatedInfoResponse customerRelatedInfoResponse = null;
		try {

			Map<String, Object> user = new HashMap<String, Object>();
			user.put("deviceID", "TEST");
			user.put("ticketID", "TEST");
			user.put("AS400UserID2", "TEST");

			Map<String, Object> json = new HashMap<String, Object>();
			json.put("UserAuthentication", user);
			json.put("InformationType", "Agreements");
			json.put("CustomerNumber", pCustomerNumber);

			RestResult restResult = getCurrentRestSession().createHttpRequest(
					getRestServiceMetadata().getEndPointAddress(), json, RestConstants.GET);

			String response = IOUtils.toString(restResult.getInputStream(), "UTF-8");

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

			RestJsonResponse restResponse = mapper.readValue(response, RestJsonResponse.class);
			logInfo("ATG Request: " + json.toString());
			logInfo("ATG Response: " + restResponse.toString());

			if (restResponse.getCommonResp().getReturnCode().equalsIgnoreCase("OK")) {

				customerRelatedInfoResponse = restResponse.getDetailedResponse(CustomerRelatedInfoResponse.class);

				logInfo(customerRelatedInfoResponse.getCustomerNumber() + ":"
						+ customerRelatedInfoResponse.getCustomerName() + "|"
						+ customerRelatedInfoResponse.getCustomerARBalance());

			}
		} catch (RestClientException | IOException e) {
			e.printStackTrace();
		}

		return customerRelatedInfoResponse;
	}
}
