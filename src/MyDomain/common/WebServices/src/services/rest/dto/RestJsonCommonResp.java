package services.rest.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

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

public class RestJsonCommonResp {
	String returnCode = null;
	List<String> messages = new ArrayList<String>();

	/**
	 * @return the returnCode
	 */
	public String getReturnCode() {
		return returnCode;
	}

	/**
	 * @param returnCode
	 *            the returnCode to set
	 */
	@JsonProperty("ReturnCode")
	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	/**
	 * @return the messages
	 */
	public List<String> getMessages() {
		return messages;
	}

	/**
	 * @param messages
	 *            the messages to set
	 */
	@JsonProperty("Messages")
	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

}
