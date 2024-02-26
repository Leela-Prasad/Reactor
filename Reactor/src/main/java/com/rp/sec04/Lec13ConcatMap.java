package com.rp.sec04;

import com.rp.sec04.helper.OrderService;
import com.rp.sec04.helper.UserService;
import courseutil.Util;

public class Lec13ConcatMap {
    public static void main(String[] args) {
        UserService.getUsers()
                .concatMap(user -> OrderService.getOrders(user.getId()))
                .subscribeWith(Util.subscriber());


        Util.sleepSeconds(7);
    }
}
