package com.es.server;

import java.rmi.RemoteException;
import java.util.*;
import java.util.stream.IntStream;

public class NumberSplitterImpl implements NumberSplitter {
    @Override
    public void split(int num) throws RemoteException {
        Deque<Integer> result = new ArrayDeque<>();
        while (num > 0) {
            result.addFirst(num % 10);
            num /= 10;
        }

        List<Integer> list = new ArrayList<>(result);

        IntStream.rangeClosed(1, result.size())
                .forEach(i -> {
                    Count c = Count.getClass(i);
                    System.out.println(list.get(i - 1) + " " + c);
                });
    }
}

//реализация сервиса
