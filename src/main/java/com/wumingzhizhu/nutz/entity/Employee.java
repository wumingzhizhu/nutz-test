package com.wumingzhizhu.nutz.entity;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

@Table("employee")
public class Employee {
	
	@Id
	private Integer id;
	
	@Column("name")
	private String name;
	
	@Column("age")
	private Integer age;
	
	@Column("tel")
	private String tel;
	
	@Column("position")
	private String position;
	
	public Integer getId() {
		return id;
	}

	public void setId( Integer id ) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName( String name ) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge( Integer age ) {
		this.age = age;
	}

	public String getTel() {
		return tel;
	}

	public void setTel( String tel ) {
		this.tel = tel;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition( String position ) {
		this.position = position;
	}
	
	

}
