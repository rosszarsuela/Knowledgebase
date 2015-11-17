package com.oris.mis.enums;


public enum VendorTypeEnum {

	BRANCH(1, "Branch"),
	DEALER(2, "Dealer"), 
	EXHIBIT(3, "Exhibit"),
	OFFICE(4, "Office"),
	RENTED(5, "Rented"),
	UNACCOUNTED(6, "Unaccounted"),
	WAREHOUSE(7, "Warehouse");

	private Integer id;
	private String description;

	private VendorTypeEnum(Integer id, String description) {
		this.id = id;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public static VendorTypeEnum getInstance(Integer id) {
		for(VendorTypeEnum value :  VendorTypeEnum.values())
			if(value.getId().equals(id)) return value;
		return null;
	}

}
