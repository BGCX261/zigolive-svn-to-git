package com.janiejohnstone.pages;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.logging.Logger;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.repeater.RepeatingView;

import com.janiejohnstone.app.JanieJohnstonePage;
import com.janiejohnstone.components.BookmarkablePageStringLink;
import com.janiejohnstone.components.filmstrip.FilmStrip;
import com.janiejohnstone.components.uploader.Uploader;
import com.janiejohnstone.persistance.HibernateUtil;
import com.janiejohnstone.persistance.domain.ImageGroup;
import com.janiejohnstone.persistance.domain.ImageInfo;
import com.janiejohnstone.persistance.domain.Page;


/**
 * Basic bookmarkable index page.
 * 
 * NOTE: You can get session properties from QuickStartSession via
 * getQuickStartSession()
 */
public class Index extends BasePage {
	// TODO Add any page properties or variables here

	/**
	 * Constructor that is invoked when page is invoked without a session.
	 * 
	 * @param parameters
	 *            Page parameters
	 */
	public Index(final PageParameters parameters) {
		//add(new Uploader("upload", "main"));
		//super(parameters);
		if (!parameters.containsKey("Id")) {
			List<Page> igs = (List<Page>) HibernateUtil.getCurrentSession()
					.createQuery("from Page p where p.homePage=true").list();
			if (igs.size() > 0) {

				add(new FilmStrip("FilmStrip", igs.get(0).getImageGroup()));
				add(new Label("content", igs.get(0).getCentralContent()));
				add(new BreadCrumb("breadcrumb", igs.get(0)));
			} else {
				add(new Label("FilmStrip", "No Film Strip Defined"));
				add(new Label("content", "No Content defined"));
			}
			//add(new Label("crumbs", "Index"));
		} else {
			try {
				long pageId = parameters.getLong("Id");

				Page p = (Page) HibernateUtil.getCurrentSession().createQuery(
						"from Page p where p.id=:id")
						.setLong("id", pageId)
						.uniqueResult();
				List<Page> children = HibernateUtil.getCurrentSession().createQuery("from Page as page where page.parent="+p.getParent().getId()).list();
				System.out.println(""+children+p.getId());
				for(Page pa:children) System.out.println(pa.getTitle());
				add(new BreadCrumb("breadcrumb", p));
				//Logger.getAnonymousLogger().info("HEEEELLLLLO"+crumbs);
				if(p.getImageGroup()==null || p==null){
					add(new Label("FilmStrip", "NO FILM STRIP DEFINED"));
				}else {
					add(new FilmStrip("FilmStrip", p.getImageGroup()));
				}
				if(p.getCentralContent() == null  || p==null){
					add(new Label("content", "NO CONTENT DEFINED"));
				} else {
					add(new Label("content", p.getCentralContent()));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	private class BreadCrumb extends RepeatingView{
		public BreadCrumb(String id, Page p) {
			super(id);
			List<Page> crumbs = new Vector<Page>();
			crumbs.add(0, p);
			Page parent = p.getParent();
			while(!(parent.getTitle().equals("NoParent") || parent == null)){
				crumbs.add(0, parent);
				parent = parent.getParent();
			}
			for(int i=0;i<crumbs.size();i++){
				WebMarkupContainer item = new WebMarkupContainer(this.newChildId());
				add(item);
				PageParameters pp = new PageParameters();
				pp.add("Id", ""+crumbs.get(i).getId());
				BookmarkablePageStringLink bpsl =new BookmarkablePageStringLink("link", Index.class, pp, crumbs.get(i).getTitle());
				item.add(bpsl);
				if(i==crumbs.size()-1){
					item.add(new Label("seperate", ""));
					bpsl.setEnabled(false);
				} else {
					item.add(new Label("seperate", " > "));
				}
			}
		}
	}
}
