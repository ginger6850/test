package org.example;


import com.example1.grpc.GrpcNumberServiceGrpc;
import com.example1.grpc.GrpcNumberServiceOuterClass;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class GrpcNumberServiceImpl extends GrpcNumberServiceGrpc.GrpcNumberServiceImplBase {
    private final ScheduledExecutorService executor = Executors.newScheduledThreadPool(10);

    @Override
    public void getNumber(GrpcNumberServiceOuterClass.GrpcNumberRequest request, StreamObserver<GrpcNumberServiceOuterClass.GrpcNumberResponse> responseObserver) {
        System.out.println("request for the new sequence of numbers, firstValue: " + request.getFirstValue() + " , lastValue: " + request.getLastValue());
        AtomicLong currentValue = new AtomicLong(request.getFirstValue());

        Runnable task = () -> {
            long value = currentValue.incrementAndGet();
            GrpcNumberServiceOuterClass.GrpcNumberResponse response = GrpcNumberServiceOuterClass.GrpcNumberResponse.newBuilder().setNumber(value).build();
            responseObserver.onNext(response);
            if (value == request.getLastValue()) {
                executor.shutdown();
                responseObserver.onCompleted();
            }
        };
        executor.scheduleAtFixedRate(task, 0, 2, TimeUnit.SECONDS);
    }
}
