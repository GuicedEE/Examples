module com.guicedee.examples.websockets.basic {
	requires com.guicedee.guicedinjection;
	requires com.guicedee.vertx.sockets;

	exports com.guicedee.examples.websockets.basic;
	opens com.guicedee.examples.websockets.basic to com.google.guice;

	provides com.guicedee.client.services.websocket.IWebSocketMessageReceiver
			with com.guicedee.examples.websockets.basic.ChatReceiver;
}

