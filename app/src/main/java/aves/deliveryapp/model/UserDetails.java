package aves.deliveryapp.model;

import java.util.ArrayList;
import java.util.List;

public class UserDetails {

	private Long id;
	private String userId;
	private String password;
	private Long orgId;
	private String fullName;
	private String orgName;
	private List<String> locationDetails = new ArrayList<String>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public List<String> getLocationDetails() {
		return locationDetails;
	}

	public void setLocationDetails(List<String> locationDetails) {
		this.locationDetails = locationDetails;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

}