package dev.lydtech.dispatch.util;

import dev.lydtech.dispatch.message.OrderCreated;

import java.util.UUID;

import static java.util.UUID.randomUUID;

public class TestEventData {

    public static OrderCreated buildOrderCreatedData(UUID id, String item) {
        return OrderCreated.builder()
                .orderId(id)
                .item(item)
                .build();
    }

    public static OrderCreated buildOrderCreatedRandomData() {
        return buildOrderCreatedData(randomUUID(), randomUUID().toString());
    }
}
