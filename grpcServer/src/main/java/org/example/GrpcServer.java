package org.example;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;


@Slf4j
public class GrpcServer {
    public static void main( String[] args ) throws IOException, InterruptedException {
     int port = 8080;// grpc может быть назначен любой порт
        Server server = ServerBuilder.forPort(port)
                .addService(new GrpcServiceImpl())
                .addService(new GrpcNumberServiceImpl())
                .build();// Создаем сервер, добавляем в него нужное кол-во сервисов
        server.start();

        log.info("Server start");
        server.awaitTermination();// Ожидание выполнения всех задач
        log.info("Server is waiting for client, port: {}", port);
    }
}
