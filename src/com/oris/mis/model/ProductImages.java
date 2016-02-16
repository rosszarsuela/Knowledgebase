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
@Table(name = "product_images")
@DataTransferObject(type = "hibernate3")
public class ProductImages implements Serializable {
	
	private Long id;
	private Product product;
	private String imgDesc;
	private String fileName;
	private CommonsMultipartFile pImg;
	private byte[] pImage;
	private String contentType;
	private Boolean isDeleted;
	private Users createdBy;
	private Date createdDate;
	
	// params
	private Integer begin;
	private String orderBy;
	private String sortBy;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PI_ID_PK")
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@OneToOne(fetch = FetchType.EAGER, targetEntity = Product.class)
    @JoinColumn(name = "PRODUCT_ID_FK")
    public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	@Column(name = "IMAGE_DESC")
	public String getImgDesc() {
		return imgDesc;
	}
	
	public void setImgDesc(String imgDesc) {
		this.imgDesc = imgDesc;
	}
	
	@Column(name = "FILE_NAME")
	public String getFileName() {
		return fileName;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
		
	@Transient
	public CommonsMultipartFile getPImg() {
		return pImg;
	}
	
	public void setpImg(CommonsMultipartFile pImg) {
		this.pImg = pImg;
	}
	
	@Column(name ="IMAGE", columnDefinition="mediumblob") 
	public byte[] getPImage() {
		return pImage;
	}
	
	public void setPImage(byte[] pImage) {
		this.pImage = pImage;
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
		return "data:"+getContentType()+";base64," + Base64.encode(getPImage());
	}
	
	@Column(name = "IS_DELETED")
	public Boolean getIsDeleted() {
		return isDeleted;
	}
	
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
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
