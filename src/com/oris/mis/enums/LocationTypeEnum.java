package com.oris.mis.enums;


public enum LocationTypeEnum {

	INTERNATIONAL(1, "International"),
	LOCAL(2, "Local");

	private Integer id;
	private String description;

	private LocationTypeEnum(Integer id, String description) {
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
	
	public static LocationTypeEnum getInstance(Integer id) {
		for(LocationTypeEnum value :  LocationTypeEnum.values())
			if(value.getId().equals(id)) return value;
		return null;
	}

}
