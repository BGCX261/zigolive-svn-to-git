package com.janiejohnstone.pages.admin;

import java.util.List;

import com.janiejohnstone.pages.BasePage;
import com.janiejohnstone.persistance.HibernateUtil;
import com.janiejohnstone.persistance.domain.Page;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.CompoundPropertyModel;

public class ManagePages extends BasePage{

	private ListView pages;
	private List<Page> pageList;
	public ManagePages(PageParameters params) {
		//super(params);
		pageList = HibernateUtil.getCurrentSession()
			.createQuery("from Page").list();
		pages = new ListView("pages", pageList){
			@Override
			protected void populateItem(ListItem item) {
				final Page page = (Page) item.getModelObject();
				// TODO Auto-generated method stub
				item.setModel(new CompoundPropertyModel(item.getModelObject()));
				item.add(new Label("title"));
				item.add(new Link("remove"){
					@Override
					public void onClick() {
						HibernateUtil.getCurrentSession().delete(page);
						pageList = HibernateUtil.getCurrentSession()
						.createQuery("from Page").list();
						pages.setList(pageList);
						pages.modelChanged();
					}
				});
				item.add(new Link("edit"){
					@Override
					public void onClick() {
						PageParameters pp = new PageParameters();
						pp.add("id", ""+page.getId());
						setResponsePage(EditPage.class, pp);
					}
				});
			}
		};
		add(pages);
		add(new Link("new"){
			@Override
			public void onClick() {
				Page p = new Page();
				HibernateUtil.getCurrentSession().save(p);
				PageParameters pp = new PageParameters();
				pp.add("id", ""+p.getId());
				setResponsePage(EditPage.class, pp);
			}
		});
		
	}
}
