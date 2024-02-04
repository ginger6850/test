package org.example;


import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import com.example1.grpc.GrpcNumberServiceGrpc;
import com.example1.grpc.GrpcNumberServiceOuterClass;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

//Сервис имеет реализованый серверный стримминг, но создан только с целью показать возможность взаимодействия сервера с несколькими сервисами
public class GrpcNumberClient {

    public static void main(String[] args) throws InterruptedException {
        //Из логов убраны отладочные сообщения netty
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        Logger rootLogger = loggerContext.getLogger("io.grpc.netty");
        rootLogger.setLevel(ch.qos.logback.classic.Level.WARN);
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

