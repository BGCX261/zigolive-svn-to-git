package com.janiejohnstone.persistance.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.janiejohnstone.persistance.HibernateUtil;

@Entity
public class TextContent implements Serializable{
	

	private long id;
	private String text;
	
	public TextContent(String text){
		this.text = text;
	}
	public TextContent() {}
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
}
