package com.zigolive.bb.wicket.components;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.zigolive.bb.domain.Page;
import com.zigolive.utils.HibernateUtil;

import wicket.markup.html.basic.Label;
import wicket.markup.html.list.ListItem;
import wicket.markup.html.list.ListView;
import wicket.markup.html.panel.Panel;
import wicket.model.CompoundPropertyModel;

public class SiteMap extends Panel{
	private List<Page> children;
	private ListView listView;
	public SiteMap(String id, Page model, final int level) {
		super(id);
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
		model = (Page)s.load(Page.class, model.getId());
		setModel(new CompoundPropertyModel(model));
		
		listView = new ListView("children"){
			@Override
			protected void populateItem(ListItem item) {
				Page p = (Page)item.getModelObject();
				if(level<0 || level>0) item.add(new SiteMapTree("child",p,level-1));
				else item.add(new Label("child",""));
			}
		};
		add(listView);
		tx.commit();
	}
}
