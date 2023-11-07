package dev.lydtech.dispatch.handler;

import dev.lydtech.dispatch.message.OrderCreated;
import dev.lydtech.dispatch.service.DispatchService;
import dev.lydtech.dispatch.util.TestEventData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class OrderCreatedHandlerTest {

    private OrderCreatedHandler handler;
    private DispatchService dispatchServiceMock;

    @BeforeEach
    void setUp() {
        dispatchServiceMock = mock(DispatchService.class);
        handler = new OrderCreatedHandler(dispatchServiceMock);
    }

    @Test
    void listen_Success() throws Exception {
        String key = UUID.randomUUID().toString();
        OrderCreated testEvent = TestEventData.buildOrderCreatedRandomData();
        handler.listen(0, key, testEvent);
        verify(dispatchServiceMock, times(1)).process(key, testEvent);
    }

    @Test
    public void listen_ServiceThrowsException() throws Exception {
        String key = UUID.randomUUID().toString();
        OrderCreated testEvent = TestEventData.buildOrderCreatedRandomData();
        doThrow(new RuntimeException("Service failure")).when(dispatchServiceMock).process(key, testEvent);

        handler.listen(0, key, testEvent);

        verify(dispatchServiceMock, times(1)).process(key, testEvent);
    }
}
