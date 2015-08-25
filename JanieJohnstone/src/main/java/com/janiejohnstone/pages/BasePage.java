package com.janiejohnstone.pages;

import org.apache.wicket.PageParameters;
import org.apache.wicket.ResourceReference;
import org.apache.wicket.behavior.HeaderContributor;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.resources.StyleSheetReference;

public abstract class BasePage extends WebPage{
	public BasePage() {
		add(new StyleSheetReference("stylesheet", new ResourceReference(BasePage.class, "css/BasePage.css")));
	}
}
