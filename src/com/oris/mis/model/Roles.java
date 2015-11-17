package com.oris.mis.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang.StringUtils;
import org.directwebremoting.annotations.DataTransferObject;

@Entity
@Table(name="roles")
@DataTransferObject
public class Roles implements Serializable{
	private static final long serialVersionUID = -1853604211751539983L;
	private Integer id;
	private String description;	
	
	@Id 	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ROLE_ID_PK")
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="ROLE_DESCRIPTION")
	public String getDescription() {
		return StringUtils.isNotEmpty(description) ? description.toUpperCase() : description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
