package com.es.client;

import com.es.server.Count;
import com.es.server.NumberSplitter;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Map;
import java.util.Scanner;

public class ClientMain {
    public static final String UNIQUE_BINDING_NAME = "server.splitter"; //имя сервиса

    public static void main(String[] args)
            throws RemoteException, NotBoundException {
        final Registry registry = LocateRegistry.getRegistry(2732); //получение реестра удалённых объектов
        NumberSplitter splitter = (NumberSplitter) registry.lookup(UNIQUE_BINDING_NAME); //получение заглушки которая реалихует функционал

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number");

        int number = getUserInput(scanner);
        Map<Count, Integer> split = splitter.split(number);

        split.forEach((k, v) -> System.out.println(v + " " + k));
    }

    private static int getUserInput(Scanner scanner) { //клиентский инпут
        while (!scanner.hasNext("\\d{1,4}")) {
            System.out.println("Reenter value pls");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
