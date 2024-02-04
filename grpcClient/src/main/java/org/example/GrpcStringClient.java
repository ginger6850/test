package org.example;

import com.example.grpc.GrpcServiceOuterClass;
import io.grpc.stub.StreamObserver;

public interface GrpcStringClient {

    void getMessage();
    void getCurrentMessage();

    void clientStream(int time);

    void serverStream();


    void biDirectionalStream();
}
