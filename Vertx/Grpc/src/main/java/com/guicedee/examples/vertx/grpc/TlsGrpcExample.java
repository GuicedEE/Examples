package com.guicedee.examples.vertx.grpc;

import com.guicedee.vertx.grpc.GrpcConnectionInfo;
import com.guicedee.vertx.grpc.GrpcModule;

/**
 * TLS-enabled gRPC configuration example.
 * <p>
 * Demonstrates how to configure a gRPC server with TLS/SSL.
 * Provide PEM certificate and key paths via environment variables:
 * <ul>
 *   <li>{@code GRPC_TLS_CERT_PATH} — path to the PEM certificate file</li>
 *   <li>{@code GRPC_TLS_KEY_PATH} — path to the PEM private key file</li>
 * </ul>
 */
public class TlsGrpcExample extends GrpcModule<TlsGrpcExample> {

    @Override
    protected GrpcConnectionInfo getGrpcConnectionInfo() {
        return new GrpcConnectionInfo()
                .setName("secure-grpc")
                .setHost("0.0.0.0")
                .setPort(50443)
                .setTlsEnabled(true)
                .setTlsCertPath(System.getenv().getOrDefault("GRPC_TLS_CERT_PATH", "/path/to/server.crt"))
                .setTlsKeyPath(System.getenv().getOrDefault("GRPC_TLS_KEY_PATH", "/path/to/server.key"))
                .setDefaultConnection(false);
    }
}

