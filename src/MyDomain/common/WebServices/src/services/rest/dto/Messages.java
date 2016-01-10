package services.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Messages {
	private String messageCode;
	private String messageDesc;

	public String getMessageCode() {
		return messageCode;
	}

	@JsonProperty("MessageCode")
	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	public String getMessageDesc() {
		return messageDesc;
	}

	@JsonProperty("MessageDesc")
	public void setMessageDesc(String messageDesc) {
		this.messageDesc = messageDesc;
	}
}
