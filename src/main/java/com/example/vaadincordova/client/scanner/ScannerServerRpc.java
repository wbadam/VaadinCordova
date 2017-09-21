package com.example.vaadincordova.client.scanner;

import com.vaadin.shared.communication.ServerRpc;

public interface ScannerServerRpc extends ServerRpc {

    public void scanned(String result);

}