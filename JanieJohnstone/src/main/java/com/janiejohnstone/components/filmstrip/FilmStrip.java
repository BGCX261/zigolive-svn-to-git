package com.janiejohnstone.components.filmstrip;


import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PageableListView;
import org.apache.wicket.markup.html.navigation.paging.PagingNavigator;
import org.apache.wicket.markup.html.panel.Panel;

import com.janiejohnstone.components.bookmarkableimagelink.BookmarkableImageLink;
import com.janiejohnstone.persistance.domain.ImageGroup;
import com.janiejohnstone.persistance.domain.ImageInfo;

public class FilmStrip extends Panel{

	private PageableListView images;
	
	public FilmStrip(String id, ImageGroup model) {
		super(id);
		images = new PageableListView("images", model.getImages(), 3){
			@Override
			protected void populateItem(ListItem item) {
				// TODO Auto-generated method stub
				final ImageInfo il = (ImageInfo)item.getModelObject();
				BookmarkableImageLink i = new BookmarkableImageLink("link",(ImageInfo)item.getModelObject());
				if(il.getLink().getTitle().equals("NoParent")) i.setEnabled(false);
				item.add(i);
				
			}
		};
		//images.setCurrentPage(currentPage);
		add(images);
		add(new PagingNavigator("nav", images));
		//add(new Label("test", "Hello"));
	}
	
	
}
