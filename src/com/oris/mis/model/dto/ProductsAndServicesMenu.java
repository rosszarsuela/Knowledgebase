package com.oris.mis.model.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ProductsAndServicesMenu implements Serializable {

	private Long brandId;
	private Long solutionId;
	private String solutionName;
	private String brandName;
	
	public Long getBrandId() {
		return brandId;
	}
	
	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}
	
	public Long getSolutionId() {
		return solutionId;
	}

	public void setSolutionId(Long solutionId) {
		this.solutionId = solutionId;
	}

	public String getSolutionName() {
		return solutionName;
	}
	
	public void setSolutionName(String solutionName) {
		this.solutionName = solutionName;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
}