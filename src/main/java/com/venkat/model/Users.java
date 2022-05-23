package com.venkat.model;

import javax.validation.constraints.Size;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity(name="testuser")
public class Users {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int sno;
	@Size(min=5 , message="Enter Your Name")
	private String name;
	@Size(min = 6, message = "Enter Your Email Id")
	private String email;
	@Size(min=5 , message="Enter Your Designation")
	private String designation;
	
	
	
	public Users() {
		}
	
	public Users(String name, String email, String designation) {
		super();
		this.name = name;
		this.email = email;
		this.designation = designation;
	}
	public Users(int sno, String name, String email, String designation) {
		super();
		this.sno = sno;
		this.name = name;
		this.email = email;
		this.designation = designation;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	@Override
	public String toString() {
		return "Users [sno=" + sno + ", name=" + name + ", email=" + email + ", designation=" + designation + "]";
	}
	
	
}
