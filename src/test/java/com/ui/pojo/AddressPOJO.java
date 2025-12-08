package com.ui.pojo;

public class AddressPOJO {
	
	private String companyName;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String postCode;
	private String homePhone;
	private String mobilePhone;
	private String otherInformation;
	private String addressAlias;
	private String state;
	public AddressPOJO(String companyName, String addressLine1, String addressLine2, String city, String postCode,
			String homePhone, String mobilePhone, String otherInformation, String addressAlias, String state) {
		super();
		this.companyName = companyName;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.postCode = postCode;
		this.homePhone = homePhone;
		this.mobilePhone = mobilePhone;
		this.otherInformation = otherInformation;
		this.addressAlias = addressAlias;
		this.state = state;
	}
	public String getCompanyName() {
		return companyName;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public String getCity() {
		return city;
	}

	public String getPostCode() {
		return postCode;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public String getOtherInformation() {
		return otherInformation;
	}

	public String getAddressAlias() {
		return addressAlias;
	}

	public String getState() {
		return state;
	}
	
	@Override
	public String toString() {
		return "AddressPOJO [companyName=" + companyName + ", addressLine1=" + addressLine1 + ", addressLine2="
				+ addressLine2 + ", city=" + city + ", postCode=" + postCode + ", homePhone=" + homePhone
				+ ", mobilePhone=" + mobilePhone + ", otherInformation=" + otherInformation + ", addressAlias="
				+ addressAlias + ", state=" + state + "]";
	}

	
	

}
