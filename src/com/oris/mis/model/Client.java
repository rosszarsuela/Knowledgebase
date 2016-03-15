package com.oris.mis.model;

import java.util.Date;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.directwebremoting.annotations.DataTransferObject;

@SuppressWarnings("serial")
@Entity
@Table(name = "clients")
@DataTransferObject(type = "hibernate3")
public class Client implements Serializable {

	private Long id;
	private String message;
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String contactNo;
	private String alcontactNo;
	private Date createdDate;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CLIENT_ID_PK")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "MESSAGE")
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	@Column(name = "FIRST_NAME")
	public String getfirstName() {
		return firstName;
	}
	
	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "MIDDLE_NAME")
	public String getmiddleName() {
		return middleName;
	}

	public void setmiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Column(name = "LAST_NAME")
	public String getlastName() {
		return lastName;
	}

	public void setlastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name = "EMAIL")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column (name ="CONTACT_NO")
	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	
	@Column (name ="AL_CONTACT_NO")
	public String getAlcontactNo() {
		return alcontactNo;
	}

	public void setAlcontactNo(String alcontactNo) {
		this.alcontactNo = alcontactNo;
	}
	
	@Column(name ="CREATED_DATE")	
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@Transient
	public String getCompleteName() {
		return getfirstName() + " " + getmiddleName().substring(0, 1) + ". " + getlastName();
	}

}
