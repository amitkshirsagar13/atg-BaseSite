/**
 * 
 */
package com.sample.handler;

import java.io.IOException;
import java.rmi.RemoteException;

import javax.servlet.ServletException;

import services.WebServicesToolsManager;
import atg.droplet.DropletFormException;
import atg.droplet.GenericFormHandler;
import atg.servlet.DynamoHttpServletRequest;
import atg.servlet.DynamoHttpServletResponse;

import com.cdyne.ws.weatherws.GetCityWeatherByZIPDocument;
import com.cdyne.ws.weatherws.GetCityWeatherByZIPResponseDocument;
import com.sample.ui.bean.test.WeatherDisplay;

/**
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * 
 * <pre>
 * @Project: BaseSite
 * Creation date: Jul 7, 2015
 * @author Amit Kshirsagar
 * @version 1.0
 * @since
 * 
 * <p><b>Modification History:</b><p>
 * 
 * 
 * </pre>
 */
public class TestWeatherServiceHandler extends GenericFormHandler {

	/** The types service tools. */
	private WebServicesToolsManager mWebServicesToolsManager;

	/** The constant OUTPUT. */
	public static final String OUTPUT = "output";

	/** The constant ERROR. */
	public static final String ERROR = "error";

	private String mForm1SuccessURL;
	private String mForm1ErrorURL;

	private WeatherDisplay mWeatherDisplay;
	private GetCityWeatherByZIPResponseDocument mGetCityWeatherByZIPResponseDocument;

	public boolean handleDisplayWeather(DynamoHttpServletRequest pRequest, DynamoHttpServletResponse pResponse)
			throws ServletException, IOException {

		if (getWebServicesToolsManager() == null) {
			addFormException(new DropletFormException("WebServicesToolsManager not available", ""));
		}

		if (getWebServicesToolsManager() == null || getWebServicesToolsManager().getWeatherServiceTools() == null) {
			addFormException(new DropletFormException("AdminServiceTools not available", ""));
		}

		GetCityWeatherByZIPDocument getCityWeatherByZIPDocument = getWebServicesToolsManager().getWeatherServiceTools()
				.getGetCityWeatherByZIPDocument();

		getCityWeatherByZIPDocument.getGetCityWeatherByZIP().setZIP(getWeatherDisplay().getZipCode());

		try {
			mGetCityWeatherByZIPResponseDocument = getWebServicesToolsManager().getWeatherServiceTools()
					.getWeatherByZipCode(getCityWeatherByZIPDocument);

			if (mGetCityWeatherByZIPResponseDocument == null) {
				addFormException(new DropletFormException("firstName not found", ""));
			}
		} catch (RemoteException e) {
			if (isLoggingError()) {
				logError("RemoteException thrown in TestCreateSalesLeadHandler.service", e);
			}
			addFormException(new DropletFormException(e.getMessage(), ""));
		}

		return super.checkFormRedirect(mForm1SuccessURL, mForm1ErrorURL, pRequest, pResponse);
	}

	/**
	 * @return the form1SuccessURL
	 */
	public String getForm1SuccessURL() {
		return mForm1SuccessURL;
	}

	/**
	 * @param pForm1SuccessURL
	 *            the form1SuccessURL to set
	 */
	public void setForm1SuccessURL(String pForm1SuccessURL) {
		mForm1SuccessURL = pForm1SuccessURL;
	}

	/**
	 * @return the form1ErrorURL
	 */
	public String getForm1ErrorURL() {
		return mForm1ErrorURL;
	}

	/**
	 * @param pForm1ErrorURL
	 *            the form1ErrorURL to set
	 */
	public void setForm1ErrorURL(String pForm1ErrorURL) {
		mForm1ErrorURL = pForm1ErrorURL;
	}

	public WebServicesToolsManager getWebServicesToolsManager() {
		return mWebServicesToolsManager;
	}

	public void setWebServicesToolsManager(WebServicesToolsManager pWebServicesToolsManager) {
		mWebServicesToolsManager = pWebServicesToolsManager;
	}

	public WeatherDisplay getWeatherDisplay() {
		return mWeatherDisplay;
	}

	public void setWeatherDisplay(WeatherDisplay pWeatherDisplay) {
		mWeatherDisplay = pWeatherDisplay;
	}

	public GetCityWeatherByZIPResponseDocument getGetCityWeatherByZIPResponseDocument() {
		return mGetCityWeatherByZIPResponseDocument;
	}

	public void setGetCityWeatherByZIPResponseDocument(
			GetCityWeatherByZIPResponseDocument pGetCityWeatherByZIPResponseDocument) {
		mGetCityWeatherByZIPResponseDocument = pGetCityWeatherByZIPResponseDocument;
	}

}
