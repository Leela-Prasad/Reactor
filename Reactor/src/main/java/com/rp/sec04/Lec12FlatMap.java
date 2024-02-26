package com.rp.sec04;

import com.rp.sec04.helper.OrderService;
import com.rp.sec04.helper.User;
import com.rp.sec04.helper.UserService;
import courseutil.Util;

public class Lec12FlatMap {

    public static void main(String[] args) {
        UserService.getUsers()
                .flatMap(user -> OrderService.getOrders(user.getId()))
                .subscribeWith(Util.subscriber());


        Util.sleepSeconds(7);
    }
}
