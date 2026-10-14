package com.guicedee.examples.vertx.httpproxy;

import com.guicedee.client.IGuiceContext;
import com.guicedee.guicedinjection.GuiceApplication;

/**
 * Boots the GuicedEE context with the HTTP Proxy module.
 * <p>
 * The proxy starts automatically and forwards all traffic
 * from the proxy port to the configured origin server.
 */
public class HttpProxyExample {
    public static void main(String[] args) {
        GuiceApplication.run(() -> {
            IGuiceContext.registerModule("com.guicedee.examples.vertx.httpproxy");
            IGuiceContext.getContext().getConfig().setServiceLoadWithClassPath(true);
        });
        System.out.println("🔀 HTTP Proxy is running — forwarding traffic to origin server");
    }
}

