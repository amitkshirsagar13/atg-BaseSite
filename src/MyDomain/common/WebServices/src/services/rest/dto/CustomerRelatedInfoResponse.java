package services.rest.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerRelatedInfoResponse {

	private String customerNumber;
	private String customerName;
	private String customerARBalance;
	private String customerPartyId;
	private String customerOwningBunit;
	private String customerSellingBunit;
	private String customerAgreementCount;
	private List<CustomerAgreements> customerAgreements;

	public String getCustomerNumber() {
		return customerNumber;
	}

	@JsonProperty("CustomerNumber")
	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	@JsonProperty("CustomerName")
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerARBalance() {
		return customerARBalance;
	}

	@JsonProperty("CustomerARBalance")
	public void setCustomerARBalance(String customerARBalance) {
		this.customerARBalance = customerARBalance;
	}

	public String getCustomerPartyId() {
		return customerPartyId;
	}

	@JsonProperty("CustomerPartyId")
	public void setCustomerPartyId(String customerPartyId) {
		this.customerPartyId = customerPartyId;
	}

	public String getCustomerOwningBunit() {
		return customerOwningBunit;
	}

	@JsonProperty("CustomerOwningBunit")
	public void setCustomerOwningBunit(String customerOwningBunit) {
		this.customerOwningBunit = customerOwningBunit;
	}

	public String getCustomerSellingBunit() {
		return customerSellingBunit;
	}

	@JsonProperty("CustomerSellingBunit")
	public void setCustomerSellingBunit(String customerSellingBunit) {
		this.customerSellingBunit = customerSellingBunit;
	}

	public String getCustomerAgreementCount() {
		return customerAgreementCount;
	}

	@JsonProperty("CustomerAgreementCount")
	public void setCustomerAgreementCount(String customerAgreementCount) {
		this.customerAgreementCount = customerAgreementCount;
	}

	public List<CustomerAgreements> getCustomerAgreements() {
		return customerAgreements;
	}

	@JsonProperty("CustomerAgreements")
	public void setCustomerAgreements(List<CustomerAgreements> customerAgreements) {
		this.customerAgreements = customerAgreements;
	}
}
