package com.guicedee.examples.vertx.grpc;

import com.google.inject.Inject;
import io.vertx.grpc.client.GrpcClient;
import io.vertx.grpc.server.GrpcServer;

import java.util.logging.Logger;

/**
 * Demonstrates using the injected gRPC server and client for common operations.
 * <p>
 * This example shows:
 * <ul>
 *   <li>Injecting {@link GrpcServer} to register service handlers</li>
 *   <li>Injecting {@link GrpcClient} for making outbound gRPC calls</li>
 *   <li>Using the request/response API with ServiceMethod constants</li>
 *   <li>Configuring deadlines and timeouts</li>
 * </ul>
 * <p>
 * <b>Note:</b> To use generated stubs, you need to add the Vert.x gRPC protoc plugin
 * to your build and generate Java classes from your {@code .proto} files.
 *
 * <h3>Registering a service handler (request/response API)</h3>
 * <pre>{@code
 * // Using generated ServiceMethod constants:
 * grpcServer.callHandler(GreeterGrpcService.SayHello, request -> {
 *     request.handler(hello -> {
 *         GrpcServerResponse<HelloRequest, HelloReply> response = request.response();
 *         HelloReply reply = HelloReply.newBuilder()
 *                 .setMessage("Hello " + hello.getName())
 *                 .build();
 *         response.end(reply);
 *     });
 * });
 * }</pre>
 *
 * <h3>Making a client call</h3>
 * <pre>{@code
 * SocketAddress server = SocketAddress.inetSocketAddress(50051, "localhost");
 * grpcClient.request(server, GreeterGrpcClient.SayHello)
 *     .compose(request -> {
 *         request.end(HelloRequest.newBuilder().setName("World").build());
 *         return request.response().compose(resp -> resp.last());
 *     })
 *     .onSuccess(reply -> log.info("Received: {}", reply.getMessage()));
 * }</pre>
 *
 * <h3>Using idiomatic generated stubs</h3>
 * <pre>{@code
 * // Server-side (extend generated service class):
 * GreeterGrpcService service = GreeterGrpcService.create(new GreeterService() {
 *     @Override
 *     public Future<HelloReply> sayHello(HelloRequest request) {
 *         return Future.succeededFuture(HelloReply.newBuilder()
 *                 .setMessage("Hello " + request.getName())
 *                 .build());
 *     }
 * });
 * grpcServer.addService(service);
 *
 * // Client-side:
 * GreeterGrpcClient greeterClient = GreeterGrpcClient.create(grpcClient,
 *     SocketAddress.inetSocketAddress(50051, "localhost"));
 * greeterClient.sayHello(HelloRequest.newBuilder().setName("World").build())
 *     .onSuccess(reply -> log.info("Reply: {}", reply.getMessage()));
 * }</pre>
 */
@SuppressWarnings("unused")
public class GrpcUsageExample {

    private static final Logger log = Logger.getLogger(GrpcUsageExample.class.getName());

    @Inject
    private GrpcServer grpcServer;

    @Inject
    private GrpcClient grpcClient;

    /**
     * Demonstrates that the gRPC server and client are injectable.
     * <p>
     * In a real application, you would use generated protobuf service stubs
     * with the Vert.x gRPC protoc plugin to register handlers and make calls.
     */
    public void verifyInjection() {
        log.info("📡 GrpcServer injected: " + (grpcServer != null));
        log.info("📡 GrpcClient injected: " + (grpcClient != null));
    }
}




