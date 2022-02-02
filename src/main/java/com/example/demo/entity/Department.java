package com.example.demo.entity;

import com.example.demo.entity.request.ProductRequest;

public class Department {
	String name;
	public Department(ProductRequest d)
	{	this.name = d.getName();}
	
	@Override
	public String toString() {
		return "Department [name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	
	public Department() {
		super();
	}

	
	
	

}
