package org.example.impl;

import com.example.grpc.GrpcServiceGrpc;
import com.example.grpc.GrpcServiceOuterClass;
import com.google.protobuf.Empty;
import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.example.GrpcStringClient;

import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

@Slf4j
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
        log.info("The client created a request with data: {}", request);
        GrpcServiceOuterClass.GrpcResponse response = blockingStub.getMessage(request);//Вызываем метод сервера через блокирующую заглушку
        log.info("The Client received the Server's response: {}", response);

    }

    @Override
    public void getCurrentMessage() {
        Empty request = Empty.newBuilder().build();
        GrpcServiceOuterClass.GrpcResponse currentMessage = blockingStub.getCurrentMessage(request);//Вызываем метод сервера через блокирующую заглушку
        log.info("The Client sent an empty request to the Server: {} ", request);
        log.info("The Client received the Server's response: {}", currentMessage);
    }

    @Override
    @SneakyThrows
    public void clientStream(int time) {
        final CountDownLatch finishLatch = new CountDownLatch(1);//Используем для синхронизации потоков
        StreamObserver<Empty> responseObserver = new StreamObserver<>() {
            @Override
            public void onNext(Empty response) {
                log.info("Finished responseObserver.clientStream");
            }

            @Override
            public void onError(Throwable t) {
                Status status = Status.fromThrowable(t);
                log.info("ClientStream Failed: {}", status);
                finishLatch.countDown();//Уменьшает счетчик блокировки, освобождая все ожидающие потоки, если счетчик достигает нуля.
            }

            @Override
            public void onCompleted() {
                log.info("Finished ClientStream");
                finishLatch.countDown();
            }
        };

        StreamObserver<GrpcServiceOuterClass.GrpcRequest> requestObserver
                = asyncStub.clientStream(responseObserver);//Вызываем метод сервера через асинхронную заглушку
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
        finishLatch.await();
        requestObserver.onCompleted();
    }

    @Override
    public void serverStream() {
        Iterator<GrpcServiceOuterClass.GrpcResponse> messages = Collections.emptyIterator();//Для обхода полученных ответов
        try {
            messages = blockingStub.serverStream(Empty.newBuilder().build());//Отправляем пустой запрос на сервер через блокирующую заглушку
        } catch (StatusRuntimeException e) {
            log.error("RPC failed: {}", e.getStatus());
        }

        messages.forEachRemaining(response -> log.info("How much does it cost to increase your salary? {}%",
                response.getMessage()));// На каждый ответ сервера
    }

    @Override
    public void biDirectionalStream() {
        //Для начал двустороннего обмена данными необходимо создать соединение с сервером. Для этого отправляем пустой запрос
        //Если соединение уже открыто, то данный шаг не нужен
//        Empty request = Empty.newBuilder().build();
//        GrpcServiceOuterClass.GrpcResponse currentMessage = blockingStub.getCurrentMessage(request);
//        log.info("Open connection: {}", currentMessage);
        //Создаем StreamObserver для стримминга ответов сервера
        StreamObserver<GrpcServiceOuterClass.GrpcResponse> responseObserver = new StreamObserver<>() {

            @Override
            public void onNext(GrpcServiceOuterClass.GrpcResponse response) {

                log.info("Server response:  response.getMessage(): {}, response.getCount(): {} ", response.getMessage(), response.getCount());

            }

            @Override
            public void onError(Throwable t) {
                Status status = Status.fromThrowable(t);
                log.info("BiDirectionalStream Failed: {}", status);
            }

            @Override
            public void onCompleted() {
                log.info("Finish biDirectionalStream");
            }
        };
        //Создаем StreamObserver для стримминга запросов к серверу на асинхронной заглушке
        StreamObserver<GrpcServiceOuterClass.GrpcRequest> requestObserver = asyncStub.biDirectionalStream(responseObserver);
        try {
            for (int i = 0; i < 1; i++) {
                GrpcServiceOuterClass.GrpcRequest requestStream = GrpcServiceOuterClass.GrpcRequest
                        .newBuilder()
                        .setName("How did Lada pass the certification?")
                        .build();
                requestObserver.onNext(requestStream);
                log.info("The Client sends a request with data to the Server: {}", requestStream);
                Thread.sleep(100);// Интервал между запросами к серверу
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        requestObserver.onCompleted();
    }

}
