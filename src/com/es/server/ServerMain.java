package com.es.server;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServerMain {
    public static final String UNIQUE_BINDING_NAME = "server.splitter"; //имя сервиса

    public static void main(String[] args)
            throws RemoteException, InterruptedException, AlreadyBoundException {
        final NumberSplitterImpl splitter = new NumberSplitterImpl();
        final Registry registry = LocateRegistry.createRegistry(2732); //реестр удалённых объектов

        Remote stab = UnicastRemoteObject.exportObject(splitter, 0); //экспорт объекта
        registry.bind(UNIQUE_BINDING_NAME, stab);
        Thread.sleep(Integer.MAX_VALUE);
    }
}
