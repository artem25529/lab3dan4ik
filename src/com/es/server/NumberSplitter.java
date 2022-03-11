package com.es.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface NumberSplitter extends Remote {
    void split(int num) throws RemoteException;
}


//сервис