package services.soap.geocode;

import java.rmi.RemoteException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import net.webservicex.www.GetInfoByCityDocument;
import net.webservicex.www.GetInfoByCityResponseDocument;

import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Stub;
import org.apache.xmlbeans.XmlObject;

import services.CacheableXmlObject;
import services.WebServiceTools;
import soap.geocode.USZipStub;
import atg.core.util.StringUtils;
import atg.nucleus.ServiceException;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

/**
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * <pre>
 * @Project: BaseSite
 * Creation date: Jul 28, 2015
 * @author Amit Kshirsagar
 * @version 1.0
 * @since
 * 
 * <p><b>Modification History:</b><p>
 * 
 * 
 * </pre>
 */

public class GeoCodeServiceTools extends WebServiceTools {

	/** The constant CACHE_MAX_ENTRIES. */
	public static final int CACHE_MAX_ENTRIES_DOCUMENTLIST = 1000;
	public static final int CACHE_MAX_ENTRIES_DOCUMENTURI = 0;

	/** The constant CACHE_TIMEOUT_MS. */
	public static final int CACHE_TIMEOUT_MS = 150000;

	/** The cached responses. */
	private Cache<CacheableXmlObject, XmlObject> mCachedDocumentListResponses;

	private Cache<CacheableXmlObject, XmlObject> mCachedDocumentUriResponses;

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
			initOtherStub(this.getAbsoluteName());
			initDocumentListCache();
			initDocumentUriCache();
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
		mStub = new USZipStub(getWebService().getWebServiceBaseUrl() + getWebServiceName());
		// mStub._getServiceClient().getOptions()
		// .setProperty(org.apache.axis2.transport.http.HTTPConstants.CHUNKED,
		// "False");
		// mStub._getServiceClient().getOptions().setSoapVersionURI("http://www.w3.org/2003/05/soap-envelope");
		// mStub._getServiceClient().getOptions()
		// .setSoapVersionURI(org.apache.axiom.soap.SOAP11Constants.SOAP_ENVELOPE_NAMESPACE_URI);
		mStub._getServiceClient().getOptions().setTimeOutInMilliSeconds(getWebService().getWebServiceTimeout());
	}

	/**
	 * Setup "otherStub" for new JBoss web services if there are overridden
	 * settings for this component.
	 * 
	 * @param componentPath
	 *            the component path
	 * @return true, if successful
	 * @throws AxisFault
	 *             the axis fault
	 * @throws ServiceException
	 *             the service exception
	 */
	private boolean initOtherStub(String componentPath) throws AxisFault, ServiceException {
		if (getWebService().isComponentOverridden(componentPath)) {
			String overriddenWebServiceUrl = getWebService().getOverriddenWebServiceUrl(componentPath);
			if (!StringUtils.isEmpty(overriddenWebServiceUrl)) {
				otherStub = new USZipStub(getWebService().getOverriddenWebServiceUrl(componentPath));
				// otherStub._getServiceClient().getOptions()
				// .setProperty(org.apache.axis2.transport.http.HTTPConstants.CHUNKED,
				// "False");
				// otherStub._getServiceClient().getOptions().setSoapVersionURI("http://www.w3.org/2003/05/soap-envelope");
				// otherStub._getServiceClient().getOptions()
				// .setSoapVersionURI(org.apache.axiom.soap.SOAP11Constants.SOAP_ENVELOPE_NAMESPACE_URI);
				otherStub._getServiceClient().getOptions()
						.setTimeOutInMilliSeconds(getWebService().getWebServiceTimeout(componentPath));
				return true;
			}
		}
		return false;
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
				if (initOtherStub(componentPath)) {
					return otherStub;
				}
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
	private void initDocumentListCache() {
		setCachedDocumentListResponses(CacheBuilder.newBuilder().maximumSize(CACHE_MAX_ENTRIES_DOCUMENTLIST)
				.expireAfterWrite(CACHE_TIMEOUT_MS, TimeUnit.MILLISECONDS).<CacheableXmlObject, XmlObject> build());
	}

	private void initDocumentUriCache() {
		setCachedDocumentUriResponses(CacheBuilder.newBuilder().maximumSize(CACHE_MAX_ENTRIES_DOCUMENTURI)
				.expireAfterWrite(CACHE_TIMEOUT_MS, TimeUnit.MILLISECONDS).<CacheableXmlObject, XmlObject> build());
	}

	/**
	 * Gets the cached responses.
	 * 
	 * @return the cached responses
	 */
	public Cache<CacheableXmlObject, XmlObject> getCachedDocumentListResponses() {
		return mCachedDocumentListResponses;
	}

	public Cache<CacheableXmlObject, XmlObject> getCachedDocumentUriResponses() {
		return mCachedDocumentUriResponses;
	}

	/**
	 * Sets the cached responses.
	 * 
	 * @param pCachedResponses
	 *            the cached responses
	 */
	public void setCachedDocumentListResponses(Cache<CacheableXmlObject, XmlObject> pCachedDocumentListResponses) {
		mCachedDocumentListResponses = pCachedDocumentListResponses;
	}

	/**
	 * Sets the cached responses.
	 * 
	 * @param pCachedResponses
	 *            the cached responses
	 */
	public void setCachedDocumentUriResponses(Cache<CacheableXmlObject, XmlObject> pCachedDocumentUriResponses) {
		mCachedDocumentUriResponses = pCachedDocumentUriResponses;
	}

	public GetInfoByCityResponseDocument getInfoByCity(GetInfoByCityDocument pReq) throws RemoteException {
		logDebug("Processing retrieveDocumentList link Webservice call ....");
		final USZipStub stub = (USZipStub) getCurrentStub(this.getAbsoluteName());

		if (isLoggingDebug()) {
			logStubEndpoint(stub);
		}

		if (isLoggingDebug() && pReq != null) {
			logDebug("request: " + pReq == null ? "(null)" : pReq.toString());
		}

		GetInfoByCityResponseDocument res = null;

		final CacheableXmlObject cacheableReq = new CacheableXmlObject(pReq);

		try {
			res = (GetInfoByCityResponseDocument) mCachedDocumentListResponses.get(cacheableReq,
					new Callable<GetInfoByCityResponseDocument>() {
						@Override
						public GetInfoByCityResponseDocument call() throws RemoteException {
							return stub.getInfoByCity((GetInfoByCityDocument) cacheableReq.getXmlObject());
						}
					});
		} catch (final ExecutionException e) {
			throw new RemoteException("ExecutionException caught in AdminServiceTools.retrieveBranch", e.getCause());
		}

		if (isLoggingDebug()) {
			logDebug("response: " + res == null ? "(null)" : res.toString());
		}

		if (res == null || res.getGetInfoByCityResponse() == null
				|| res.getGetInfoByCityResponse().getGetInfoByCityResult() == null) {
			return null;
		}

		return res;
	}

	/**
	 * Set Id for GetDocumentUri on this request document.
	 * 
	 * @return
	 */

	public GetInfoByCityDocument getGetInfoByCityDocument() {
		GetInfoByCityDocument getInfoByCityDocument = GetInfoByCityDocument.Factory.newInstance();
		getInfoByCityDocument.addNewGetInfoByCity();

		return getInfoByCityDocument;
	}
}
