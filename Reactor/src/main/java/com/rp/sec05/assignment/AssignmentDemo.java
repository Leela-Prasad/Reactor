package com.rp.sec05.assignment;

import courseutil.Util;

public class AssignmentDemo {

    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        RevenueService revenueService = new RevenueService();
        InventoryService inventoryService = new InventoryService();

        orderService.orderStream().subscribe(revenueService.subscribeOrderStream());
        orderService.orderStream().subscribe(inventoryService.subscribeOrderStream());

        revenueService.revenueStream().subscribeWith(Util.subscriber("revenue"));
        inventoryService.inventoryStream().subscribeWith(Util.subscriber("inventory"));

        Util.sleepSeconds(60);
    }
}
