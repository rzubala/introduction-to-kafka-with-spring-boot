package dev.lydtech.dispatch.service;

import dev.lydtech.dispatch.message.OrderCreated;
import dev.lydtech.dispatch.message.OrderDispatched;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
public class DispatchService {

    public static final String ORDERED_DISPATCHED_TOPIC = "order.dispatched";
    private final KafkaTemplate<String, Object> kafkaProducer;
    public void process(OrderCreated orderCreated) throws Exception {
        OrderDispatched orderDispatched = OrderDispatched.builder().orderId(orderCreated.getOrderId()).build();
        kafkaProducer.send(ORDERED_DISPATCHED_TOPIC, orderDispatched).get();
    }
}
