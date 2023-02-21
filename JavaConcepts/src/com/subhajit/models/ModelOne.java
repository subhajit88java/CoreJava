package com.subhajit.models;

public final class ModelOne implements Cloneable{
	
	private String name;
	private Integer id;

	public ModelOne(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return new ModelOne(this.id, new String(this.name));
	}

	@Override
	public String toString() {
		return "ModelOne [name=" + name + "]";
	}
	
	
}
