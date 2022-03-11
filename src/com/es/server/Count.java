package com.es.server;

import java.util.Arrays;

public enum Count {
    UNITS(4), DOZENS(3), HUNDRED(2), THOUSAND(1);

    private int count;

    Count(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public static Count getClass(int num) {
        return Arrays.stream(Count.values())
                .filter(count -> count.getCount() == num)
                .findFirst()
                .orElse(null);
    }
}
