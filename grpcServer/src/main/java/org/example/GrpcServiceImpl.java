package org.example;

import com.example.grpc.GrpcServiceGrpc;
import com.example.grpc.GrpcServiceOuterClass;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;


@Slf4j
//Реализация методов интерфейса,сгенерированного proto файлом
public class GrpcServiceImpl extends GrpcServiceGrpc.GrpcServiceImplBase {
    @Override
    public void getMessage(GrpcServiceOuterClass.GrpcRequest request, StreamObserver<GrpcServiceOuterClass.GrpcResponse> responseObserver) {
        log.info("The Server received the Client's request: {} ", request);
        GrpcServiceOuterClass.GrpcResponse response = GrpcServiceOuterClass
                .GrpcResponse
                .newBuilder()
                .setMessage("Hello! My name is "
                            + request.getName()
                            + ". Its tasks for certification: "
                            + request.getTasks(0)
                            + ", "
                            + request.getTasks(1)
                            + ", "
                            + request.getTasks(2)
                            + ", "
                            + request.getTasks(3))
                .build();//Генерируем ответ сервера
        log.info("The server generated a response: {}", response);
        responseObserver.onNext(response);//Ответ завернут в StreamObserver для обеспечения возможности потоковой передачи

        responseObserver.onCompleted();
    }

    @Override
    public void getCurrentMessage(Empty request, StreamObserver<GrpcServiceOuterClass.GrpcResponse> responseObserver) {
        log.info("The Server received an empty request from the Client: {}", request);
        responseObserver.onNext(GrpcServiceOuterClass.GrpcResponse
                .newBuilder()
                .setMessage("Maybe it's time for her to raise her salary and grade?")
                .build());
        log.info("The Server generated a response to the Client");
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<GrpcServiceOuterClass.GrpcRequest> clientStream(StreamObserver<Empty> responseObserver) {
        return new StreamObserver<>() {
            @Override
            public void onNext(GrpcServiceOuterClass.GrpcRequest request) {
                log.info("Client id: {} ", request.getId());
            }

            @Override
            public void onError(Throwable throwable) {
                log.error("Throwable: ", throwable);
            }

            @Override
            public void onCompleted() {

            }
        };
    }

    @Override

    public void serverStream(Empty request, StreamObserver<GrpcServiceOuterClass.GrpcResponse> responseObserver) {
        log.info("The Server received an empty request from the Client: {}", request);
        int percent = 0;
        for (int i = 0; i < 7; i++) {
            percent += 5;
            responseObserver.onNext(GrpcServiceOuterClass.GrpcResponse
                    .newBuilder()
                    .setMessage(String.valueOf(percent))
                    .build());
            log.info("The Server generated a response to the Client: {}", percent);
        }
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<GrpcServiceOuterClass.GrpcRequest> biDirectionalStream(StreamObserver<GrpcServiceOuterClass.GrpcResponse> responseObserver) {
        return new StreamObserver<>() {//Создаем стрим для ответов клиенту
            @Override
            public void onNext(GrpcServiceOuterClass.GrpcRequest request) {

                for (int i = 0; i <= 5; i++) {

                    GrpcServiceOuterClass.GrpcResponse response = GrpcServiceOuterClass.GrpcResponse
                            .newBuilder()
                            .setCount(i)
                            .setMessage(request.getName())
                            .build();//Генерируем ответ сервера на запрос клиента
                    log.info("The server received the client name: request.getName() = {}", request.getName());
                    log.info("The Server sent a response to the Client: {}", response);
                    responseObserver.onNext(response);
                }

            }

            @Override
            public void onError(Throwable throwable) {
                log.error("Throwable: ", throwable);
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }
}

