package com.example.vaadincordova;

import com.example.vaadincordova.widgetset.client.scanner.ScannerServerRpc;
import com.example.vaadincordova.widgetset.client.scanner.ScannerState;

public class Scanner extends com.vaadin.ui.AbstractComponent {

    private ScannerServerRpc rpc = new ScannerServerRpc() {
        public void scanned(String result) {
            getState().text = result;
        }
    };

    public Scanner() {
        registerRpc(rpc);
    }

    @Override
    public ScannerState getState() {
        return (ScannerState) super.getState();
    }
}