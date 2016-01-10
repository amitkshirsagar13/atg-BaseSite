package services.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

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

public class RestJsonResponse extends BaseRestJsonEntity {

	RestJsonCommonResp commonResp = null;
	JsonNode detailResp = null;

	/**
	 * @return the commonResp
	 */
	public RestJsonCommonResp getCommonResp() {
		return commonResp;
	}

	/**
	 * @param commonResp
	 *            the commonResp to set
	 */
	@JsonProperty("CommonResp")
	public void setCommonResp(RestJsonCommonResp commonResp) {
		this.commonResp = commonResp;
	}

	/**
	 * @return the detailResp
	 */
	public JsonNode getDetailResp() {
		return detailResp;
	}

	/**
	 * @param detailResp
	 *            the detailResp to set
	 */
	@JsonProperty("DetailResp")
	public void setDetailResp(JsonNode detailResp) {
		this.detailResp = detailResp;
	}

	/**
	 * @return
	 */
	@JsonIgnore
	public <T> T getDetailedResponse(Class<T> typeObject) {
		return MAPPER.convertValue(getDetailResp(), typeObject);
	}

}
