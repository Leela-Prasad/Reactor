package com.rp.sec04.helper;

import courseutil.Util;
import lombok.Data;

@Data
public class User {

    private int id;
    private String name;

    public User(int id) {
        this.id = id;
        this.name = Util.faker().name().fullName();
    }
}
