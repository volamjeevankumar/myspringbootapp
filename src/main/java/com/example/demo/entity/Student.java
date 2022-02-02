package com.example.demo.entity;
import java.util.Objects;
public class Student {
	int rollno;
	String name;
	public Student(int rollno,String name)
	{
		this.rollno=rollno;
		this.name=name;
		
	}	public static void main(String args[]) {
		Student s1=new Student(10,"jeevan kumar");
		Student s2=new Student(10,"harika");
		System.out.println(s1.equals(s2));
		
		
		
	}
	@Override
	public int hashCode() {
		return Objects.hash(name, rollno);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(name, other.name) && rollno == other.rollno;
	}
	
	

}
