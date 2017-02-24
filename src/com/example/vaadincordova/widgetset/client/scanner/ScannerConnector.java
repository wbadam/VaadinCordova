package com.example.vaadincordova.widgetset.client.scanner;

import com.example.vaadincordova.Scanner;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.ui.Connect;

@Connect(Scanner.class)
public class ScannerConnector extends AbstractComponentConnector {

    ScannerServerRpc rpc = RpcProxy.create(ScannerServerRpc.class, this);

    public ScannerConnector() {
        registerRpc(ScannerClientRpc.class, new ScannerClientRpc() {
        });

        getWidget().setScanHandler(new ScanHandler() {
            @Override
            public void scanned(String result) {
                rpc.scanned(result);
            }
        });

    }

    @Override
    protected Widget createWidget() {
        return GWT.create(ScannerWidget.class);
    }

    @Override
    public ScannerWidget getWidget() {
        return (ScannerWidget) super.getWidget();
    }

    @Override
    public ScannerState getState() {
        return (ScannerState) super.getState();
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
        getWidget().setText(getState().text);
    }

    public abstract class ScanHandler {
        public abstract void scanned(String result);
    }

}
