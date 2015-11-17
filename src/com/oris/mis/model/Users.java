package com.oris.mis.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.StringUtils;
import org.directwebremoting.annotations.DataTransferObject;

import com.oris.enums.RolesEnum;
import com.oris.enums.StatusEnum;

@Entity
@Table(name = "users")
@DataTransferObject(type="hibernate3")
public class Users implements Serializable {

    private static final long serialVersionUID = -7682271432242791376L;
    private String username;
    private String password;
    private String confirmPassword;
    private Roles role;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    private Integer status;
    private Users createdBy;
    private Date createdDate;
    private Users updatedBy;
	private Date updatedDate;
	
	public final static String className = "users";
	public final static String classId = "username";

    public Users() {
	}
    
    public Users(String username) {
		this.username = username;
	}
    
    @Id
    @Column(name = "USERNAME_PK")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Transient
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @OneToOne(fetch = FetchType.EAGER, targetEntity = Roles.class)
    @JoinColumn(name = "ROLE_ID_FK")
    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

	@Transient
    public String getRoleDesc() {
    	return role != null & role.getId() != null ? RolesEnum.getInstance(role.getId()).getDescription().toUpperCase() : "N/A";
    }    

	@Column(name = "FIRSTNAME")
    public String getFirstName() {
        return StringUtils.isNotEmpty(firstName) ? firstName.toUpperCase() : firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "MIDDLENAME")
    public String getMiddleName() {
        return StringUtils.isNotEmpty(middleName) ? middleName.toUpperCase() : middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Column(name = "LASTNAME")
    public String getLastName() {
        return StringUtils.isNotEmpty(lastName) ? lastName.toUpperCase() : lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    public String getCompleteName() {
		return firstName + " " + middleName.charAt(0) + ". " + lastName;
    }
    
    @Transient
    public String getFullName() {
    	return firstName + " " + middleName + " " + lastName;
    }

    @Transient
    public String getInitials() {
    	return ""+ firstName.charAt(0) + middleName.charAt(0) + lastName.charAt(0);
    }
    
    @Transient
    public String getStatusDesc() {
    	return StatusEnum.getInstance(status).getDescription().toUpperCase();
    }
}