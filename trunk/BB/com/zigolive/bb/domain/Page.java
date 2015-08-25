package com.zigolive.bb.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Page implements Serializable {

	private long id;
	private String title;
	private Page parent;
	private List<Page> children;
	@OneToMany(fetch=FetchType.EAGER)
	public List<Page> getChildren() {
		return children;
	}
	public void setChildren(List<Page> children) {
		this.children = children;
	}
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	public long getId() {
		return id;
	}
	private void setId(long id) {
		this.id = id;
	}
	@ManyToOne(cascade = CascadeType.ALL)
	public Page getParent() {
		return parent;
	}
	public void setParent(Page parent) {
		this.parent = parent;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
