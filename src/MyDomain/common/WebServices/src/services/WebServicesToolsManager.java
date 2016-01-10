package services;

import services.rest.CustomerRelatedInfoServiceTools;
import services.soap.geocode.GeoCodeServiceTools;
import services.soap.weather.GlobalWeatherServiceTools;
import services.soap.weather.WeatherServiceTools;
import atg.nucleus.GenericService;

/**
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * <pre>
 * .
 * 
 * @author Amit Kshirsagar
 * @version 1.0
 * @since <p><b>Modification History:</b><p>
 * 
 * 
 * </pre>
 * 
 * @projectName MyAccount Creation date: Apr 15, 2015
 */

public class WebServicesToolsManager extends GenericService {

	private GeoCodeServiceTools geoCodeServiceTools;
	private WeatherServiceTools weatherServiceTools;
	private GlobalWeatherServiceTools globalWeatherServiceTools;

	private CustomerRelatedInfoServiceTools customerRelatedInfoServiceTools;

	public GeoCodeServiceTools getGeoCodeServiceTools() {
		return geoCodeServiceTools;
	}

	public void setGeoCodeServiceTools(GeoCodeServiceTools geoCodeServiceTools) {
		this.geoCodeServiceTools = geoCodeServiceTools;
	}

	public WeatherServiceTools getWeatherServiceTools() {
		return weatherServiceTools;
	}

	public void setWeatherServiceTools(WeatherServiceTools weatherServiceTools) {
		this.weatherServiceTools = weatherServiceTools;
	}

	public GlobalWeatherServiceTools getGlobalWeatherServiceTools() {
		return globalWeatherServiceTools;
	}

	public void setGlobalWeatherServiceTools(GlobalWeatherServiceTools globalWeatherServiceTools) {
		this.globalWeatherServiceTools = globalWeatherServiceTools;
	}

	public CustomerRelatedInfoServiceTools getCustomerRelatedInfoServiceTools() {
		return customerRelatedInfoServiceTools;
	}

	public void setCustomerRelatedInfoServiceTools(CustomerRelatedInfoServiceTools customerRelatedInfoServiceTools) {
		this.customerRelatedInfoServiceTools = customerRelatedInfoServiceTools;
	}

}
