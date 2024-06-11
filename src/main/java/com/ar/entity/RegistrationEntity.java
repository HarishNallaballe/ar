package com.ar.entity;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RegistrationEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer appNumber;
	private String name;
	private LocalDate dob;
	private Long ssn;
	private String gender;
	private Integer planId;
	private Integer citizenId;
	@CreationTimestamp
	@Column(name="CREATED_DATE",updatable = false)
	private Date createdDate;
	@UpdateTimestamp
	@Column(name="UPDATED_DATE",insertable = false)
	private Date updatedDate;
	public Integer getAppNumber() {
		return appNumber;
	}
	public void setAppNumber(Integer appNumber) {
		this.appNumber = appNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getSsn() {
		return ssn;
	}
	public void setSsn(Long ssn) {
		this.ssn = ssn;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public Integer getPlanId() {
		return planId;
	}
	public void setPlanId(Integer planId) {
		this.planId = planId;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public RegistrationEntity() {
		super();
	}
	
	public Integer getCitizenId() {
		return citizenId;
	}
	public void setCitizenId(Integer citizenId) {
		this.citizenId = citizenId;
	}
	public LocalDate getDob() {
		return dob;
	}
	public RegistrationEntity(String name, LocalDate dob, Long ssn, String gender, Integer planId, Date createdDate,
			Date updatedDate) {
		super();
		this.name = name;
		this.dob = dob;
		this.ssn = ssn;
		this.gender = gender;
		this.planId = planId;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}
	@Override
	public String toString() {
		return "RegistrationEntity [appNumber=" + appNumber + ", name=" + name + ", dob=" + dob + ", ssn=" + ssn
				+ ", gender=" + gender + ", planId=" + planId + ", createdDate=" + createdDate + ", updatedDate="
				+ updatedDate + "]";
	}
	
}
