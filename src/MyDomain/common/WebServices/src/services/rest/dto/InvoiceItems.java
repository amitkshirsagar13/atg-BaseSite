package services.rest.dto;

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

public class InvoiceItems {

	private String invoiceItemActID;
	private String sANumber;
	private String invoiceItemSID;
	private String invoiceItemDate;
	private String debitReason;
	private String invoiceItemType;
	private String svcAddressStreet;
	private String svcAddressCity;
	private String svcAddressState;
	private String svcAddressPostal;
	private String invoiceItemStatus;
	private String workOrderActID;
	private String workOrderCompletionDate;
	private String invoiceItemBaseAmount;
	private String invoiceItemDiscounts;
	private String invoiceItemFees;
	private String invoiceItemTaxes;
	private String invoiceItemOtherCharges;
	private String activityType;
	private String serviceType;
	private String lastStatus;
	private String cancelReason;
	private String cancelDateYYYYMMDD;
	private String dueDateYYYYMMDD;
	private String invoiceItemCompletedAmount;
	private String invoiceItemCompletionDateYYYYMMDD;

	public String getInvoiceItemActID() {
		return invoiceItemActID;
	}

	@JsonProperty("InvoiceItemActID")
	public void setInvoiceItemActID(String pInvoiceItemActID) {
		invoiceItemActID = pInvoiceItemActID;
	}

	public String getSANumber() {
		return sANumber;
	}

	@JsonProperty("SANumber")
	public void setSANumber(String pSANumber) {
		sANumber = pSANumber;
	}

	public String getInvoiceItemSID() {
		return invoiceItemSID;
	}

	@JsonProperty("InvoiceItemSID")
	public void setInvoiceItemSID(String pInvoiceItemSID) {
		invoiceItemSID = pInvoiceItemSID;
	}

	public String getInvoiceItemDate() {
		return invoiceItemDate;
	}

	@JsonProperty("InvoiceItemDate")
	public void setInvoiceItemDate(String pInvoiceItemDate) {
		invoiceItemDate = pInvoiceItemDate;
	}

	public String getDebitReason() {
		return debitReason;
	}

	@JsonProperty("DebitReason")
	public void setDebitReason(String pDebitReason) {
		debitReason = pDebitReason;
	}

	public String getInvoiceItemType() {
		return invoiceItemType;
	}

	@JsonProperty("InvoiceItemType")
	public void setInvoiceItemType(String pInvoiceItemType) {
		invoiceItemType = pInvoiceItemType;
	}

	public String getSvcAddressStreet() {
		return svcAddressStreet;
	}

	@JsonProperty("SvcAddressStreet")
	public void setSvcAddressStreet(String pSvcAddressStreet) {
		svcAddressStreet = pSvcAddressStreet;
	}

	public String getSvcAddressCity() {
		return svcAddressCity;
	}

	@JsonProperty("SvcAddressCity")
	public void setSvcAddressCity(String pSvcAddressCity) {
		svcAddressCity = pSvcAddressCity;
	}

	public String getSvcAddressState() {
		return svcAddressState;
	}

	@JsonProperty("SvcAddressState")
	public void setSvcAddressState(String pSvcAddressState) {
		svcAddressState = pSvcAddressState;
	}

	public String getSvcAddressPostal() {
		return svcAddressPostal;
	}

	@JsonProperty("SvcAddressPostal")
	public void setSvcAddressPostal(String pSvcAddressPostal) {
		svcAddressPostal = pSvcAddressPostal;
	}

	public String getInvoiceItemStatus() {
		return invoiceItemStatus;
	}

	@JsonProperty("InvoiceItemStatus")
	public void setInvoiceItemStatus(String pInvoiceItemStatus) {
		invoiceItemStatus = pInvoiceItemStatus;
	}

	public String getWorkOrderActID() {
		return workOrderActID;
	}

	@JsonProperty("WorkOrderActID")
	public void setWorkOrderActID(String pWorkOrderActID) {
		workOrderActID = pWorkOrderActID;
	}

	public String getWorkOrderCompletionDate() {
		return workOrderCompletionDate;
	}

	@JsonProperty("WorkOrderCompletionDate")
	public void setWorkOrderCompletionDate(String pWorkOrderCompletionDate) {
		workOrderCompletionDate = pWorkOrderCompletionDate;
	}

	public String getInvoiceItemBaseAmount() {
		return invoiceItemBaseAmount;
	}

	@JsonProperty("InvoiceItemBaseAmount")
	public void setInvoiceItemBaseAmount(String pInvoiceItemBaseAmount) {
		invoiceItemBaseAmount = pInvoiceItemBaseAmount;
	}

	public String getInvoiceItemDiscounts() {
		return invoiceItemDiscounts;
	}

	@JsonProperty("InvoiceItemDiscounts")
	public void setInvoiceItemDiscounts(String pInvoiceItemDiscounts) {
		invoiceItemDiscounts = pInvoiceItemDiscounts;
	}

	public String getInvoiceItemFees() {
		return invoiceItemFees;
	}

	@JsonProperty("InvoiceItemFees")
	public void setInvoiceItemFees(String pInvoiceItemFees) {
		invoiceItemFees = pInvoiceItemFees;
	}

	public String getInvoiceItemTaxes() {
		return invoiceItemTaxes;
	}

	@JsonProperty("InvoiceItemTaxes")
	public void setInvoiceItemTaxes(String pInvoiceItemTaxes) {
		invoiceItemTaxes = pInvoiceItemTaxes;
	}

	public String getInvoiceItemOtherCharges() {
		return invoiceItemOtherCharges;
	}

	@JsonProperty("InvoiceItemOtherCharges")
	public void setInvoiceItemOtherCharges(String pInvoiceItemOtherCharges) {
		invoiceItemOtherCharges = pInvoiceItemOtherCharges;
	}

	public String getActivityType() {
		return activityType;
	}

	@JsonProperty("ActivityType")
	public void setActivityType(String pActivityType) {
		activityType = pActivityType;
	}

	public String getServiceType() {
		return serviceType;
	}

	@JsonProperty("ServiceType")
	public void setServiceType(String pServiceType) {
		serviceType = pServiceType;
	}

	public String getLastStatus() {
		return lastStatus;
	}

	@JsonProperty("LastStatus")
	public void setLastStatus(String pLastStatus) {
		lastStatus = pLastStatus;
	}

	public String getCancelReason() {
		return cancelReason;
	}

	@JsonProperty("CancelReason")
	public void setCancelReason(String pCancelReason) {
		cancelReason = pCancelReason;
	}

	public String getCancelDateYYYYMMDD() {
		return cancelDateYYYYMMDD;
	}

	@JsonProperty("CancelDateYYYYMMDD")
	public void setCancelDateYYYYMMDD(String pCancelDateYYYYMMDD) {
		cancelDateYYYYMMDD = pCancelDateYYYYMMDD;
	}

	public String getDueDateYYYYMMDD() {
		return dueDateYYYYMMDD;
	}

	@JsonProperty("DueDateYYYYMMDD")
	public void setDueDateYYYYMMDD(String pDueDateYYYYMMDD) {
		dueDateYYYYMMDD = pDueDateYYYYMMDD;
	}

	public String getInvoiceItemCompletedAmount() {
		return invoiceItemCompletedAmount;
	}

	@JsonProperty("InvoiceItemCompletedAmount")
	public void setInvoiceItemCompletedAmount(String pInvoiceItemCompletedAmount) {
		invoiceItemCompletedAmount = pInvoiceItemCompletedAmount;
	}

	public String getInvoiceItemCompletionDateYYYYMMDD() {
		return invoiceItemCompletionDateYYYYMMDD;
	}

	@JsonProperty("InvoiceItemCompletionDateYYYYMMDD")
	public void setInvoiceItemCompletionDateYYYYMMDD(String pInvoiceItemCompletionDateYYYYMMDD) {
		invoiceItemCompletionDateYYYYMMDD = pInvoiceItemCompletionDateYYYYMMDD;
	}

}
