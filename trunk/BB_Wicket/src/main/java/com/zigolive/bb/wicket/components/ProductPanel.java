package com.zigolive.bb.wicket.components;

import com.zigolive.bb.domain.Product;

import wicket.markup.html.basic.Label;
import wicket.markup.html.form.TextField;
import wicket.markup.html.panel.Panel;
import wicket.model.CompoundPropertyModel;
import wicket.model.IModel;
import wicket.model.Model;

public class ProductPanel extends Panel {

	public ProductPanel(String id, Product model) {
		super(id, new CompoundPropertyModel(model));
		add(new Label("name"));
		add(new Label("description"));
		add(new Label("image"));
		add(new Label("price"));
	}
	public ProductPanel(String id) {
		super(id);
		add(new Label("name"));
		add(new Label("description"));
		add(new Label("image"));
		add(new Label("price"));
	}
}
