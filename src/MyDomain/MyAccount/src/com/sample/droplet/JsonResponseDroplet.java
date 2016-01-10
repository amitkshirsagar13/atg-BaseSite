package com.sample.droplet;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;

import com.google.gson.Gson;
import com.sample.ui.bean.user.UserDetail;

import atg.adapter.gsa.GSARepository;
import atg.repository.RepositoryException;
import atg.repository.RepositoryItem;
import atg.servlet.DynamoHttpServletRequest;
import atg.servlet.DynamoHttpServletResponse;
import atg.servlet.DynamoServlet;
import net.webservicex.www.GetWeatherDocument;
import net.webservicex.www.GetWeatherResponseDocument;
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
public class JsonResponseDroplet extends DynamoServlet {

	public static String OUTPUT = "output";
	public static final String ERROR = "error";

	public static String PARAM_CITYNAME = "cityName";

	public String mCityName;

	private Map<String, Object> mResponseObject;

	private WebServicesToolsManager mWebServicesToolsManager;

	private GSARepository messageRepository;

	@Override
	public void service(DynamoHttpServletRequest pRequest, DynamoHttpServletResponse pResponse)
			throws ServletException, IOException {
		String cityName = pRequest.getParameter(PARAM_CITYNAME);

		// logInfo("Working with Param: " + cityName);

		/*
		 * Get Your work done from here or call some webservice for getting work
		 * done
		 */

		// getWeatherDetails(cityName);

		Gson gson = new Gson();
		Map<String, Object> jsonResponseWrapper = new HashMap<String, Object>();

		List<UserDetail> userMap = new ArrayList<UserDetail>();

		UserDetail userDetail = new UserDetail();

		userDetail.setName("Amit");
		userDetail.setAge("30");
		userDetail.setRelation("Self");
		userMap.add(userDetail);
		userDetail = new UserDetail();
		userDetail.setName("Amogh");
		userDetail.setAge("6");
		userDetail.setRelation("Son");
		userMap.add(userDetail);
		userDetail = new UserDetail();
		userDetail.setName("Poonam");
		userDetail.setAge("30");
		userDetail.setRelation("Wife");
		userMap.add(userDetail);
		userDetail = new UserDetail();

		try {
			RepositoryItem messageItem = getMessageRepository().getItem("1");
			String message = (String) messageItem.getPropertyValue("message");
			String key = (String) messageItem.getPropertyValue("message_key");
			logInfo(key + "::" + message);
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		jsonResponseWrapper.put("weatherDetails", userMap);

		String jsonStringResponse = gson.toJson(jsonResponseWrapper);

		logInfo(jsonStringResponse);
		PrintWriter pw = pResponse.getWriter();
		pw.print(jsonStringResponse);
	}

	public void getWeatherDetails(String pCityName) throws RemoteException {

		if (!getResponseObject().containsKey(pCityName)) {
			GetWeatherDocument getWeatherDocument = getWebServiceToolsManager().getGlobalWeatherServiceTools()
					.getGetWeatherDocument();
			getWeatherDocument.getGetWeather().setCityName(pCityName);
			getWeatherDocument.getGetWeather().setCountryName("United States");

			GetWeatherResponseDocument getWeatherResponseDocument = getWebServiceToolsManager()
					.getGlobalWeatherServiceTools().getWeatherByCity(getWeatherDocument);

			getResponseObject().put(pCityName,
					getWeatherResponseDocument.getGetWeatherResponse().getGetWeatherResult());
		}
	}

	public Map<String, Object> getResponseObject() {
		if (mResponseObject == null) {
			mResponseObject = new HashMap<String, Object>();
		}
		return mResponseObject;
	}

	public void setResponseObject(Map<String, Object> pResponseObject) {
		mResponseObject = pResponseObject;
	}

	public WebServicesToolsManager getWebServiceToolsManager() {
		return mWebServicesToolsManager;
	}

	public void setWebServicesToolsManager(WebServicesToolsManager pWebServicesToolsManager) {
		mWebServicesToolsManager = pWebServicesToolsManager;
	}

	public String getCityName() {
		return mCityName;
	}

	public void setCityName(String pCityName) {
		mCityName = pCityName;
	}

	public GSARepository getMessageRepository() {
		return messageRepository;
	}

	public void setMessageRepository(GSARepository pMessageRepository) {
		messageRepository = pMessageRepository;
	}
}