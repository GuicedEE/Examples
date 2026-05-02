# Vert.x HTTP Proxy Example

Demonstrates the GuicedEE HTTP Proxy integration using `ProxyModule` and `ProxyConnectionInfo`.

## What it does

- Starts a reverse proxy on port **8080**
- Forwards all requests (including WebSocket upgrades) to an origin server on port **7070**
- Supports environment-variable-driven configuration

## Running

```bash
# Start an origin server on port 7070 first, then:
mvn package
java --module-path target/libs:target/vertx-http-proxy-example-2.0.0.jar \
     -m com.guicedee.examples.vertx.httpproxy/com.guicedee.examples.vertx.httpproxy.HttpProxyExample
```

## Environment Variables

| Variable            | Default     | Description              |
|---------------------|-------------|--------------------------|
| `PROXY_HOST`        | `0.0.0.0`  | Proxy listen address     |
| `PROXY_PORT`        | `8080`     | Proxy listen port        |
| `PROXY_ORIGIN_HOST` | `localhost` | Origin server host       |
| `PROXY_ORIGIN_PORT` | `7070`     | Origin server port       |

## Adding Interceptors

```java
return new ProxyConnectionInfo()
        .setName("api-gateway")
        .setProxyPort(8080)
        .setOriginHost("api-server")
        .setOriginPort(3000)
        .addInterceptor(MyHeaderInterceptor.class)
        .addInterceptor(MyBodyFilterInterceptor.class);
```

Interceptor classes are resolved via Guice, so they support `@Inject`.

