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

@SuppressWarnings("serial")
@Entity
@Table(name = "videos")
@DataTransferObject(type = "hibernate3")
public class Videos implements Serializable {
	
	private Long id;
	private String title1;
	private String title2;
	private String title3;
	private String description1;
	private String description2;
	private String description3;
	private String link1;
	private String link2;
	private String link3;
	private Users createdBy;
	private Date createdDate;
	private Users updatedBy;
	private Date updatedDate;
	
	private Integer begin;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "VIDEO_ID_PK")
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="VID_TITLE1")
	public String getTitle1() {
		return title1;
	}
	
	public void setTitle1(String title1) {
		this.title1 = title1;
	}
	
	@Column(name="VID_TITLE2")
	public String getTitle2() {
		return title2;
	}
	
	public void setTitle2(String title2) {
		this.title2 = title2;
	}
	
	@Column(name="VID_TITLE3")
	public String getTitle3() {
		return title3;
	}
	
	public void setTitle3(String title3) {
		this.title3 = title3;
	}
	
	@Column(name="VID_DESC1")
	public String getDescription1() {
		return description1;
	}
	
	public void setDescription1(String description1) {
		this.description1 = description1;
	}
	
	@Column(name="VID_DESC2")
	public String getDescription2() {
		return description2;
	}
	
	public void setDescription2(String description2) {
		this.description2 = description2;
	}
	
	@Column(name="VID_DESC3")
	public String getDescription3() {
		return description3;
	}
	
	public void setDescription3(String description3) {
		this.description3 = description3;
	}
	
	@Column(name="VID_LINK1")
	public String getLink1() {
		return link1;
	}
	
	public void setLink1(String link1) {
		this.link1 = link1;
	}
	
	@Column(name="VID_LINK2")
	public String getLink2() {
		return link2;
	}
	
	public void setLink2(String link2) {
		this.link2 = link2;
	}
	
	@Column(name="VID_LINK3")
	public String getLink3() {
		return link3;
	}
	
	public void setLink3(String link3) {
		this.link3 = link3;
	}
	
	@OneToOne(fetch = FetchType.EAGER, targetEntity = Users.class)
	@JoinColumn(name = "CREATED_BY")
	public Users getCreatedBy() {
		return createdBy;
	}
	
	public void setCreatedBy(Users createdBy) {
		this.createdBy = createdBy;
	}
	
	@Column(name="CREATED_DATE")
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
	
	@Column(name="UPDATED_DATE")
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Transient
	public Integer getBegin() {
		return begin;
	}

	public void setBegin(Integer begin) {
		this.begin = begin;
	}
	
}
