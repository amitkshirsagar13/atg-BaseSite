package services;

/**
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * 
 * <pre>
 * @projectName BaseSite
 * Creation date: Apr 14, 2015
 * @author Amit Kshirsagar
 * @version 1.0
 * @since
 * 
 * <p><b>Modification History:</b><p>
 * 
 * 
 * </pre>
 */

import atg.nucleus.GenericService;
import atg.targeting.WebServicesTargetingServices;

public class RestServiceMetadata extends GenericService {

	/** The lock. */
	private final Object LOCK = new Object();

	/** The web service path. */
	private String mWebServiceEndPointAddress;

	private String mHost;

	private String mPort;

	private String mDeviceId;

	private String mTicketId;

	private String mAS400UserID2;

	private String mAuthorizationPath;
	private String mTokenizationPath;

	/** The web service timeout. */
	private int mWebServiceTimeout;

	/** The stub settings changed. */
	private boolean stubSettingsChanged = false;

	/** The web services targeting services. */
	private WebServicesTargetingServices webServicesTargetingServices = null;

	/**
	 * Instantiates a new web service metadata.
	 */
	public RestServiceMetadata() {
		super();
	}

	/**
	 * Load targeted stub settings and compare to current. Return true if
	 * settings are different, false if same.
	 * 
	 * @return stubSettingsChanged
	 */
	public boolean isStubSettingsChanged() {
		return stubSettingsChanged;
	}

	/**
	 * Sets the stub settings changed.
	 * 
	 * @param stubSettingsChanged
	 *            the new stub settings changed
	 */
	public void setStubSettingsChanged(boolean stubSettingsChanged) {
		this.stubSettingsChanged = stubSettingsChanged;
	}

	public String getDeviceId() {
		return mDeviceId;
	}

	public void setDeviceId(String mDeviceId) {
		this.mDeviceId = mDeviceId;
	}

	public void setTicketId(String mTicketId) {
		this.mTicketId = mTicketId;
	}

	public String getTicketId() {
		return mTicketId;
	}

	public void setEndPointAddress(String pWebServiceEndPointAddress) {
		mWebServiceEndPointAddress = pWebServiceEndPointAddress;
	}

	public String getEndPointAddress() {
		return mWebServiceEndPointAddress;
	}

	public void setPort(String pPort) {
		mPort = pPort;
	}

	public String getPort() {
		return mPort;
	}

	public void setHost(String pHost) {
		mHost = pHost;
	}

	public String getHost() {
		return mHost;
	}

	/**
	 * Gets the web service timeout.
	 * 
	 * @return the web service timeout
	 */
	public int getWebServiceTimeout() {
		return mWebServiceTimeout;
	}

	/**
	 * Get the web service timeout for the overridden componentPath if present.
	 * Else, return default value.
	 * 
	 * @param componentPath
	 *            the component path
	 * @return the web service timeout
	 */
	public int getWebServiceTimeout(String componentPath) {
		return getWebServiceTimeout();
	}

	/**
	 * Sets the web service timeout.
	 * 
	 * @param pWebServiceTimeout
	 *            the new web service timeout
	 */
	public void setWebServiceTimeout(int pWebServiceTimeout) {
		mWebServiceTimeout = pWebServiceTimeout;
	}

	/**
	 * Gets the web services targeting services.
	 * 
	 * @return the web services targeting services
	 */
	public WebServicesTargetingServices getWebServicesTargetingServices() {
		return webServicesTargetingServices;
	}

	/**
	 * Sets the web services targeting services.
	 * 
	 * @param webServicesTargetingServices
	 *            the new web services targeting services
	 */
	public void setWebServicesTargetingServices(WebServicesTargetingServices webServicesTargetingServices) {
		this.webServicesTargetingServices = webServicesTargetingServices;
	}

	/**
	 * @return the mWebServiceId
	 */
	public String getAS400UserId2() {
		return mAS400UserID2;
	}

	/**
	 * @param mWebServiceId
	 *            the mWebServiceId to set
	 */
	public void setAS400UserId2(String AS400UserID2) {
		this.mAS400UserID2 = AS400UserID2;
	}

	public String getWebServiceEndPointAddress() {
		return mWebServiceEndPointAddress;
	}

	public void setWebServiceEndPointAddress(String pWebServiceEndPointAddress) {
		mWebServiceEndPointAddress = pWebServiceEndPointAddress;
	}

	public String getAS400UserID2() {
		return mAS400UserID2;
	}

	public void setAS400UserID2(String pAS400UserID2) {
		mAS400UserID2 = pAS400UserID2;
	}

	public String getAuthorizationPath() {
		return mAuthorizationPath;
	}

	public void setAuthorizationPath(String pAuthorizationPath) {
		mAuthorizationPath = pAuthorizationPath;
	}

	public String getTokenizationPath() {
		return mTokenizationPath;
	}

	public void setTokenizationPath(String pTokenizationPath) {
		mTokenizationPath = pTokenizationPath;
	}

}
