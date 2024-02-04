package org.example;


import ch.qos.logback.classic.Level;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.Logger;

import java.io.IOException;


@Slf4j
public class GrpcServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        //Из логов убраны отладочные сообщения netty
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        Logger rootLogger = loggerContext.getLogger("io.grpc.netty");
        rootLogger.setLevel(Level.WARN);
        int port = 8080;// grpc может быть назначен любой порт
        Server server = ServerBuilder.forPort(port)
                .addService(new GrpcServiceImpl())
                .addService(new GrpcNumberServiceImpl())
                .build();// Создаем сервер, добавляем в него нужное кол-во сервисов
        server.start();

        log.info("Server start");
        server.awaitTermination();
    }
}
