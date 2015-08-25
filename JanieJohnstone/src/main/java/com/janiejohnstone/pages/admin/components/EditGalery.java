package com.janiejohnstone.pages.admin.components;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.protocol.http.WebApplication;

import com.janiejohnstone.persistance.HibernateUtil;
import com.janiejohnstone.persistance.domain.ImageGroup;
import com.janiejohnstone.persistance.domain.ImageInfo;
import com.janiejohnstone.persistance.domain.Page;

public class EditGalery extends Panel {
	List<Page> pages;
	List<String> imageDir;
	private ListView imagesList;
	public EditGalery(String id, final ImageGroup images) {
		super(id, new CompoundPropertyModel(images));		
		pages = HibernateUtil.getCurrentSession().createQuery("from Page").list();
		WebApplication wa = (WebApplication) getApplication();
		String fstr = wa.getServletContext().getRealPath("/WEB-INF/UploaderFiles/"+"main");
		imageDir = Arrays.asList(new File(fstr).list());
		add(new TextField("name"));
		imagesList = new ListView("images"){
			@Override
			protected void populateItem(ListItem item) {
				
				final ImageInfo ii = (ImageInfo) item.getModelObject();
				item.setModel(new CompoundPropertyModel(ii));
				
				//item.add(new EditImageForm("imageForm",ig));
				item.add(new TextField("description"));
				item.add(new DropDownChoice("src",imageDir));
				item.add(new Image("vimage","/UploaderFiles/main/"+ii.getSrc()));
				item.add(new DropDownChoice("link", pages));
				item.add(new Link("del"){
					@Override
					public void onClick() {
						// Remove image from list
						images.getImages().remove(ii);
						HibernateUtil.getCurrentSession().delete(ii);
						getParent().modelChanged();
					}
				});
			}	
		};
		add(imagesList);
	}
	public ListView getImagesList() {
		return imagesList;
	}

}
