package services.rest.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerAgreements {

	private String saNumber;
	private String saTemplateCode;
	private String saTemplateCodeDesc;
	private String saActivityID;
	private String saARBalance;
	private String saActivityBunit;
	private String saAssignedBunit;
	private String saEffDateYYYYMMDD;
	private String saEffAccountingDateYYYYMMDD;
	private String saInactiveStatus;
	private String saInactiveReason;
	private String saCancelReasonCode;
	private String saSvcLine;
	private String saSvcLineDesc;
	private String saSvcLineRoot;
	private String saSvcAddressSID;
	private String saSvcAddressStreet;
	private String saSvcAddressCity;
	private String saSvcAddressState;
	private String saSvcAddressPostal;
	private String saBilAddressSID;
	private String saBilAddressStreet;
	private String saBilAddressCity;
	private String saBilAddressState;
	private String saBilAddressPostal;
	private List<SAIAutoPay> saiAutoPay;
	private List<InvoiceInfo> invoiceInfo;

	public String getSaNumber() {
		return saNumber;
	}

	@JsonProperty("SANumber")
	public void setSaNumber(String saNumber) {
		this.saNumber = saNumber;
	}

	public String getSaTemplateCode() {
		return saTemplateCode;
	}

	@JsonProperty("SATemplateCode")
	public void setSaTemplateCode(String saTemplateCode) {
		this.saTemplateCode = saTemplateCode;
	}

	public String getSaTemplateCodeDesc() {
		return saTemplateCodeDesc;
	}

	@JsonProperty("SATemplateCodeDesc")
	public void setSaTemplateCodeDesc(String saTemplateCodeDesc) {
		this.saTemplateCodeDesc = saTemplateCodeDesc;
	}

	public String getSaActivityID() {
		return saActivityID;
	}

	@JsonProperty("SAActivityID")
	public void setSaActivityID(String saActivityID) {
		this.saActivityID = saActivityID;
	}

	public String getSaARBalance() {
		return saARBalance;
	}

	@JsonProperty("SAARBalance")
	public void setSaARBalance(String saARBalance) {
		this.saARBalance = saARBalance;
	}

	public String getSaActivityBunit() {
		return saActivityBunit;
	}

	@JsonProperty("SAActivityBunit")
	public void setSaActivityBunit(String saActivityBunit) {
		this.saActivityBunit = saActivityBunit;
	}

	public String getSaAssignedBunit() {
		return saAssignedBunit;
	}

	@JsonProperty("SAAssignedBunit")
	public void setSaAssignedBunit(String saAssignedBunit) {
		this.saAssignedBunit = saAssignedBunit;
	}

	public String getSaEffDateYYYYMMDD() {
		return saEffDateYYYYMMDD;
	}

	@JsonProperty("SAEffDateYYYYMMDD")
	public void setSaEffDateYYYYMMDD(String saEffDateYYYYMMDD) {
		this.saEffDateYYYYMMDD = saEffDateYYYYMMDD;
	}

	public String getSaEffAccountingDateYYYYMMDD() {
		return saEffAccountingDateYYYYMMDD;
	}

	@JsonProperty("SAEffAccountingDateYYYYMMDD")
	public void setSaEffAccountingDateYYYYMMDD(String saEffAccountingDateYYYYMMDD) {
		this.saEffAccountingDateYYYYMMDD = saEffAccountingDateYYYYMMDD;
	}

	public String getSaInactiveStatus() {
		return saInactiveStatus;
	}

	@JsonProperty("SAInactiveStatus")
	public void setSaInactiveStatus(String saInactiveStatus) {
		this.saInactiveStatus = saInactiveStatus;
	}

	public String getSaInactiveReason() {
		return saInactiveReason;
	}

	@JsonProperty("SAInactiveReason")
	public void setSaInactiveReason(String saInactiveReason) {
		this.saInactiveReason = saInactiveReason;
	}

	public String getSaCancelReasonCode() {
		return saCancelReasonCode;
	}

	@JsonProperty("SACancelReasonCode")
	public void setSaCancelReasonCode(String saCancelReasonCode) {
		this.saCancelReasonCode = saCancelReasonCode;
	}

	public String getSaSvcLine() {
		return saSvcLine;
	}

	@JsonProperty("SASvcLine")
	public void setSaSvcLine(String saSvcLine) {
		this.saSvcLine = saSvcLine;
	}

	public String getSaSvcLineDesc() {
		return saSvcLineDesc;
	}

	@JsonProperty("SASvcLineDesc")
	public void setSaSvcLineDesc(String saSvcLineDesc) {
		this.saSvcLineDesc = saSvcLineDesc;
	}

	public String getSaSvcLineRoot() {
		return saSvcLineRoot;
	}

	@JsonProperty("SASvcLineRoot")
	public void setSaSvcLineRoot(String saSvcLineRoot) {
		this.saSvcLineRoot = saSvcLineRoot;
	}

	public String getSaSvcAddressSID() {
		return saSvcAddressSID;
	}

	@JsonProperty("SASvcAddressSID")
	public void setSaSvcAddressSID(String saSvcAddressSID) {
		this.saSvcAddressSID = saSvcAddressSID;
	}

	public String getSaSvcAddressStreet() {
		return saSvcAddressStreet;
	}

	@JsonProperty("SASvcAddressStreet")
	public void setSaSvcAddressStreet(String saSvcAddressStreet) {
		this.saSvcAddressStreet = saSvcAddressStreet;
	}

	public String getSaSvcAddressCity() {
		return saSvcAddressCity;
	}

	@JsonProperty("SASvcAddressCity")
	public void setSaSvcAddressCity(String saSvcAddressCity) {
		this.saSvcAddressCity = saSvcAddressCity;
	}

	public String getSaSvcAddressState() {
		return saSvcAddressState;
	}

	@JsonProperty("SASvcAddressState")
	public void setSaSvcAddressState(String saSvcAddressState) {
		this.saSvcAddressState = saSvcAddressState;
	}

	public String getSaSvcAddressPostal() {
		return saSvcAddressPostal;
	}

	@JsonProperty("SASvcAddressPostal")
	public void setSaSvcAddressPostal(String saSvcAddressPostal) {
		this.saSvcAddressPostal = saSvcAddressPostal;
	}

	public String getSaBilAddressSID() {
		return saBilAddressSID;
	}

	@JsonProperty("SABilAddressSID")
	public void setSaBilAddressSID(String saBilAddressSID) {
		this.saBilAddressSID = saBilAddressSID;
	}

	public String getSaBilAddressStreet() {
		return saBilAddressStreet;
	}

	@JsonProperty("SABilAddressStreet")
	public void setSaBilAddressStreet(String saBilAddressStreet) {
		this.saBilAddressStreet = saBilAddressStreet;
	}

	public String getSaBilAddressCity() {
		return saBilAddressCity;
	}

	@JsonProperty("SABilAddressCity")
	public void setSaBilAddressCity(String saBilAddressCity) {
		this.saBilAddressCity = saBilAddressCity;
	}

	public String getSaBilAddressState() {
		return saBilAddressState;
	}

	@JsonProperty("SABilAddressState")
	public void setSaBilAddressState(String saBilAddressState) {
		this.saBilAddressState = saBilAddressState;
	}

	public String getSaBilAddressPostal() {
		return saBilAddressPostal;
	}

	@JsonProperty("SABilAddressPostal")
	public void setSaBilAddressPostal(String saBilAddressPostal) {
		this.saBilAddressPostal = saBilAddressPostal;
	}

	public List<SAIAutoPay> getSaiAutoPay() {
		return saiAutoPay;
	}

	@JsonProperty("SAIAutoPay")
	public void setSaiAutoPay(List<SAIAutoPay> saiAutoPay) {
		this.saiAutoPay = saiAutoPay;
	}

	public List<InvoiceInfo> getInvoiceInfo() {
		return invoiceInfo;
	}

	@JsonProperty("InvoiceInfo")
	public void setInvoiceInfo(List<InvoiceInfo> pInvoiceInfo) {
		invoiceInfo = pInvoiceInfo;
	}

}
