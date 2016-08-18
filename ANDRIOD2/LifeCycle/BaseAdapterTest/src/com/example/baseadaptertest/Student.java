package com.example.baseadaptertest;

import java.io.Serializable;

public class Student implements Serializable{
	private int rno;
	private String name;
	private long contactno;
	
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getContactno() {
		return contactno;
	}
	public void setContactno(long contactno) {
		this.contactno = contactno;
	}
	public Student(int rno, String name, long contactno) {
		super();
		this.rno = rno;
		this.name = name;
		this.contactno = contactno;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}
}
