package com.oris.mis.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.directwebremoting.annotations.DataTransferObject;

@SuppressWarnings("serial")
@Entity
@Table(name = "specifications")
@DataTransferObject(type = "hibernate3")
public class Specifications implements Serializable {

	private Long id;
	private String specification;
	private String spec1;
	private String spec2;
	private String spec3;
	private Product product;
	
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SPECIFICATION_ID_PK")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRODUCT_ID_FK", nullable = false)
	public Product getProduct() {
		return product;
	}
	
	@Column(name = "SPECIFICATION")
	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}
	
	@Column(name = "SPEC_DESC_1")
	public String getSpec1() {
		return spec1;
	}

	public void setSpec1(String spec1) {
		this.spec1 = spec1;
	}
	
	@Column(name = "SPEC_DESC_2")
	public String getSpec2() {
		return spec2;
	}

	public void setSpec2(String spec2) {
		this.spec2 = spec2;
	}
	
	@Column(name = "SPEC_DESC_3")
	public String getSpec3() {
		return spec3;
	}

	public void setSpec3(String spec3) {
		this.spec3 = spec3;
	}
		
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
