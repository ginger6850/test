package org.example;

import com.example1.grpc.GrpcNumberServiceOuterClass;

import java.util.concurrent.CountDownLatch;


public class ClientStreamObserver implements io.grpc.stub.StreamObserver<GrpcNumberServiceOuterClass.GrpcNumberResponse> {

    private final CountDownLatch latch;

    public ClientStreamObserver(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void onNext(GrpcNumberServiceOuterClass.GrpcNumberResponse numberResponse) {
        System.out.println("new value: " + numberResponse.getNumber());
    }

    @Override
    public void onError(Throwable e) {
        latch.countDown();
    }

    @Override
    public void onCompleted() {
        latch.countDown();
    }
}
