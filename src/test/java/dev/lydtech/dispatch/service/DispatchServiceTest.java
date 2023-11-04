package dev.lydtech.dispatch.service;

import dev.lydtech.dispatch.message.OrderCreated;
import dev.lydtech.dispatch.util.TestEventData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DispatchServiceTest {

    private DispatchService dispatchService;

    @BeforeEach
    void setUp() {
        dispatchService = new DispatchService();
    }

    @Test
    void process() {
        OrderCreated testEvent = TestEventData.buildOrderCreatedRandomData();
        dispatchService.process(testEvent);
    }
}