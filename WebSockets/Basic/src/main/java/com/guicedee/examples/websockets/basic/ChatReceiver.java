package com.guicedee.examples.websockets.basic;

import com.guicedee.client.IGuiceContext;
import com.guicedee.client.services.websocket.IGuicedWebSocket;
import com.guicedee.client.services.websocket.IWebSocketMessageReceiver;
import com.guicedee.client.services.websocket.WebSocketMessageReceiver;
import io.smallrye.mutiny.Uni;

import java.util.Set;

/**
 * WebSocket message receiver for the "chat" action.
 * Messages with {"action": "chat", "data": {"text": "..."}} are routed here.
 * Registered via SPI in module-info.java.
 */
public class ChatReceiver implements IWebSocketMessageReceiver<Void, ChatReceiver>
{
    @Override
    public Set<String> messageNames()
    {
        return Set.of("chat");
    }

    @Override
    public Uni<Void> receiveMessage(WebSocketMessageReceiver<?> message)
    {
        String text = (String) message.getData().get("text");
        System.out.println("Chat message received: " + text);

        // Broadcast to all clients in the "lobby" group
        IGuicedWebSocket ws = IGuiceContext.get(IGuicedWebSocket.class);
        ws.broadcastMessage("chat:lobby", text);

        return Uni.createFrom().voidItem();
    }
}

