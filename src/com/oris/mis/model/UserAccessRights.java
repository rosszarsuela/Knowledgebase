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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author Ross Zarsuela
 *
 */

@Entity
@Table(name="user_access_rights")
public class UserAccessRights implements Serializable{
	private static final long serialVersionUID = -4449417019688485186L;
	private Long id;
	private Users user;
	private String module;
	private String function;
	private String url;
	private Integer status;
	
	private Users createdBy;
	private Date createDate;
	private Users updatedBy;
	private Date updateDate;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="USR_ID_PK")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne(fetch=FetchType.EAGER, targetEntity=Users.class)
	@JoinColumn(name="USR_USER")
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	
	@Column(name="USR_MODULE")
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	
	@Column(name="USR_FUNCTION")
	public String getFunction() {
		return function;
	}
	public void setFunction(String function) {
		this.function = function;
	}
	
	@Column(name="USR_URL")
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Column(name="USR_STATUS")
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	@ManyToOne(fetch=FetchType.EAGER, targetEntity=Users.class)
	@JoinColumn(name="USR_CREATED_BY")
	public Users getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Users createdBy) {
		this.createdBy = createdBy;
	}
	
	@Column(name="USR_CREATE_DATE")
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	@ManyToOne(fetch=FetchType.EAGER, targetEntity=Users.class)
	@JoinColumn(name="USR_UPDATED_BY")
	public Users getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Users updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	@Column(name="USR_UPDATED_DATE")
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}
