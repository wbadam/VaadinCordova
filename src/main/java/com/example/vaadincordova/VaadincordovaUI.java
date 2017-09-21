package com.example.vaadincordova;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.JavaScript;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("vaadincordova")
public class VaadincordovaUI extends UI {

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = VaadincordovaUI.class, widgetset = "com.example.vaadincordova.VaadincordovaWidgetset")
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {

        // This message is caught in vaadinMobile.js and removes the load
        // screen. Note: If this was being done using JSNI (gwt managed client
        // side code) you should use $wnd instead of window to access the window
        // element.
        JavaScript.getCurrent()
                .execute("window.parent.postMessage('vaadin-ready', '*')");

        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);

        Scanner scanner = new Scanner();
        layout.addComponent(scanner);
    }

}