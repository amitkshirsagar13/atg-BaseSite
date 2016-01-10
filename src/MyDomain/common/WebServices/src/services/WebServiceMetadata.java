package services;

import org.apache.axis2.transport.http.HttpTransportProperties;

import atg.json.JSONException;
import atg.json.JSONObject;
import atg.nucleus.GenericService;
import atg.nucleus.ServiceException;
import atg.repository.RepositoryItem;
import atg.targeting.TargetingException;
import atg.targeting.WebServicesTargetingServices;

public class WebServiceMetadata extends GenericService {

	/** The lock. */
	private final Object LOCK = new Object();

	/** The web service protocol. */
	private String mWebServiceProtocol;

	/** The web service host name. */
	private String mWebServiceHostName;

	/** The web service path. */
	private String mWebServicePath;

	/** The web service username. */
	private String mWebServiceUsername;

	/** The web service password. */
	private String mWebServicePassword;

	/** The web service preemptive authentication. */
	private boolean mWebServicePreemptiveAuthentication;

	/** The SSL required flag. */
	private boolean mSslRequired;

	/** The web service timeout. */
	private int mWebServiceTimeout;

	/** The stub settings changed. */
	private boolean stubSettingsChanged = false;

	/** The targeter path to rules. */
	private String targeterPathToRules = null;

	/** The web services targeting services. */
	private WebServicesTargetingServices webServicesTargetingServices = null;

	/** The cached json rules. */
	private String cachedJsonRules = null;

	/** The user name. */
	private String mUserName;

	/** The user id. */
	private String mUserId;

	/** The user password. */
	private String mUserPassword;

	/**
	 * Instantiates a new web service metadata.
	 */
	public WebServiceMetadata() {
		super();
	}

	/**
	 * Gets the web service base url.
	 * 
	 * @return the web service base url
	 * @throws ServiceException
	 *             the service exception
	 */
	public String getWebServiceBaseUrl() throws ServiceException {
		if (isSslRequired() && !getWebServiceProtocol().equals("https://")) {
			throw new ServiceException(
					"Protocol mismatch, web service requires protocol 'https://' but is configured with '"
							+ getWebServiceProtocol() + "'");
		}

		return getWebServiceProtocol() + getWebServiceHostName() + getWebServicePath();
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

	/**
	 * Determines if this componentPath has override settings (that are
	 * enabled).
	 * 
	 * @param componentPath
	 *            the component path
	 * @return true, if is component overridden
	 */
	public boolean isComponentOverridden(String componentPath) {
		if (isLoggingDebug()) {
			logDebug("isComponentOverridden : " + componentPath);
		}

		try {
			if (cachedJsonRules != null) {
				JSONObject jsonObj = new JSONObject(cachedJsonRules);
				if (jsonObj != null) {
					// then all override rules are disabled
					if (jsonObj.has("enabled") && jsonObj.getBoolean("enabled")) {
						if (jsonObj.has(componentPath)) {
							JSONObject componentOverrides = jsonObj.getJSONObject(componentPath);
							// then there are override rules for this component
							// AND the rules are enabled
							if (componentOverrides != null && componentOverrides.has("enabled")
									&& componentOverrides.getBoolean("enabled")) {
								if (isLoggingDebug()) {
									logDebug(componentPath + " is overridden.");
								}
								return true;
							}
						}
					}
				}
			}
		} catch (JSONException jsone) {
			logError("Caught JSONException.", jsone);
		}

		if (isLoggingDebug()) {
			logDebug(componentPath + " is NOT overridden.");
		}
		return false;
	}

	/**
	 * Get the overridden web service url for a given component from the
	 * override JSON rules.
	 * 
	 * @param componentPath
	 *            the component path
	 * @return the overridden web service url
	 */
	public String getOverriddenWebServiceUrl(String componentPath) {

		try {
			if (cachedJsonRules != null) {
				JSONObject jsonObj = new JSONObject(cachedJsonRules);
				if (jsonObj != null && jsonObj.has(componentPath)) {

					JSONObject componentOverrides = jsonObj.getJSONObject(componentPath);
					// then there are override rules for this component AND the
					// rules are enabled
					if (componentOverrides != null && componentOverrides.has("override-web-service-url")) {
						return componentOverrides.getString("override-web-service-url");
					}

				}
			}
		} catch (JSONException jsone) {
			logError("Caught JSONException.", jsone);
		}

		return null;
	}

	/**
	 * Gets the basic authenticator.
	 * 
	 * @return the basic authenticator
	 */
	public HttpTransportProperties.Authenticator getBasicAuthenticator() {
		HttpTransportProperties.Authenticator auth = new HttpTransportProperties.Authenticator();
		auth.setUsername(getWebServiceUsername());
		auth.setPassword(getWebServicePassword());
		auth.setPreemptiveAuthentication(isWebServicePreemptiveAuthentication());
		return auth;
	}

	/**
	 * Gets the basic authenticator by loading rules from the
	 * stubOverrideSettings with the componentPath key.
	 * 
	 * @param componentPath
	 *            the component path
	 * @return the basic authenticator
	 */
	public HttpTransportProperties.Authenticator getBasicAuthenticator(String componentPath) {
		HttpTransportProperties.Authenticator auth = new HttpTransportProperties.Authenticator();
		String username = getWebServiceUsername();
		String password = getWebServicePassword();
		boolean preemptiveAuthentication = isWebServicePreemptiveAuthentication();

		try {
			if (cachedJsonRules != null) {
				JSONObject jsonObj = new JSONObject(cachedJsonRules);
				if (jsonObj != null && jsonObj.has(componentPath)) {

					JSONObject componentOverrides = jsonObj.getJSONObject(componentPath);
					if (componentOverrides != null) {
						if (componentOverrides.has("override-username")) {
							username = componentOverrides.getString("override-username");
						}

						if (componentOverrides.has("override-password")) {
							password = componentOverrides.getString("override-password");
						}

						if (componentOverrides.has("override-webServicePreemptiveAuthentication")) {
							preemptiveAuthentication = componentOverrides
									.getBoolean("override-webServicePreemptiveAuthentication");
						}
					}

				}
			}
		} catch (JSONException jsone) {
			if (isLoggingError()) {
				logError("Caught JSONException.", jsone);
			}
		}

		auth.setUsername(username);
		auth.setPassword(password);
		auth.setPreemptiveAuthentication(isWebServicePreemptiveAuthentication());

		return auth;
	}

	/**
	 * Refreshes the globally scoped instance variable "cachedJsonRules". This
	 * variable is referenced throughout calls to STAR Web Services. This method
	 * is also called from a scheduled process (runs every 2 minutes) in order
	 * to limit the targeter calls and keep "cachedJsonRules" checks responding
	 * quickly. This ONLY updates the globally scoped "cachedJsonRules" variable
	 * if the current AND cached values do NOT match.
	 */
	public void refreshJsonRules() {
		try {
			RepositoryItem[] items = getWebServicesTargetingServices().executeRepositoryTargeterItems(
					getTargeterPathToRules());
			if (items != null && items.length > 0) {
				RepositoryItem stubOverrideRules = items[0];

				String jsonData = null;
				try {
					jsonData = (String) stubOverrideRules.getPropertyValue("data");
					if (jsonData != null) {
						if (!jsonData.equals(getCachedJsonRules())) {
							if (isLoggingDebug()) {
								logDebug("The Web_Services_Override_Settings have changed, refreshing the rules.");
							}
							/*****************************************************************************
							 * Then the  Web Service Override Settings have
							 * changed. Refresh "cachedJsonRules"
							 *****************************************************************************/
							// creating a JSONObject is ONLY done here to
							// prevent bad json from being cached in the next
							// line
							JSONObject jsonObj = new JSONObject(jsonData);
							synchronized (LOCK) {
								this.cachedJsonRules = jsonData;
							}
						}
					} else {
						if (getCachedJsonRules() != null) {
							if (isLoggingError()) {
								logError("The data property in Web_Services_Override_Settings["
										+ stubOverrideRules.getRepositoryId()
										+ "] is null/empty but there are existing rules cached that will be used "
										+ "until Web_Services_Override_Settings.data is set.");
							}
						}
					}
				} catch (Exception e) {
					if (isLoggingError()) {
						logError(
								"Caught Exception while trying to get \"data\" from item["
										+ stubOverrideRules.getRepositoryId() + "]", e);
					}
				}
			} else {
				if (isLoggingError()) {
					logError("No Web_Services_Override_Settings pulled from targeter: " + getTargeterPathToRules());
				}
			}
		} catch (TargetingException e) {
			if (isLoggingError()) {
				logError(e);
			}
		}
	}

	/**
	 * Gets the web service protocol.
	 * 
	 * @return the web service protocol
	 */
	public String getWebServiceProtocol() {
		return mWebServiceProtocol;
	}

	/**
	 * Sets the web service protocol.
	 * 
	 * @param pWebServiceProtocol
	 *            the new web service protocol
	 */
	public void setWebServiceProtocol(String pWebServiceProtocol) {
		mWebServiceProtocol = pWebServiceProtocol;
	}

	/**
	 * Gets the web service host name.
	 * 
	 * @return the web service host name
	 */
	public String getWebServiceHostName() {
		return mWebServiceHostName;
	}

	/**
	 * Sets the web service host name.
	 * 
	 * @param pWebServiceHostName
	 *            the new web service host name
	 */
	public void setWebServiceHostName(String pWebServiceHostName) {
		mWebServiceHostName = pWebServiceHostName;
	}

	/**
	 * Gets the web service path.
	 * 
	 * @return the web service path
	 */
	public String getWebServicePath() {
		return mWebServicePath;
	}

	/**
	 * Sets the web service path.
	 * 
	 * @param pWebServicePath
	 *            the new web service path
	 */
	public void setWebServicePath(String pWebServicePath) {
		mWebServicePath = pWebServicePath;
	}

	/**
	 * Gets the web service username.
	 * 
	 * @return the web service username
	 */
	public String getWebServiceUsername() {
		return mWebServiceUsername;
	}

	/**
	 * Sets the web service username.
	 * 
	 * @param pWebServiceUsername
	 *            the new web service username
	 */
	public void setWebServiceUsername(String pWebServiceUsername) {
		mWebServiceUsername = pWebServiceUsername;
	}

	/**
	 * Gets the web service password.
	 * 
	 * @return the web service password
	 */
	public String getWebServicePassword() {
		return mWebServicePassword;
	}

	/**
	 * Sets the web service password.
	 * 
	 * @param pWebServicePassword
	 *            the new web service password
	 */
	public void setWebServicePassword(String pWebServicePassword) {
		mWebServicePassword = pWebServicePassword;
	}

	/**
	 * Checks if is web service preemptive authentication.
	 * 
	 * @return true, if is web service preemptive authentication
	 */
	public boolean isWebServicePreemptiveAuthentication() {
		return mWebServicePreemptiveAuthentication;
	}

	/**
	 * Sets the web service preemptive authentication.
	 * 
	 * @param pWebServicePreemptiveAuthentication
	 *            the new web service preemptive authentication
	 */
	public void setWebServicePreemptiveAuthentication(boolean pWebServicePreemptiveAuthentication) {
		mWebServicePreemptiveAuthentication = pWebServicePreemptiveAuthentication;
	}

	/**
	 * Checks if is ssl required.
	 * 
	 * @return true, if is ssl required
	 */
	public boolean isSslRequired() {
		return mSslRequired;
	}

	/**
	 * Sets the ssl required.
	 * 
	 * @param pSslRequired
	 *            the new ssl required
	 */
	public void setSslRequired(boolean pSslRequired) {
		mSslRequired = pSslRequired;
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

		try {
			JSONObject jsonObj = new JSONObject(cachedJsonRules);
			if (jsonObj != null && jsonObj.has(componentPath)) {

				JSONObject componentOverrides = jsonObj.getJSONObject(componentPath);
				// then there are override rules for this component AND the
				// rules are enabled
				if (componentOverrides != null && componentOverrides.has("override-webServiceTimeout")) {
					return componentOverrides.getInt("override-webServiceTimeout");
				}

			}
		} catch (JSONException jsone) {
			if (isLoggingError()) {
				logError("Caught JSONException.", jsone);
			}
		}
		// if make it here, just return the default web serviec timeout
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
	 * Gets the targeter path to rules.
	 * 
	 * @return the targeter path to rules
	 */
	public String getTargeterPathToRules() {
		return targeterPathToRules;
	}

	/**
	 * Sets the targeter path to rules.
	 * 
	 * @param targeterPathToRules
	 *            the new targeter path to rules
	 */
	public void setTargeterPathToRules(String targeterPathToRules) {
		this.targeterPathToRules = targeterPathToRules;
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
	 * Gets the cached json rules.
	 * 
	 * @return the cached json rules
	 */
	public String getCachedJsonRules() {
		return cachedJsonRules;
	}

	/**
	 * Sets the cached json ruled.
	 * 
	 * @param cachedJsonRules
	 *            the new cached json ruled
	 */
	public void setCachedJsonRuled(String cachedJsonRules) {
		this.cachedJsonRules = cachedJsonRules;
	}

	/**
	 * Gets the user name.
	 * 
	 * @return the user name
	 */
	public String getUserName() {
		return mUserName;
	}

	/**
	 * Sets the user name.
	 * 
	 * @param pUserName
	 *            the new user name
	 */
	public void setUserName(String pUserName) {
		mUserName = pUserName;
	}

	/**
	 * Gets the user id.
	 * 
	 * @return the user id
	 */
	public String getUserId() {
		return mUserId;
	}

	/**
	 * Sets the user id.
	 * 
	 * @param pUserId
	 *            the new user id
	 */
	public void setUserId(String pUserId) {
		mUserId = pUserId;
	}

	/**
	 * Gets the user password.
	 * 
	 * @return the user password
	 */
	public String getUserPassword() {
		return mUserPassword;
	}

	/**
	 * Sets the user password.
	 * 
	 * @param pUserPassword
	 *            the new user password
	 */
	public void setUserPassword(String pUserPassword) {
		mUserPassword = pUserPassword;
	}

}
