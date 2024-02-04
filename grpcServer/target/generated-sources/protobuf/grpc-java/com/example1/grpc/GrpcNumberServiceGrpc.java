package com.example1.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.24.0)",
    comments = "Source: GrpcNumberService.proto")
public final class GrpcNumberServiceGrpc {

  private GrpcNumberServiceGrpc() {}

  public static final String SERVICE_NAME = "com.example1.grpc.GrpcNumberService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example1.grpc.GrpcNumberServiceOuterClass.GrpcNumberRequest,
      com.example1.grpc.GrpcNumberServiceOuterClass.GrpcNumberResponse> getGetNumberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getNumber",
      requestType = com.example1.grpc.GrpcNumberServiceOuterClass.GrpcNumberRequest.class,
      responseType = com.example1.grpc.GrpcNumberServiceOuterClass.GrpcNumberResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.example1.grpc.GrpcNumberServiceOuterClass.GrpcNumberRequest,
      com.example1.grpc.GrpcNumberServiceOuterClass.GrpcNumberResponse> getGetNumberMethod() {
    io.grpc.MethodDescriptor<com.example1.grpc.GrpcNumberServiceOuterClass.GrpcNumberRequest, com.example1.grpc.GrpcNumberServiceOuterClass.GrpcNumberResponse> getGetNumberMethod;
    if ((getGetNumberMethod = GrpcNumberServiceGrpc.getGetNumberMethod) == null) {
      synchronized (GrpcNumberServiceGrpc.class) {
        if ((getGetNumberMethod = GrpcNumberServiceGrpc.getGetNumberMethod) == null) {
          GrpcNumberServiceGrpc.getGetNumberMethod = getGetNumberMethod =
              io.grpc.MethodDescriptor.<com.example1.grpc.GrpcNumberServiceOuterClass.GrpcNumberRequest, com.example1.grpc.GrpcNumberServiceOuterClass.GrpcNumberResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getNumber"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example1.grpc.GrpcNumberServiceOuterClass.GrpcNumberRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example1.grpc.GrpcNumberServiceOuterClass.GrpcNumberResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GrpcNumberServiceMethodDescriptorSupplier("getNumber"))
              .build();
        }
      }
    }
    return getGetNumberMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GrpcNumberServiceStub newStub(io.grpc.Channel channel) {
    return new GrpcNumberServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GrpcNumberServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new GrpcNumberServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GrpcNumberServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new GrpcNumberServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class GrpcNumberServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getNumber(com.example1.grpc.GrpcNumberServiceOuterClass.GrpcNumberRequest request,
        io.grpc.stub.StreamObserver<com.example1.grpc.GrpcNumberServiceOuterClass.GrpcNumberResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetNumberMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetNumberMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.example1.grpc.GrpcNumberServiceOuterClass.GrpcNumberRequest,
                com.example1.grpc.GrpcNumberServiceOuterClass.GrpcNumberResponse>(
                  this, METHODID_GET_NUMBER)))
          .build();
    }
  }

  /**
   */
  public static final class GrpcNumberServiceStub extends io.grpc.stub.AbstractStub<GrpcNumberServiceStub> {
    private GrpcNumberServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GrpcNumberServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GrpcNumberServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GrpcNumberServiceStub(channel, callOptions);
    }

    /**
     */
    public void getNumber(com.example1.grpc.GrpcNumberServiceOuterClass.GrpcNumberRequest request,
        io.grpc.stub.StreamObserver<com.example1.grpc.GrpcNumberServiceOuterClass.GrpcNumberResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetNumberMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class GrpcNumberServiceBlockingStub extends io.grpc.stub.AbstractStub<GrpcNumberServiceBlockingStub> {
    private GrpcNumberServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GrpcNumberServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GrpcNumberServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GrpcNumberServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<com.example1.grpc.GrpcNumberServiceOuterClass.GrpcNumberResponse> getNumber(
        com.example1.grpc.GrpcNumberServiceOuterClass.GrpcNumberRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetNumberMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class GrpcNumberServiceFutureStub extends io.grpc.stub.AbstractStub<GrpcNumberServiceFutureStub> {
    private GrpcNumberServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GrpcNumberServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GrpcNumberServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GrpcNumberServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_GET_NUMBER = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GrpcNumberServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GrpcNumberServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_NUMBER:
          serviceImpl.getNumber((com.example1.grpc.GrpcNumberServiceOuterClass.GrpcNumberRequest) request,
              (io.grpc.stub.StreamObserver<com.example1.grpc.GrpcNumberServiceOuterClass.GrpcNumberResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class GrpcNumberServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GrpcNumberServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example1.grpc.GrpcNumberServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GrpcNumberService");
    }
  }

  private static final class GrpcNumberServiceFileDescriptorSupplier
      extends GrpcNumberServiceBaseDescriptorSupplier {
    GrpcNumberServiceFileDescriptorSupplier() {}
  }

  private static final class GrpcNumberServiceMethodDescriptorSupplier
      extends GrpcNumberServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GrpcNumberServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (GrpcNumberServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GrpcNumberServiceFileDescriptorSupplier())
              .addMethod(getGetNumberMethod())
              .build();
        }
      }
    }
    return result;
  }
}
