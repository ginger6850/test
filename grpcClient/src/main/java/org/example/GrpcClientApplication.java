package org.example;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.example.impl.GrpcStringClientImpl;


public class GrpcClientApplication {
    public static void main(String[] args) {
        //Создаем канал для соединения с сервером
        ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:8080")
                .usePlaintext()
                .build();

        GrpcStringClient client = new GrpcStringClientImpl(channel);//Создаем клиента. Вызываем на нем методы
        client.getMessage();//Получение ответа на основе данных клиента
        client.getCurrentMessage();//Получение ответа на пустой запрос
        client.serverStream();//Стримминг на стороне сервера
        client.biDirectionalStream();
//        client.getMessage();
//        client.getCurrentMessage();
        client.clientStream(10);

        channel.shutdownNow();
    }
}
