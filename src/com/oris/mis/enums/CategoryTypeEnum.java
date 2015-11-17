package com.oris.mis.enums;


public enum CategoryTypeEnum {

	BOOKS(1, "Books"),
	MUSICAL_INSTRUMENT(2, "Musical Instrument"),
	OFFICE(3, "Office Equipments"),
	PIANO(4, "Piano"),
	PRO_AUDIO(5, "Pro-Audio"),
	SPARE_PARTS(6, "Spare Parts");

	private Integer id;
	private String description;

	private CategoryTypeEnum(Integer id, String description) {
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
	
	public static CategoryTypeEnum getInstance(Integer id) {
		for(CategoryTypeEnum value :  CategoryTypeEnum.values())
			if(value.getId().equals(id)) return value;
		return null;
	}

}
