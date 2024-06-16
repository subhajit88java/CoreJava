package com.subhajit.eenum.model;

public enum EnumThree {
	
	SUBHAJIT(100, "Durgapur"),
	ASIM(110,"Kolkata"),
	SUMAN(120,"Chuchura");
	
	private Integer id;
	private String city;
	
	private EnumThree(Integer id, String city) {
		this.id = id;
		this.city = city;
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getCity() {
		return city;
	}
	
}
