package com.oris.mis.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
@Table(name = "events")
@DataTransferObject(type = "hibernate3")
public class Event implements Serializable {

	private Long id;
	private String name;
	private String description;
	private Date dateFrom;
	private Date dateTo;
	private String slot;
	private CommonsMultipartFile image;
	private String contentType;
	private String eventContentPDF;
	private byte[] picture;
	private CommonsMultipartFile pdf;
	private byte[] brochure;
	private Integer status;
	private Users createdBy;
	private Date createdDate;
	private Users updatedBy;
	private Date updatedDate;
	private List<Speaker> speakers;
	private Brand brand;

	// params
	private Integer begin;
	private Integer startLimit;
	private Integer endLimit;
	private String orderBy;
	private String sortBy;
	
	public Event() {
		// TODO Auto-generated constructor stub
	}
	
	public Event(Long id) {
		// TODO Auto-generated constructor stub
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EVENT_ID_PK")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "NAME")
	public String getName() {
		return StringUtils.isNotEmpty(name) ? name.toUpperCase() : name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name = "DATE_FROM")
	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}
		
	@Column(name = "SLOT")
	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

	@Column(name = "DATE_TO")
	public Date getDateTo() {
		return dateTo;
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
	
	@Column(name ="PDF_BROCHURE")
	public byte[] getBrochure() {
		return brochure;
	}

	public void setBrochure(byte[] brochure) {
		this.brochure = brochure;
	}
	
	@Transient
	public String getImageContent() {
		return "data:"+getContentType()+";base64," + Base64.encode(getPicture());
	}
	
	@Transient
	public String getPdfContent() {
		return "data:"+getEventContentPDF()+";base64," + Base64.encode(getBrochure());
	}
	
	@Column(name = "EVENT_PDF")
	public String getEventContentPDF() {
		return eventContentPDF;
	}

	public void setEventContentPDF(String eventContentPDF) {
		this.eventContentPDF = eventContentPDF;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
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
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "event")
	public List<Speaker> getSpeakers() {
		return speakers;
	}

	public void setSpeakers(List<Speaker> speakers) {
		this.speakers = speakers;
	}
	
	@OneToOne(fetch = FetchType.EAGER, targetEntity = Brand.class)
	@JoinColumn(name = "BRAND_ID_FK")
	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	
	@Transient
	public String getStatusDesc() {
		return StatusEnum.getInstance(status).getDescription().toUpperCase();
	}
	
	@Transient
	public CommonsMultipartFile getImage() {
		return image;
	}

	public void setImage(CommonsMultipartFile image) {
		this.image = image;
	}
	
	@Transient
	public CommonsMultipartFile getPdf() {
		return pdf;
	}

	public void setPdf(CommonsMultipartFile pdf) {
		this.pdf = pdf;
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

}
