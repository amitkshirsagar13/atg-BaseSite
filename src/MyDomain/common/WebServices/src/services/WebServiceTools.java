package services;

import org.apache.axis2.client.Stub;
import org.apache.xmlbeans.XmlObject;

import atg.nucleus.GenericService;
import atg.rest.client.RestSession;

public class WebServiceTools extends GenericService implements WebServiceConstants {

	/** The stub. */
	protected Stub mStub;

	/** The other stub. */
	protected Stub otherStub;

	/** The Rest Session. */
	protected RestSession mRestSession;
	protected WebServiceMetadata mWebService;
	protected RestServiceMetadata mRestServiceMetadata;
	/** The web service name. */
	protected String mWebServiceName;

	/**
	 * Instantiates a new web service tools.
	 */
	public WebServiceTools() {
		super();
	}

	/**
	 * Log stub endpoint.
	 * 
	 * @param stub
	 *            the stub
	 */
	public void logStubEndpoint(Stub stub) {
		if (isLoggingTrace()) {
			if (stub != null && stub._getServiceClient() != null && stub._getServiceClient().getOptions() != null
					&& stub._getServiceClient().getOptions().getTo() != null) {
				logTrace("endPointReference : " + stub._getServiceClient().getOptions().getTo().toString());
			}
		}
	}

	/**
	 * log xml object
	 * 
	 * @param pXmlObject
	 */
	public void logXmlObject(XmlObject pXmlObject) {
		if (isLoggingDebug() && pXmlObject != null) {
			logDebug(pXmlObject == null ? "(null)" : pXmlObject.toString());
		}
	}

	/**
	 * Gets the stub.
	 * 
	 * @return the stub
	 */
	public Stub getStub() {
		return mStub;
	}

	/**
	 * Sets the stub.
	 * 
	 * @param pStub
	 *            the new stub
	 */
	public void setStub(Stub pStub) {
		mStub = pStub;
	}

	/**
	 * Gets the  web service.
	 * 
	 * @return the  web service
	 */
	public WebServiceMetadata getWebService() {
		return mWebService;
	}

	/**
	 * Sets the  web service.
	 * 
	 * @param pWebService
	 *            the new  web service
	 */
	public void setWebService(WebServiceMetadata pWebService) {
		mWebService = pWebService;
	}

	public RestServiceMetadata getRestServiceMetadata() {
		return mRestServiceMetadata;
	}

	public void setRestServiceMetadata(RestServiceMetadata pRestServiceMetadata) {
		this.mRestServiceMetadata = pRestServiceMetadata;
	}

	/**
	 * Gets the web service name.
	 * 
	 * @return the web service name
	 */
	public String getWebServiceName() {
		return mWebServiceName;
	}

	/**
	 * Sets the web service name.
	 * 
	 * @param pWebServiceName
	 *            the new web service name
	 */
	public void setWebServiceName(String pWebServiceName) {
		mWebServiceName = pWebServiceName;
	}

	/**
	 * Gets the otherStub.
	 * 
	 * @return the otherStub
	 */
	public Stub getOtherStub() {
		return otherStub;
	}

	/**
	 * Sets the otherStub.
	 * 
	 * @param otherStub
	 *            the new stub
	 */
	public void setOtherStub(Stub otherStub) {
		this.otherStub = otherStub;
	}

	public RestSession getCurrentRestSession() {
		return mRestSession;
	}
}
