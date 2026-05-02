package com.guicedee.examples.vertx.grpc;

import com.guicedee.vertx.grpc.GrpcConnectionInfo;
import com.guicedee.vertx.grpc.GrpcModule;

/**
 * Example gRPC module that starts a gRPC server on localhost.
 * <p>
 * Configuration is driven by environment variables:
 * <ul>
 *   <li>GRPC_HOST — gRPC server host (default: 0.0.0.0)</li>
 *   <li>GRPC_PORT — gRPC server port (default: 50051)</li>
 *   <li>GRPC_TLS_ENABLED — Enable TLS (default: false)</li>
 *   <li>GRPC_TLS_CERT_PATH — Path to PEM certificate</li>
 *   <li>GRPC_TLS_KEY_PATH — Path to PEM private key</li>
 * </ul>
 * <p>
 * Register this module via {@code module-info.java}:
 * <pre>
 * provides IGuiceModule with ExampleGrpcModule;
 * </pre>
 */
public class ExampleGrpcModule extends GrpcModule<ExampleGrpcModule> {

    @Override
    protected GrpcConnectionInfo getGrpcConnectionInfo() {
        String host = System.getProperty("GRPC_HOST",
                System.getenv().getOrDefault("GRPC_HOST", "0.0.0.0"));
        int port = Integer.parseInt(System.getProperty("GRPC_PORT",
                System.getenv().getOrDefault("GRPC_PORT", "50051")));

        return new GrpcConnectionInfo()
                .setName("example-grpc")
                .setHost(host)
                .setPort(port)
                .setGrpcWebEnabled(true)
                .setTranscodingEnabled(true)
                .setDefaultConnection(true);
    }
}

