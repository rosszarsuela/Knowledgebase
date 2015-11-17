package com.oris.enums;


public enum RolesEnum {
	
	SYSTEM_ADMIN(1, "System Admin");
	
	private Integer id;
	private String description;
	
	private RolesEnum(Integer id, String description) {
		this.id=id;
		this.description=description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id=id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description=description;
	}

	public static RolesEnum getInstance(Integer id) {
		for(RolesEnum value :  RolesEnum.values())
			if(value.getId().equals(id)) return value;
		return null;
	}
}
