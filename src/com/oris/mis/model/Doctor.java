package com.oris.mis.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.StringUtils;
import org.directwebremoting.annotations.DataTransferObject;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.oris.enums.StatusEnum;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

@SuppressWarnings("serial")
@Entity
@Table(name = "doctor")
@DataTransferObject(type = "hibernate3")
public class Doctor implements Serializable {

	private Long id;
	private String lastName;
	private String middleName;
	private String firstName;
	private String school1;
	private String school2;
	private String course1;
	private String course2;
	private String contactNo;
	private String email;
	private String profession;
	private String title;
	private CommonsMultipartFile image;
	private String contentType;
	private byte[] picture;
	private Integer status;
	private Users createdBy;
	private Date createdDate;
	private Users updatedBy;
	private Date updatedDate;

	// params
	private String search;
	private Integer begin;
	private Integer startLimit;
	private Integer endLimit;
	private String orderBy;
	private String sortBy;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DOCTOR_ID_PK")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "LAST_NAME")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "MIDDLE_NAME")
	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Column(name = "FIRST_NAME")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name = "SCHOOL_NAME1" )
	public String getSchool1() {
		return school1; 
	}

	public void setSchool1(String school1) {
		this.school1 = school1;
	}
	
	@Column(name = "SCHOOL_NAME2")
	public String getSchool2() {
		return school2;
	}
	
	public void setSchool2(String school2) {
		this.school2 = school2;
	}
	
	@Column(name = "COURSE_NAME1")
	public String getCourse1() {
		return course1;
	}

	public void setCourse1(String course1) {
		this.course1 = course1;
	}
	
	@Column(name = "COURSE_NAME2")
	public String getCourse2() {
		return course2;
	}

	public void setCourse2(String course2) {
		this.course2 = course2;
	}

	
	@Column(name = "CONTACT_NO")
	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	@Column(name = "EMAIL")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "PROFESSION")
	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	@Column(name = "CONTENT_TYPE")
	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	@Column(name = "PICTURE")
	public byte[] getPicture() {
		return picture;
	}
	
	public void setPicture(byte[] picture) {
		this.picture = picture;
	}

	@Column(name = "STATUS")
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@OneToOne(fetch = FetchType.EAGER, targetEntity = Users.class)
	@JoinColumn(name = "CREATED_BY")
	public Users getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Users createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "CREATED_DATE")
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@OneToOne(fetch = FetchType.EAGER, targetEntity = Users.class)
	@JoinColumn(name = "UPDATED_BY")
	public Users getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Users updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Column(name = "UPDATED_DATE")
	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	@Transient
	public CommonsMultipartFile getImage() {
		return image;
	}

	public void setImage(CommonsMultipartFile image) {
		this.image = image;
	}
	
	@Transient
	public String getImageContent() {
		return "data:"+getContentType()+";base64," + Base64.encode(getPicture());
	}
	
	@Transient
	public String getStatusDesc(){
		return StatusEnum.getInstance(status).getDescription().toUpperCase();
	}
			
	@Transient
	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	@Transient
	public Integer getBegin() {
		return begin;
	}

	public void setBegin(Integer begin) {
		this.begin = begin;
	}
	
	@Transient
	public Integer getStartLimit() {
		return startLimit;
	}

	public void setStartLimit(Integer startLimit) {
		this.startLimit = startLimit;
	}

	@Transient
	public Integer getEndLimit() {
		return endLimit;
	}

	public void setEndLimit(Integer endLimit) {
		this.endLimit = endLimit;
	}

	@Transient
	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	@Transient
	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	
	@Column(name = "TITLE")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Transient
	public String getCompleteName() {
		return getFirstName() + " " + getMiddleName().substring(0, 1) + ". " + getLastName() + ", " + getTitle();
	}
	
	@Transient
	public String getFullCourse1() {
		return "(" + getCourse1() + ")";
	}
	
	@Transient
	public String getFullCourse2() {
		return "(" + getCourse2() + ")";
	}
}
