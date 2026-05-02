package com.guicedee.examples.vertx.grpc;

import com.guicedee.vertx.grpc.GrpcOptions;

/**
 * Annotation-based gRPC configuration example.
 * <p>
 * This is the simplest way to configure gRPC — just annotate a class
 * and the server is auto-discovered at startup.
 * <p>
 * All values support {@code ${ENV_VAR:default}} placeholder syntax.
 */
@GrpcOptions(
        name = "annotated-grpc",
        host = "${GRPC_HOST:0.0.0.0}",
        port = 50051,
        grpcWebEnabled = true,
        transcodingEnabled = true,
        defaultConnection = true
)
public class AnnotationBasedGrpcExample {
    // No code needed — the @GrpcOptions annotation is auto-discovered
    // by GrpcPreStartup and a GrpcServer + GrpcClient are created and bound in Guice.
    //
    // Inject anywhere:
    //   @Inject GrpcServer grpcServer;
    //   @Inject GrpcClient grpcClient;
    //   @Inject @Named("annotated-grpc") GrpcServer namedServer;
}

