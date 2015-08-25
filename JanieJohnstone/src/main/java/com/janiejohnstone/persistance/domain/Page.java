package com.janiejohnstone.persistance.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Vector;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Type;

@Entity
public class Page implements Serializable{

	private long id;
	private ImageGroup imageGroup;
	//private TextContent leftContent;
	private String centralContent;
	//private TextContent breadCrumb;
	private boolean homePage = false;
	private String title = "No Title Defined";
	
	private Page parent;
	private List<Page> children = new Vector<Page>();
	
	@OneToOne(cascade={})
	public Page getParent() {
		return parent;
	}
	public void setParent(Page parent) {
		this.parent = parent;
	}
	@OneToMany(cascade={})
	public List<Page> getChildren() {
		return children;
	}
	public void setChildren(List<Page> children) {
		this.children = children;
	}
	public boolean isHomePage() {
		return homePage;
	}
	public void setHomePage(boolean homePage) {
		this.homePage = homePage;
	}
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@Lob
	public String getCentralContent() {
		return centralContent;
	}
	public void setCentralContent(String centralContent) {
		this.centralContent = centralContent;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@OneToOne(cascade={CascadeType.ALL})
	public ImageGroup getImageGroup() {
		return imageGroup;
	}
	public void setImageGroup(ImageGroup imageGroup) {
		//if(imageGroup != null)imageGroup.setPage(this);
		this.imageGroup = imageGroup;
	}
	@Override
	public String toString() {
		return title;
	}
	
}
