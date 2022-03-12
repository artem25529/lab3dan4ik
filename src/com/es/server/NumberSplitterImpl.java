package com.es.server;

import java.rmi.RemoteException;
import java.util.*;
import java.util.stream.IntStream;

public class NumberSplitterImpl implements NumberSplitter {
    @Override
    public Map<Count, Integer> split(int num) throws RemoteException {
        Deque<Integer> result = new ArrayDeque<>();
        while (num > 0) {
            result.addFirst(num % 10);
            num /= 10;
        }

        List<Integer> list = new ArrayList<>(result);
        Map<Count, Integer> res = new LinkedHashMap<>();

        IntStream.rangeClosed(1, result.size())
                .forEach(i -> {
                    Count c = Count.getClass(i);
                    res.put(c, list.get(i - 1));
                });

        return res;
    }
}

//реализация сервиса
