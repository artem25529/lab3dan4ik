package com.es.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

public interface NumberSplitter extends Remote {
    Map<Count, Integer> split(int num) throws RemoteException;
}


//сервис