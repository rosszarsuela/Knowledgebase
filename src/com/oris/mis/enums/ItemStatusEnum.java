package com.oris.mis.enums;


public enum ItemStatusEnum {

	DEFECTIVE(1, "Defective"), GOOD(2, "Good");

	private Integer id;
	private String description;

	private ItemStatusEnum(Integer id, String description) {
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
	
	public static ItemStatusEnum getInstance(Integer id) {
		for(ItemStatusEnum value :  ItemStatusEnum.values())
			if(value.getId().equals(id)) return value;
		return null;
	}

}
