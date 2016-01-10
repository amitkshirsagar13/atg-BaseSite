package com.sample.droplet;

import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import atg.servlet.DynamoHttpServletRequest;
import atg.servlet.DynamoHttpServletResponse;
import atg.servlet.DynamoServlet;
import net.webservicex.www.GetInfoByCityDocument;
import net.webservicex.www.GetInfoByCityResponseDocument;
import services.WebServicesToolsManager;

/**
 * 
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * 
 * <pre>
 * &#64;projectName BaseSite
 * Creation date: Sep 21, 2015
 * &#64;author Amit Kshirsagar
 * &#64;version 1.0
 * &#64;since
 * 
 * <p><b>Modification History:</b><p>
 * 
 * 
 * </pre>
 */

public class TestGeoCodeDroplet extends DynamoServlet {

	/** The constant OUTPUT. */
	public static final String OUTPUT = "output";

	/** The constant ERROR. */
	public static final String ERROR = "error";

	/** The constant CUSTOMER_NUMBER. */
	public static final String USCITY = "usCity";

	/** The constant PARTY_PREFERENCES. */
	public static final String CITYINFO = "cityInfo";

	/** The constant ERROR_MESSAGE. */
	public static final String ERROR_MESSAGES = "errorMessages";

	/** The types service tools. */
	public WebServicesToolsManager mWebServicesToolsManager;

	/**
	 * Service the droplet.
	 * 
	 * @param pRequest
	 *            the request
	 * @param pResponse
	 *            the response
	 * @throws ServletException
	 *             the servlet exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @see atg.servlet.DynamoServlet#service(atg.servlet.DynamoHttpServletRequest,
	 *      atg.servlet.DynamoHttpServletResponse)
	 */
	@Override
	public void service(DynamoHttpServletRequest pRequest, DynamoHttpServletResponse pResponse)
			throws ServletException, IOException {
		boolean errorOccurred = false;
		List<String> errorMessages = new ArrayList<String>();

		String usCity = pRequest.getParameter(USCITY);

		if (getWebServicesToolsManager() == null) {
			errorOccurred = true;
			errorMessages.add("WebServicesToolsManager not available");
		}

		if (getWebServicesToolsManager() == null || getWebServicesToolsManager().getGeoCodeServiceTools() == null) {
			errorOccurred = true;
			errorMessages.add("GeoCodeServiceTools not available");
		}

		if (usCity == null || usCity.isEmpty()) {
			errorOccurred = true;
			errorMessages.add(USCITY + " not specified....");
		}

		GetInfoByCityResponseDocument getInfoByCityResponseDocument = null;
		if (!errorOccurred) {
			try {
				GetInfoByCityDocument getInfoByCityDocument = getWebServicesToolsManager().getGeoCodeServiceTools()
						.getGetInfoByCityDocument();

				getInfoByCityDocument.getGetInfoByCity().setUSCity(usCity);

				getInfoByCityResponseDocument = getWebServicesToolsManager().getGeoCodeServiceTools()
						.getInfoByCity(getInfoByCityDocument);

				if (getInfoByCityResponseDocument == null) {
					errorOccurred = true;
					errorMessages.add(USCITY + " not found");
				}
			} catch (RemoteException e) {
				if (isLoggingError()) {
					logError("RemoteException thrown in TestPyPreferencesDroplet.service", e);
				}
				errorOccurred = true;
				errorMessages.add(e.getMessage());
			}
		}

		if (!errorOccurred) {
			pRequest.setParameter(CITYINFO, getInfoByCityResponseDocument);
			pRequest.serviceLocalParameter(OUTPUT, pRequest, pResponse);
		} else {
			pRequest.setParameter(ERROR_MESSAGES, errorMessages);
			pRequest.serviceLocalParameter(ERROR, pRequest, pResponse);
		}
	}

	public WebServicesToolsManager getWebServicesToolsManager() {
		return mWebServicesToolsManager;
	}

	public void setWebServicesToolsManager(WebServicesToolsManager pWebServicesToolsManager) {
		mWebServicesToolsManager = pWebServicesToolsManager;
	}

}
