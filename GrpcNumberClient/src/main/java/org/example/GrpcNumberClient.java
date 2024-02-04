package org.example;



import com.example1.grpc.GrpcNumberServiceGrpc;
import com.example1.grpc.GrpcNumberServiceOuterClass;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.CountDownLatch;

/**
 * Hello world!
 */
public class GrpcNumberClient {

    public static void main(String[] args) throws InterruptedException {

        ManagedChannel managedChannel = ManagedChannelBuilder.forTarget("localhost:8080")
                .usePlaintext()
                .build();

        GrpcNumberServiceGrpc.GrpcNumberServiceStub asyncClient = GrpcNumberServiceGrpc.newStub(managedChannel);

         CountDownLatch latch = new CountDownLatch(1);
        asyncClient.getNumber(makeNumberRequest(), new ClientStreamObserver(latch));

        latch.await();

        managedChannel.shutdown();
    }

    private static GrpcNumberServiceOuterClass.GrpcNumberRequest makeNumberRequest() {
        return GrpcNumberServiceOuterClass.GrpcNumberRequest.newBuilder()
                .setFirstValue(1)
                .setLastValue(10)
                .build();
    }
   }

