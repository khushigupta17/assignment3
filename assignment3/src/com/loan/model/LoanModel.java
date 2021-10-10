package com.loan.model;

import java.util.Objects;

public class LoanModel {
	private int productId;
	private String productName;
	private double principalAmount;
	private int tenure;
	private float rateOfInterest;
	private boolean isActive;
	private String createdBy;
	private String createdOn;
	private String updatedBy;
	private String updatedOn;
	public LoanModel() {
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public LoanModel(int productId, String productName, float principalAmount, int tenure, float rateOfInterest,
			boolean isActive, String createdBy, String createdOn, String updatedBy, String updatedOn) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.principalAmount = principalAmount;
		this.tenure = tenure;
		this.rateOfInterest = rateOfInterest;
		this.isActive = isActive;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.updatedBy = updatedBy;
		this.updatedOn = updatedOn;
	}
	public LoanModel(int productId, String productName, double principalAmount, int tenure, float rateOfInterest){
		super();
		this.productId = productId;
		this.productName = productName;
		this.principalAmount = principalAmount;
		this.tenure = tenure;
		this.rateOfInterest = rateOfInterest;
	}
	public double getPrincipalAmount() {
		return principalAmount;
	}
	public void setPrincipalAmount(double amount) {
		this.principalAmount = amount;
	}
	public int getTenure() {
		return tenure;
	}
	public void setTenure(int tenure) {
		this.tenure = tenure;
	}
	public float getRateOfInterest() {
		return rateOfInterest;
	}
	public void setRateOfInterest(float rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}
	@Override
	public int hashCode() {
		return Objects.hash(productId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoanModel other = (LoanModel) obj;
		return productId == other.productId;
	}
	
}
