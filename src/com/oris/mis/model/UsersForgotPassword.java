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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.directwebremoting.annotations.DataTransferObject;

@Entity
@Table(name = "USERS_FORGOT_PASS")
@DataTransferObject(type = "hibernate3")
public class UsersForgotPassword implements Serializable{
	
	private static final long serialVersionUID = -8955897206335307495L;
	
	private Long id;
	private Date dateRequested;
	private Users user;
	private Integer status; //if active or inactive MISEnum
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "UFP_ID_PK")
	public Long getId() { return id; }
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UFP_DATE_REQUEST")
	public Date getDateRequested() { return dateRequested; }
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Users.class)
	@JoinColumn(name = "UFP_USER_ID_FK")
	public Users getUser() {return user;}
	
	@Column(name = "UFP_STATUS")
	public Integer getStatus() { return status; }
	
	
	public void setId(Long id) { this.id = id; }
	public void setDateRequested(Date dateRequested) { this.dateRequested = dateRequested; }
	public void setUser(Users user) {this.user = user;}
	public void setStatus(Integer status) { this.status = status; }
	
	
}
