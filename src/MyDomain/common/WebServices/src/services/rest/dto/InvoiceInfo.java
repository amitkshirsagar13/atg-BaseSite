package services.rest.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <p>
 * <b>Overview:</b>
 * <p>
 * 
 * <pre>
 * @Project: BaseSite
 * Creation date: Jun 29, 2015
 * @author Amit Kshirsagar
 * @version 1.0
 * @since
 * 
 * <p><b>Modification History:</b><p>
 * 
 * 
 * </pre>
 */

public class InvoiceInfo {
	private String invoiceNumber;
	private String invoiceDateYYYYMMDD;
	private String invoiceAmount;
	private String invoiceBalanceAmount;
	private String invoiceStatus;
	private String bilPartyName;
	private String bilAddressStreet;
	private String bilAddressCity;
	private String bilAddressState;
	private String bilAddressPostal;
	private List<InvoiceItems> invoiceItems;

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	@JsonProperty("InvoiceNumber")
	public void setInvoiceNumber(String pInvoiceNumber) {
		invoiceNumber = pInvoiceNumber;
	}

	public String getInvoiceDateYYYYMMDD() {
		return invoiceDateYYYYMMDD;
	}

	@JsonProperty("InvoiceDateYYYYMMDD")
	public void setInvoiceDateYYYYMMDD(String pInvoiceDateYYYYMMDD) {
		invoiceDateYYYYMMDD = pInvoiceDateYYYYMMDD;
	}

	public String getInvoiceAmount() {
		return invoiceAmount;
	}

	@JsonProperty("InvoiceAmount")
	public void setInvoiceAmount(String pInvoiceAmount) {
		invoiceAmount = pInvoiceAmount;
	}

	public String getInvoiceBalanceAmount() {
		return invoiceBalanceAmount;
	}

	@JsonProperty("InvoiceBalanceAmount")
	public void setInvoiceBalanceAmount(String pInvoiceBalanceAmount) {
		invoiceBalanceAmount = pInvoiceBalanceAmount;
	}

	public String getInvoiceStatus() {
		return invoiceStatus;
	}

	@JsonProperty("InvoiceStatus")
	public void setInvoiceStatus(String pInvoiceStatus) {
		invoiceStatus = pInvoiceStatus;
	}

	public String getBilPartyName() {
		return bilPartyName;
	}

	@JsonProperty("BilPartyName")
	public void setBilPartyName(String pBilPartyName) {
		bilPartyName = pBilPartyName;
	}

	public String getBilAddressStreet() {
		return bilAddressStreet;
	}

	@JsonProperty("BilAddressStreet")
	public void setBilAddressStreet(String pBilAddressStreet) {
		bilAddressStreet = pBilAddressStreet;
	}

	public String getBilAddressCity() {
		return bilAddressCity;
	}

	@JsonProperty("BilAddressCity")
	public void setBilAddressCity(String pBilAddressCity) {
		bilAddressCity = pBilAddressCity;
	}

	public String getBilAddressState() {
		return bilAddressState;
	}

	@JsonProperty("BilAddressState")
	public void setBilAddressState(String pBilAddressState) {
		bilAddressState = pBilAddressState;
	}

	public String getBilAddressPostal() {
		return bilAddressPostal;
	}

	@JsonProperty("BilAddressPostal")
	public void setBilAddressPostal(String pBilAddressPostal) {
		bilAddressPostal = pBilAddressPostal;
	}

	public List<InvoiceItems> getInvoiceItems() {
		return invoiceItems;
	}

	@JsonProperty("InvoiceItems")
	public void setInvoiceItems(List<InvoiceItems> pInvoiceItems) {
		invoiceItems = pInvoiceItems;
	}
}
