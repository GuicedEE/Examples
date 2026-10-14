package com.guicedee.examples.vertx.httpproxy;

import com.guicedee.client.Environment;

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
        String proxyHost = Environment.getSystemPropertyOrEnvironment("PROXY_HOST", "0.0.0.0");
        int proxyPort = Integer.parseInt(Environment.getSystemPropertyOrEnvironment("PROXY_PORT", "8080"));
        String originHost = Environment.getSystemPropertyOrEnvironment("PROXY_ORIGIN_HOST", "localhost");
        int originPort = Integer.parseInt(Environment.getSystemPropertyOrEnvironment("PROXY_ORIGIN_PORT", "7070"));

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

