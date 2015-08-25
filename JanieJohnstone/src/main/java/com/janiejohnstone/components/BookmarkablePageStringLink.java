package com.janiejohnstone.components;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

public class BookmarkablePageStringLink extends BookmarkablePageLink{
	private String body;
	public BookmarkablePageStringLink(String id, Class c, PageParameters params, String text) {
		super(id, c,params);
		body = text;
	}
	@Override
	protected void onComponentTagBody(MarkupStream markupStream,
			ComponentTag openTag) {
		// TODO Auto-generated method stub
		//MarkupStream ms = new MarkupStream();
		//Label
		replaceComponentTagBody(markupStream, openTag, body);
		//super.onComponentTagBody(markupStream, openTag);
	}
}
