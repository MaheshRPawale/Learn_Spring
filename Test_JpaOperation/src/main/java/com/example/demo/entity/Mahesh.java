package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="mahesh")
public class Mahesh {
	
	/* private String name;
	private int emp_id;
	private String mail;
	                                table fields and entity fields must be same can use different field names in your Entity class — as long as you map them
	                                using JPA annotations like @Column.
   */
	@Id
	@Column(name ="emp_id")
	private int my_id;
	@Column(name = "name")
	private String my_name;
	@Column(name="mail")
	private  String myemailid;
	
	public Mahesh() {
		super();
	}
	public Mahesh(int my_id, String my_name, String myemailid) {
		super();
		this.my_id = my_id;
		this.my_name = my_name;
		this.myemailid = myemailid;
	}
	public int getMy_id() {
		return my_id;
	}
	public void setMy_id(int my_id) {
		this.my_id = my_id;
	}
	public String getMy_name() {
		return my_name;
	}
	public void setMy_name(String my_name) {
		this.my_name = my_name;
	}
	public String getMyemailid() {
		return myemailid;
	}
	public void setMyemailid(String myemailid) {
		this.myemailid = myemailid;
	}
	@Override
	public String toString() {
		return "Mahesh [my_id=" + my_id + ", my_name=" + my_name + ", myemailid=" + myemailid + "]";
	} 
	
	
}
