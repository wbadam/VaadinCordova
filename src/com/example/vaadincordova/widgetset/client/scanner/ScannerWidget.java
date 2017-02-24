package com.example.vaadincordova.widgetset.client.scanner;

import com.example.vaadincordova.widgetset.client.scanner.ScannerConnector.ScanHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.vaadin.client.ui.VButton;

public class ScannerWidget extends VerticalPanel {

    public static final String CLASSNAME = "scanner";

    private ScanHandler scanHandler;
    private Label label;

    private static ScannerWidget thisScanner;

    public ScannerWidget() {
        setStyleName(CLASSNAME);
        setSpacing(10);

        VButton button = new VButton();
        button.setText("Scan");
        button.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                messageSend();
            }
        });

        label = new Label();

        add(button);
        add(label);

        addEventListenerToWindow(this);
    }

    private void messageSend() {
        thisScanner = this;
        scanBarCode();
    }

    private native void scanBarCode()
    /*-{
        $wnd.parent.postMessage('barcodescanner-', '*');
    }-*/;

    private native void addEventListenerToWindow(ScannerWidget scannerWidget)
    /*-{
        $wnd.addEventListener('message', function (e) {
          $entry(scannerWidget.@com.example.vaadincordova.widgetset.client.scanner.ScannerWidget::messageReceived(Ljava/lang/String;)(e.data));
        }, false);
    }-*/;

    private void messageReceived(final String data) {
        if (equals(thisScanner)) {
            if (data.startsWith("barcodescanned-") && data.length() > 15) {
                String result = data.substring(15, data.length());
                scanHandler.scanned(result);
            }
        }
    }

    public void setScanHandler(ScanHandler scanHandler) {
        this.scanHandler = scanHandler;
    }

    public void setText(String text) {
        label.setText(text);
    }

}