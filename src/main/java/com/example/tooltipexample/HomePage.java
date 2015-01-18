package com.example.tooltipexample;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;

public class HomePage extends WebPage {

    private static final long serialVersionUID = 1L;

    public HomePage(final PageParameters parameters) {
        super(parameters);
        WebMarkupContainer wmc = getHelpContainer("tooltip");
        add(getToolTipAnchor(wmc, "tooltipanchor"));
        add(wmc);

        add(new Label("version", getApplication().getFrameworkSettings().getVersion()));

        // TODO Add your page's components here
    }

    private WebMarkupContainer getHelpContainer(final String wicketid) {
        WebMarkupContainer wmc = new WebMarkupContainer(wicketid);
        wmc.setVisible(false);
        wmc.setOutputMarkupPlaceholderTag(true);
        wmc.setOutputMarkupId(true);
        return wmc;
    }

    private AjaxLink<Void> getToolTipAnchor(final WebMarkupContainer wmc, String id) {
        AjaxLink<Void> ajaxLink = new AjaxLink<Void>(id) {
            boolean toggle = false;
            @Override
            public void onClick(AjaxRequestTarget target) {
                toggle = !toggle;
                wmc.setVisible(toggle);
                target.add(wmc);
            }
        };
        return ajaxLink;
    }
}
