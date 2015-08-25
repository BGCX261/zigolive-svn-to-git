package com.janiejohnstone.pages.admin;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.CompoundPropertyModel;
import org.hibernate.Hibernate;
import java.util.List;
import com.janiejohnstone.persistance.HibernateUtil;
import com.janiejohnstone.persistance.domain.ImageGroup;

public class ManageGaleries extends WebPage {
	private List<ImageGroup> galeries;
	private ListView galeriesList;
	public ManageGaleries() {
		init();
	}
	private void init(){
		// Create a list of all the galieries
		galeries = HibernateUtil.getCurrentSession().createQuery("from ImageGroup").list();
		galeriesList = new ListView("galeries", galeries){
			@Override
			protected void populateItem(ListItem item) {
				final ImageGroup igroup = (ImageGroup) item.getModelObject();
				item.setModel(new CompoundPropertyModel(item.getModelObject()));
				// For each galery, give name and details, and modify delete buttons
				//if(null =! null)
				if(igroup.getName() != null){
					item.add(new Label("name"));
				} else {
					item.add(new Label("name", "NO NAME"));
				}
				item.add(new Link("remove"){
					@Override
					public void onClick() {
						
						HibernateUtil.getCurrentSession().delete(igroup);
						galeries = HibernateUtil.getCurrentSession().createQuery("from ImageGroup").list();
						galeriesList.modelChanged();
					}
				});
			}
		};
		add(galeriesList);
	}
}
