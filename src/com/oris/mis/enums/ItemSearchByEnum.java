package com.oris.mis.enums;


public enum ItemSearchByEnum {

	AJPC(1, "AJPC Code", "i.ajpcCode"), 
	BRAND(2, "Brand", "i.brand.name"),
	CATEGORY(3, "Category", "i.category.description"),
	DESCRIPTION(4, "Description", "i.description"),
	ITEM_CODE(5, "Item Code", "i.itemCode"),
	MODEL(6, "Model", "i.model");

	private Integer id;
	private String value;
	private String label;

	private ItemSearchByEnum(Integer id, String label, String value) {
		this.id = id;
		this.label = label;
		this.value = value;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
}
