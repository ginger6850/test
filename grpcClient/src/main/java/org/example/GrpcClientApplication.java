package org.example;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;
import org.example.impl.GrpcStringClientImpl;
import org.slf4j.LoggerFactory;

@Slf4j
public class GrpcClientApplication {
    public static void main(String[] args) {
        //Из логов убраны отладочные сообщения netty
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        Logger rootLogger = loggerContext.getLogger("io.grpc.netty");
        rootLogger.setLevel(ch.qos.logback.classic.Level.WARN);

        //Создаем канал для соединения с сервером
        ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:8080")
                .usePlaintext()
                .build();

        GrpcStringClient client = new GrpcStringClientImpl(channel);//Создаем клиента
        client.getMessage();//Получение ответа на основе данных клиента
        client.getCurrentMessage();//Получение ответа на пустой запрос
        client.serverStream();//Стримминг на стороне сервера
        client.biDirectionalStream();//Двунаправленный стрим
        client.clientStream(10);//Стримминг на стороне клиента

        channel.shutdownNow();
        log.info("Спасибо за внимание!))");
    }
}
