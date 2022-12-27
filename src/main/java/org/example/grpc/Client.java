package org.example.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class Client {
    public static void main(String[] args) {
        ManagedChannel channel =
                ManagedChannelBuilder.forTarget("localhost:8088").usePlaintext().build();

        GreetingServiceGrpc.GreetingServiceBlockingStub stub
                = GreetingServiceGrpc.newBlockingStub(channel);

        StartServiceClient.HelloRequest req
                = StartServiceClient.HelloRequest.newBuilder().setName("Alex").build();

        StartServiceClient.HelloResponse response = stub.greeting(req);

        System.out.println(response);
        channel.shutdownNow();
    }
}
