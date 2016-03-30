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
@Table(name = "product")
@DataTransferObject(type = "hibernate3")
public class Product implements Serializable {

	private Long id;
	private SolutionsCategory category;
	private Brand brand;
	private String name;
	private String description;
	private String remarks;
	private CommonsMultipartFile image;
	private String contentType;
	private String manualContentType;
	private byte[] picture;
	private CommonsMultipartFile pdf;
	private byte[] manual;
	private List<ProductImages> productImages;
	private Integer status;
	private Users createdBy;
	private Date createdDate;
	private Users updatedBy;
	private Date updatedDate;
	private List<Specifications> specs;
/*	private Event event;*/
	

	// params
	private Integer begin;
	private Integer startLimit;
	private Integer endLimit;
	private String orderBy;
	private String sortBy;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	public Product(Long id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRODUCT_ID_PK")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
		
	@OneToOne(fetch = FetchType.EAGER, targetEntity = SolutionsCategory.class, optional=true)
	@JoinColumn(name = "SOL_CAT_ID_FK")
	public SolutionsCategory getCategory() {
		return category;
	}

	public void setCategory(SolutionsCategory category) {
		this.category = category;
	}

	@OneToOne(fetch = FetchType.EAGER, targetEntity = Brand.class)
	@JoinColumn(name = "BRAND_ID_FK")
	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	
	/*@OneToOne(fetch = FetchType.EAGER, targetEntity = Event.class)
	@JoinColumn(name = "EVENT_ID_FK")
	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}*/
	
	@Column(name = "REMARKS")
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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

	@Column(name = "CONTENT_TYPE")
	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
	@Column(name = "MANUAL_CONTENT_TYPE")
	public String getManualContentType() {
		return manualContentType;
	}

	public void setManualContentType(String manualContentType) {
		this.manualContentType = manualContentType;
	}

	@Column(name = "PICTURE")
	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
	
	@Transient
	public String getImageContent() {
		return "data:"+getContentType()+";base64," + Base64.encode(getPicture());
	}
	 
	@Transient
	public String getPdfContent() {
		return "data:"+getManualContentType()+";base64," + Base64.encode(getManual());
	}

	@Column(name ="PDF_MANUAL")
	public byte[] getManual() {
		return manual;
	}

	public void setManual(byte[] manual) {
		this.manual = manual;
	}
	
	
	public void setProductImages(List<ProductImages> productImages) {
		this.productImages = productImages;
	}
	
	@OneToMany(fetch = FetchType.LAZY, targetEntity = ProductImages.class, mappedBy = "product")
	public List<ProductImages> getProductImages() {
		return productImages;
	}

	@Column(name = "STATUS")
	public Integer getStatus() {
		return status;
	}	

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
	public List<Specifications> getSpecs() {
		return specs;
	}

	public void setSpecs(List<Specifications> specs) {
		this.specs = specs;
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
