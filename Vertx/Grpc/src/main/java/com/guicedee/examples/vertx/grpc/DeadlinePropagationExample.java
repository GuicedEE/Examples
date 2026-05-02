package com.guicedee.examples.vertx.grpc;

import com.guicedee.vertx.grpc.GrpcConnectionInfo;
import com.guicedee.vertx.grpc.GrpcModule;

/**
 * Example gRPC configuration with deadline propagation and scheduling.
 * <p>
 * Demonstrates how to configure the gRPC server to:
 * <ul>
 *   <li>Automatically schedule deadlines when a timeout is received from the client</li>
 *   <li>Propagate deadlines to downstream gRPC client calls</li>
 * </ul>
 * <p>
 * This is useful for microservice chains where you want timeout cascading.
 */
public class DeadlinePropagationExample extends GrpcModule<DeadlinePropagationExample> {

    @Override
    protected GrpcConnectionInfo getGrpcConnectionInfo() {
        return new GrpcConnectionInfo()
                .setName("deadline-grpc")
                .setHost("0.0.0.0")
                .setPort(50051)
                .setScheduleDeadlineAutomatically(true)
                .setDeadlinePropagation(true)
                .setDefaultConnection(false);
    }
}

