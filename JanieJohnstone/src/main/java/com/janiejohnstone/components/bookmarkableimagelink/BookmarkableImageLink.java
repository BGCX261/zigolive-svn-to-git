package com.janiejohnstone.components.bookmarkableimagelink;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

import com.janiejohnstone.pages.Index;
import com.janiejohnstone.persistance.domain.ImageInfo;


public  class BookmarkableImageLink extends BookmarkablePageLink {
	private final ImageInfo model;
	public BookmarkableImageLink(String id, final ImageInfo model) {
		super(id, Index.class);
		setParameter("Id", model.getLink().getId());
		this.model = model;
		init();
	}
	private void init(){
		add(new Image("image", "/UploaderFiles/main/"+model.getSrc()){
			@Override
			protected void onComponentTag(ComponentTag tag) {
				// TODO Auto-generated method stub
				super.onComponentTag(tag);
				tag.put("alt", model.getDescription());
			}
		});
		
	}
}
