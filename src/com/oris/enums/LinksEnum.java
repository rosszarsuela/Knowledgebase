package com.oris.enums;


public enum LinksEnum {

	HOME(1, "Home"),
	ABOUT(2, "About Us"),
	PRODUCT(3, "Product & Services"),
	TRAINING(4, "Training"),
	EVENTS(5, "Events"),
	CONTACT(6, "Contact Us"),
	FAQ(7, "FAQ");
	
	
	private LinksEnum(Integer id, String description) {
		this.id = id;
		this.description = description;
	}
	
	private Integer id;
	private String description;
	
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
	
	public static LinksEnum getInstance(Integer id) {
		for(LinksEnum value :  LinksEnum.values())
			if(value.getId().equals(id)) return value;
		return null;
	}
}
