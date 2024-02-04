package org.example;

import com.example.grpc.GrpcServiceGrpc;
import com.example.grpc.GrpcServiceOuterClass;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;


@Slf4j
//Реализация методов интерфейса,сгенерированного proto файлом
public class GrpcServiceImpl extends GrpcServiceGrpc.GrpcServiceImplBase {

    @Override//Метод реализует ответ сервера на основе данных, полученных от клиента
    public void getMessage(GrpcServiceOuterClass.GrpcRequest request, StreamObserver<GrpcServiceOuterClass.GrpcResponse> responseObserver) {
        System.out.println(request);//Запрос от клиента
//        log.info("Client request: {} ", request);
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
        log.info("Server response: {}", response);
        responseObserver.onNext(response);//Ответ завернут в StreamObserver для обеспечения возможности потоковой передачи

        responseObserver.onCompleted();
    }

    @Override//Метод реализует ответ сервера на пустой запрос
    public void getCurrentMessage(Empty request, StreamObserver<GrpcServiceOuterClass.GrpcResponse> responseObserver) {
        responseObserver.onNext(GrpcServiceOuterClass.GrpcResponse
                .newBuilder()
                .setMessage("Может стоит уже ей поднять зарплату и грейд?")
                .build());
        responseObserver.onCompleted();
    }

    @Override//Метод реализует стрим данных со стороны клиента
    public StreamObserver<GrpcServiceOuterClass.GrpcRequest> clientStream(StreamObserver<Empty> responseObserver) {
        return new StreamObserver<>() {
            @Override
            public void onNext(GrpcServiceOuterClass.GrpcRequest grpcRequest) {
//                log.info("Client id: {} ", grpcRequest.getId());
            }

            @Override
            public void onError(Throwable throwable) {
//                log.error("Throwable: ", throwable);
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }

    @Override
//Метод реализует стрим данных со стороны сервера. Клиент открывает соединение и сервер начинает стрим данных
    public void serverStream(Empty request, StreamObserver<GrpcServiceOuterClass.GrpcResponse> responseObserver) {
        int percent = 0;
        for (int i = 0; i < 7; i++) {
            percent += 5;
            responseObserver.onNext(GrpcServiceOuterClass.GrpcResponse
                    .newBuilder()
                    .setMessage(String.valueOf(percent))
                    .build());
        }
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<GrpcServiceOuterClass.GrpcRequest> biDirectionalStream(StreamObserver<GrpcServiceOuterClass.GrpcResponse> responseObserver) {
        return new StreamObserver<>() {//Создаем стрим для ответов клиенту
            @Override
            public void onNext(GrpcServiceOuterClass.GrpcRequest request) {

                for (int i = 0; i <= 1; i++) {

                    GrpcServiceOuterClass.GrpcResponse response = GrpcServiceOuterClass.GrpcResponse
                            .newBuilder()
                            .setCount(i)
                            .setMessage("Сервер получил имя клиента: request.getName() = " + request.getName())
                            .build();//Генерируем ответ сервера на запрос клиента
//                    log.info("Сервер получил имя клиента: request.getName() = {}", request.getName());
                    responseObserver.onNext(response);
                }

            }

            @Override
            public void onError(Throwable throwable) {
//                log.error("Throwable: ", throwable);
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }
}

