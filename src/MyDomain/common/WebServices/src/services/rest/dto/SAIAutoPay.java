package services.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SAIAutoPay {
	private String sadItemCode;
	private String sadAutoPaySID;
	private String sadAutoPayPMOVAR;
	private String sadAutoPayRefNo;
	private String sadAutoPayEffDateYYYYMMDD;
	private String sadAutoPayExpDateYYYYMMDD;
	private String sadAutoPayRoutingNo;
	private String sadAutoPayType;
	private String sadAutoPaySubType;
	private String sadAutoPayFOF;

	public String getSadItemCode() {
		return sadItemCode;
	}

	@JsonProperty("SADItemCode")
	public void setSadItemCode(String sadItemCode) {
		this.sadItemCode = sadItemCode;
	}

	public String getSadAutoPaySID() {
		return sadAutoPaySID;
	}

	@JsonProperty("SADAutoPaySID")
	public void setSadAutoPaySID(String sadAutoPaySID) {
		this.sadAutoPaySID = sadAutoPaySID;
	}

	public String getSadAutoPayPMOVAR() {
		return sadAutoPayPMOVAR;
	}

	@JsonProperty("SADAutoPayPMOVAR")
	public void setSadAutoPayPMOVAR(String sadAutoPayPMOVAR) {
		this.sadAutoPayPMOVAR = sadAutoPayPMOVAR;
	}

	public String getSadAutoPayRefNo() {
		return sadAutoPayRefNo;
	}

	@JsonProperty("SADAutoPayRefNo")
	public void setSadAutoPayRefNo(String sadAutoPayRefNo) {
		this.sadAutoPayRefNo = sadAutoPayRefNo;
	}

	public String getSadAutoPayEffDateYYYYMMDD() {
		return sadAutoPayEffDateYYYYMMDD;
	}

	@JsonProperty("SADAutoPayEffDateYYYYMMDD")
	public void setSadAutoPayEffDateYYYYMMDD(String sadAutoPayEffDateYYYYMMDD) {
		this.sadAutoPayEffDateYYYYMMDD = sadAutoPayEffDateYYYYMMDD;
	}

	public String getSadAutoPayExpDateYYYYMMDD() {
		return sadAutoPayExpDateYYYYMMDD;
	}

	@JsonProperty("SADAutoPayExpDateYYYYMMDD")
	public void setSadAutoPayExpDateYYYYMMDD(String sadAutoPayExpDateYYYYMMDD) {
		this.sadAutoPayExpDateYYYYMMDD = sadAutoPayExpDateYYYYMMDD;
	}

	public String getSadAutoPayRoutingNo() {
		return sadAutoPayRoutingNo;
	}

	@JsonProperty("SADAutoPayRoutingNo")
	public void setSadAutoPayRoutingNo(String sadAutoPayRoutingNo) {
		this.sadAutoPayRoutingNo = sadAutoPayRoutingNo;
	}

	public String getSadAutoPayType() {
		return sadAutoPayType;
	}

	@JsonProperty("SADAutoPayType")
	public void setSadAutoPayType(String sadAutoPayType) {
		this.sadAutoPayType = sadAutoPayType;
	}

	public String getSadAutoPaySubType() {
		return sadAutoPaySubType;
	}

	@JsonProperty("SADAutoPaySubType")
	public void setSadAutoPaySubType(String sadAutoPaySubType) {
		this.sadAutoPaySubType = sadAutoPaySubType;
	}

	public String getSadAutoPayFOF() {
		return sadAutoPayFOF;
	}

	@JsonProperty("SADAutoPayFOF")
	public void setSadAutoPayFOF(String sadAutoPayFOF) {
		this.sadAutoPayFOF = sadAutoPayFOF;
	}

}
