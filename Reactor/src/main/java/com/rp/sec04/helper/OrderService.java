package com.rp.sec04.helper;

import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderService {

    private static Map<Integer, List<PurchaseOrder>> db = new HashMap<>();

    static {
        List<PurchaseOrder> list1 = new ArrayList<>();
        list1.add(new PurchaseOrder(1));
        list1.add(new PurchaseOrder(1));
        list1.add(new PurchaseOrder(1));

        List<PurchaseOrder> list2 = new ArrayList<>();
        list2.add(new PurchaseOrder(2));
        list2.add(new PurchaseOrder(2));

        db.put(1, list1);
        db.put(2, list2);
    }

    public static Flux<PurchaseOrder> getOrders(int userId) {
        return Flux.create((FluxSink<PurchaseOrder> purchaseOrderFluxSink) -> {
            db.get(userId).forEach(purchaseOrderFluxSink::next);
            purchaseOrderFluxSink.complete();
        }).delayElements(Duration.ofSeconds(1));
    }

}
