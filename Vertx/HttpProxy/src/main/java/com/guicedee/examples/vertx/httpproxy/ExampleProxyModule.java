package com.guicedee.examples.vertx.httpproxy;

import com.guicedee.vertx.proxy.ProxyConnectionInfo;
import com.guicedee.vertx.proxy.ProxyModule;

/**
 * Example HTTP proxy module that forwards traffic from port 8080 to an origin on port 7070.
 * <p>
 * Configure via environment variables:
 * <pre>
 * PROXY_HOST=0.0.0.0      PROXY_PORT=8080
 * PROXY_ORIGIN_HOST=localhost  PROXY_ORIGIN_PORT=7070
 * </pre>
 */
public class ExampleProxyModule extends ProxyModule<ExampleProxyModule> {

    @Override
    protected ProxyConnectionInfo getProxyConnectionInfo() {
        String proxyHost = System.getProperty("PROXY_HOST",
                System.getenv().getOrDefault("PROXY_HOST", "0.0.0.0"));
        int proxyPort = Integer.parseInt(System.getProperty("PROXY_PORT",
                System.getenv().getOrDefault("PROXY_PORT", "8080")));
        String originHost = System.getProperty("PROXY_ORIGIN_HOST",
                System.getenv().getOrDefault("PROXY_ORIGIN_HOST", "localhost"));
        int originPort = Integer.parseInt(System.getProperty("PROXY_ORIGIN_PORT",
                System.getenv().getOrDefault("PROXY_ORIGIN_PORT", "7070")));

        return new ProxyConnectionInfo()
                .setName("api-gateway")
                .setProxyHost(proxyHost)
                .setProxyPort(proxyPort)
                .setOriginHost(originHost)
                .setOriginPort(originPort)
                .setWebSocketEnabled(true)
                .setCachingEnabled(false)
                .setDefaultConnection(true);
    }
}

