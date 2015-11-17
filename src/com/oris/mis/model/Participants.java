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

import org.directwebremoting.annotations.DataTransferObject;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;


@SuppressWarnings("serial")
@Entity
@Table(name = "participants")
@DataTransferObject(type = "hibernate3") 

public class Participants implements Serializable {

	private Long id;
		private String lastName;
		private String middleName;
		private String firstName;
		private String contactNo;
		private String email;
		private String building;
		private String street;
		private String city;
		private String province;
		private Integer landline;
		private String coupon;
		private Date createdDate;
		private String payment;
		private CommonsMultipartFile image;
		private byte[] picture;
		private String contentType;
		private Event event;

		// params
		private String search;
		private Integer begin;
		private Integer startLimit;
		private Integer endLimit;
		private String orderBy;
		private String sortBy;

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "PARTICIPANT_ID_PK")
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
		
		@Column(name = "BUILDING")
		public String getBuilding() {
			return building;
		}

		public void setBuilding(String building) {
			this.building = building;
		}
		
		@Column(name = "STREET")
		public String getStreet() {
			return street;
		}

		public void setStreet(String street) {
			this.street = street;
		}
		
		@Column(name = "CITY")
		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}
		
		@Column(name = "PROVINCE")
		public String getProvince() {
			return province;
		}

		public void setProvince(String province) {
			this.province = province;
		}
		
		@Column(name = "LANDLINE")
		public Integer getLandline() {
			return landline;
		}
		
		@Column(name = "COUPON")
		public String getCoupon() {
			return coupon;
		}

		public void setCoupon(String coupon) {
			this.coupon = coupon;
		}

		public void setLandline(Integer landline) {
			this.landline = landline;
		}

		@Column(name = "CREATED_DATE")
		public Date getCreatedDate() {
			return createdDate;
		}

		public void setCreatedDate(Date createDate) {
			this.createdDate = createDate;
		}
		
		@OneToOne(fetch = FetchType.EAGER, targetEntity = Event.class)
		@JoinColumn(name = "EVENT_ID_FK")
		public Event getEvent() {
			return event;
		}

		public void setEvent(Event event) {
			this.event = event;
		}
		
		@Column(name = "PAYMENT")
		public String getPayment() {
			return payment;
		}

		public void setPayment(String payment) {
			this.payment = payment;
		}
		
		@Column(name = "DEPOSIT_SLIP")
		public byte[] getPicture() {
			return picture;
		}

		public void setPicture(byte[] picture) {
			this.picture = picture;
		}
		
		@Column(name = "CONTENT_TYPE")
		public String getContentType() {
			return contentType;
		}

		public void setContentType(String contentType) {
			this.contentType = contentType;
		}

		@Transient
		public String getImageContent() {
			return "data:"+getContentType()+";base64," + Base64.encode(getPicture());
		}
		
		@Transient
		public CommonsMultipartFile getImage() {
			return image;
		}

		public void setImage(CommonsMultipartFile image) {
			this.image = image;
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
		
		@Transient
		public String getCompleteName() {
			return getFirstName() + " " + getMiddleName().substring(0, 1) + ". " + getLastName();
		}
	}
