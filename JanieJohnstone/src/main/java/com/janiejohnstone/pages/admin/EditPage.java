package com.janiejohnstone.pages.admin;

import java.io.Serializable;
import java.util.List;

import org.apache.wicket.PageParameters;
import org.apache.wicket.WicketRuntimeException;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;

import com.janiejohnstone.pages.BasePage;
import com.janiejohnstone.pages.admin.components.EditGalery;
import com.janiejohnstone.persistance.HibernateUtil;
import com.janiejohnstone.persistance.domain.ImageGroup;
import com.janiejohnstone.persistance.domain.ImageInfo;
import com.janiejohnstone.persistance.domain.Page;

public class EditPage extends BasePage{

	public EditPage(PageParameters params) {
		if(params.containsKey("id")){
			Page page = (Page) HibernateUtil.getCurrentSession().load(Page.class, params.getLong("id"));
			add(new EditPageForm("form", page));
		} else {
			throw new WicketRuntimeException("Could not find page with id "+params.getLong("id"));
		}
	}
	
	private class EditPageForm extends Form{
		private Page page;
		private ImageGroup imageGroup = null;
		private EditGalery gal;
		public EditPageForm(String id, final Page page) {
			super(id);
			this.page= page;
			// We have a page model :)
			setModel(new CompoundPropertyModel(page));
			add(new CheckBox("homePage"));

			add(new TextField("title"));
			if(page.getImageGroup() == null){
				imageGroup = new ImageGroup();
				page.setImageGroup(imageGroup);
				HibernateUtil.getCurrentSession().save(imageGroup);
			} else imageGroup = page.getImageGroup();
			add(new TextArea("centralContent"));
			List l =HibernateUtil.getCurrentSession().createQuery("from Page").list();

			add(new DropDownChoice("parent",l));
			add(gal = new EditGalery("editImage", page.getImageGroup()));
			add(new SubmitLink("newImage"){
				@Override
				public void onSubmit() {
					
					ImageInfo ii = new ImageInfo();
					HibernateUtil.getCurrentSession().save(ii);
					imageGroup.getImages().add(ii);
					HibernateUtil.getCurrentSession().update(page);
					gal.getImagesList().modelChanged();
					//setResponsePage(cls, parameters)
				}
			});
		}
		@Override
		protected void onSubmit() {
			super.onSubmit();
			//HibernateUtil.getCurrentSession().update(imageGroup);
			HibernateUtil.getCurrentSession().update(page);
			//setResponsePage(ManagePages.class);
		}
	}

}
