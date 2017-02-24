package com.example.vaadincordova.widgetset.client.scanner;

import com.vaadin.shared.communication.ServerRpc;

public interface ScannerServerRpc extends ServerRpc {

    public void scanned(String result);

}