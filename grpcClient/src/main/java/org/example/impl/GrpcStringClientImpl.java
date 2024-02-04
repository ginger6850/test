package org.example.impl;

import com.example.grpc.GrpcServiceGrpc;
import com.example.grpc.GrpcServiceOuterClass;
import com.google.protobuf.Empty;
import io.grpc.Channel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import lombok.SneakyThrows;
import org.example.GrpcStringClient;

import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class GrpcStringClientImpl implements GrpcStringClient {
    private static final String HOST = "localhost";
    private static final int PORT = 8080;
    private static final String TARGET = HOST + ":" + PORT;
    private final GrpcServiceGrpc.GrpcServiceBlockingStub blockingStub;//Блокирующая заглушка, которая поддерживает вызовы унарного и потокового вывода
    private final GrpcServiceGrpc.GrpcServiceStub asyncStub;//Ассинхронная заглушка, которая поддерживает все типы вызовов


    public GrpcStringClientImpl(Channel channel) {
        blockingStub = GrpcServiceGrpc.newBlockingStub(channel);
        asyncStub = GrpcServiceGrpc.newStub(ManagedChannelBuilder.forTarget(TARGET)
                .usePlaintext()
                .build());
    }

    @Override
    public void getMessage() {
        GrpcServiceOuterClass.GrpcRequest request =
                GrpcServiceOuterClass.GrpcRequest.newBuilder()
                        .setName("Lada Antsifirova")
                        .addTasks("saga")
                        .addTasks("grpc")
                        .addTasks("hibernate 5 vs 6")
                        .addTasks("patterns")
                        .build();//Создаем запрос с данными
        GrpcServiceOuterClass.GrpcResponse response = blockingStub.getMessage(request);//Вызываем метод сервера через блокирующую заглушку
        System.out.println(response);

    }

    @Override
    public void getCurrentMessage() {
        Empty request = Empty.newBuilder().build();
        GrpcServiceOuterClass.GrpcResponse currentMessage = blockingStub.getCurrentMessage(request);
        System.out.println(currentMessage.getMessage());
    }

    @Override
    @SneakyThrows
    public void clientStream(int time) {
        final CountDownLatch finishLatch = new CountDownLatch(1);
        StreamObserver<Empty> responseObserver = new StreamObserver<>() {
            @Override
            public void onNext(Empty response) {
                System.out.println("Finished responseObserver.clientStream");
            }

            @Override
            public void onError(Throwable t) {
                Status status = Status.fromThrowable(t);
                System.out.println("ClientStream Failed:" + status);
                finishLatch.countDown();
            }

            @Override
            public void onCompleted() {
                System.out.println("Finished ClientStream");
                finishLatch.countDown();
            }
        };

        StreamObserver<GrpcServiceOuterClass.GrpcRequest> requestObserver
                = asyncStub.clientStream(responseObserver);
        try {
            for (int i = 0; i < time; ++i) {
                GrpcServiceOuterClass.GrpcRequest request = GrpcServiceOuterClass.GrpcRequest
                        .newBuilder()
                        .setId(i)
                        .build();
                requestObserver.onNext(request);

                Thread.sleep(100);

                if (finishLatch.getCount() == 0) {
                    return;
                }
            }
        } catch (RuntimeException e) {
            requestObserver.onError(e);
            throw e;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            requestObserver.onCompleted();
            finishLatch.await(1, TimeUnit.MILLISECONDS);

    }

    @Override
    public void serverStream() {
        Iterator<GrpcServiceOuterClass.GrpcResponse> messages = Collections.emptyIterator();//Для обхода полученных ответов
        try {
            messages = blockingStub.serverStream(Empty.newBuilder().build());//Отправляем пустой запрос на сервер через блокирующую заглушку
        } catch (StatusRuntimeException e) {
            System.out.println("RPC failed: " + e.getStatus());
        }

        messages.forEachRemaining(response -> System.out.println("How much does it cost to increase your salary? " +
                response.getMessage() + "%"));// На каждый ответ сервера
    }
    @Override
    public void biDirectionalStream() {

        StreamObserver<GrpcServiceOuterClass.GrpcResponse> responseObserver = new StreamObserver<>() {

            @Override
            public void onNext(GrpcServiceOuterClass.GrpcResponse response) {

                    System.out.println("Ответ от сервера: response.getCount() " + response.getCount() + " response.getMessage() " + response.getMessage());

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {
                System.out.println("Finish biDirectionalStream");
            }
        };
        StreamObserver<GrpcServiceOuterClass.GrpcRequest> requestObserver = asyncStub.biDirectionalStream(responseObserver);
        try {
        for (int i = 0; i < 1; i++) {
            GrpcServiceOuterClass.GrpcRequest request = GrpcServiceOuterClass.GrpcRequest
                    .newBuilder()
                    .setName("Lada")
                    .build();
            requestObserver.onNext(request);
            Thread.sleep(100);
        }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        requestObserver.onCompleted();
    }

}
