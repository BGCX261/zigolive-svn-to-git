package com.zigolive.bb.wicket.components;

import com.zigolive.bb.domain.Page;

import wicket.markup.html.basic.Label;
import wicket.markup.html.list.ListItem;
import wicket.markup.html.list.ListView;
import wicket.markup.html.panel.Panel;
import wicket.model.CompoundPropertyModel;

public class SiteMapTree extends Panel{
	private ListView listView;

	public SiteMapTree(String id, Page model, final int level) {
		super(id, new CompoundPropertyModel(model));
		
		add(new Label("title"));

		listView = new ListView("children"){
			@Override
			protected void populateItem(ListItem item) {
				Page p = (Page)item.getModelObject();
				if(level<0 || level>0) item.add(new SiteMapTree("child",p,level-1));
				else {
					Label l = new Label("child","");
					l.setVisible(false);
					item.add(l);
				}
				//item.add(new SiteMapTree("child",p, level-1));
			}
		};
		add(listView);

	}
}
