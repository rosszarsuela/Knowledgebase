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

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

@SuppressWarnings("serial")
@Entity
@Table(name = "brand")
@DataTransferObject(type = "hibernate3")
public class Brand implements Serializable {

	private Long id;
	private String code;
	private String name;
	private String website;
	private CommonsMultipartFile image;
	private String contentType;
	private byte[] picture;
	private CommonsMultipartFile bimage;
	private byte[] bpicture;
	private CommonsMultipartFile pdf;
	private byte[] manual;
	private CommonsMultipartFile pdfimage;
	private byte[] pimage;
	private String description;
	private String manualName;
	private Users createdBy;
	private Date createdDate;
	private Users updatedBy;
	private Date updatedDate;

	// params
	private Integer begin;
	private String orderBy;
	private String sortBy;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BRAND_ID_PK")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
		
	@Column(name = "CODE")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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
	
	@Column(name = "MANUAL_NAME")
	public String getManualName() {
		return manualName;
	}

	public void setManualName(String manualName) {
		this.manualName = manualName;
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
	public String getImageContent() {
		return "data:"+getContentType()+";base64," + Base64.encode(getPicture());
	}
	
	@Transient
	public String getBrandContent() {
		return "data:"+getContentType()+";base64," + Base64.encode(getBpicture());
	}
	
	@Transient
	public String getPdfContent() {
		return "data:"+getContentType()+";base64," + Base64.encode(getManual());
	}
	
	@Transient
	public String getPimageContent(){
		return "data:"+getContentType()+";base64," + Base64.encode(getPimage());
	}
	
	@Transient
	public CommonsMultipartFile getImage() {
		return image;
	}

	public void setImage(CommonsMultipartFile image) {
		this.image = image;
	}
	
	@Column(name="CONTENT_TYPE")
	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
	@Column(name="LOGO")
	public byte[] getPicture() {
		return picture;
	}

	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
	
	@Transient
	public CommonsMultipartFile getBimage() {
		return bimage;
	}

	public void setBimage(CommonsMultipartFile bimage) {
		this.bimage = bimage;
	}
	
	@Column(name = "BRAND_PICTURE")
	public byte[] getBpicture() {
		return bpicture;
	}

	public void setBpicture(byte[] bpicture) {
		this.bpicture = bpicture;
	}
	
	@Transient
	public CommonsMultipartFile getPdf() {
		return pdf;
	}

	public void setPdf(CommonsMultipartFile pdf) {
		this.pdf = pdf;
	}
	
	@Column(name = "BRAND_MANUAL")
	public byte[] getManual() {
		return manual;
	}

	public void setManual(byte[] manual) {
		this.manual = manual;
	}

	@Column(name="WEBSITE")
	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}
	
	@Transient
	public CommonsMultipartFile getPdfimage() {
		return pdfimage;
	}

	public void setPdfimage(CommonsMultipartFile pdfimage) {
		this.pdfimage = pdfimage;
	}
	
	@Column(name="PDF_IMAGE")
	public byte[] getPimage() {
		return pimage;
	}

	public void setPimage(byte[] pimage) {
		this.pimage = pimage;
	}

	@Transient
	public Integer getBegin() {
		return begin;
	}

	public void setBegin(Integer begin) {
		this.begin = begin;
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
