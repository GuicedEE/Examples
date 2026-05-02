package com.guicedee.examples.vertx.httpproxy;

import com.guicedee.client.IGuiceContext;

/**
 * Boots the GuicedEE context with the HTTP Proxy module.
 * <p>
 * The proxy starts automatically and forwards all traffic
 * from the proxy port to the configured origin server.
 */
public class HttpProxyExample {
    public static void main(String[] args) {
        IGuiceContext.registerModuleForScanning
                .add("com.guicedee.examples.vertx.httpproxy");
        IGuiceContext.instance().inject();
        System.out.println("🔀 HTTP Proxy is running — forwarding traffic to origin server");
    }
}

