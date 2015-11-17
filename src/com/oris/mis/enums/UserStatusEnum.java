package com.oris.mis.enums;


public enum UserStatusEnum {

	BOOKS(1, "Books"), 
	MUSICAL_INSTRUMENT(2, "Musical Instrument"),
	PIANO(3, "Piano"),
	PRO_AUDIO(4, "Pro-Audio"),
	SPARE_PARTS(5, "Spare Parts");

	private Integer id;
	private String description;

	private UserStatusEnum(Integer id, String description) {
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
	
	public static UserStatusEnum getInstance(Integer id) {
		for(UserStatusEnum value :  UserStatusEnum.values())
			if(value.getId().equals(id)) return value;
		return null;
	}

}
