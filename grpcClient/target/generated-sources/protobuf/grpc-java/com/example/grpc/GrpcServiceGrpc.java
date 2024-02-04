package com.example.grpc;

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
 * <pre>
 *Логическое объединение методов
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.24.0)",
    comments = "Source: GrpcService.proto")
public final class GrpcServiceGrpc {

  private GrpcServiceGrpc() {}

  public static final String SERVICE_NAME = "com.example.grpc.GrpcService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.grpc.GrpcServiceOuterClass.GrpcRequest,
      com.example.grpc.GrpcServiceOuterClass.GrpcResponse> getGetMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getMessage",
      requestType = com.example.grpc.GrpcServiceOuterClass.GrpcRequest.class,
      responseType = com.example.grpc.GrpcServiceOuterClass.GrpcResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.grpc.GrpcServiceOuterClass.GrpcRequest,
      com.example.grpc.GrpcServiceOuterClass.GrpcResponse> getGetMessageMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.GrpcServiceOuterClass.GrpcRequest, com.example.grpc.GrpcServiceOuterClass.GrpcResponse> getGetMessageMethod;
    if ((getGetMessageMethod = GrpcServiceGrpc.getGetMessageMethod) == null) {
      synchronized (GrpcServiceGrpc.class) {
        if ((getGetMessageMethod = GrpcServiceGrpc.getGetMessageMethod) == null) {
          GrpcServiceGrpc.getGetMessageMethod = getGetMessageMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.GrpcServiceOuterClass.GrpcRequest, com.example.grpc.GrpcServiceOuterClass.GrpcResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.GrpcServiceOuterClass.GrpcRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.GrpcServiceOuterClass.GrpcResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GrpcServiceMethodDescriptorSupplier("getMessage"))
              .build();
        }
      }
    }
    return getGetMessageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.example.grpc.GrpcServiceOuterClass.GrpcResponse> getGetCurrentMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getCurrentMessage",
      requestType = com.google.protobuf.Empty.class,
      responseType = com.example.grpc.GrpcServiceOuterClass.GrpcResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.example.grpc.GrpcServiceOuterClass.GrpcResponse> getGetCurrentMessageMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, com.example.grpc.GrpcServiceOuterClass.GrpcResponse> getGetCurrentMessageMethod;
    if ((getGetCurrentMessageMethod = GrpcServiceGrpc.getGetCurrentMessageMethod) == null) {
      synchronized (GrpcServiceGrpc.class) {
        if ((getGetCurrentMessageMethod = GrpcServiceGrpc.getGetCurrentMessageMethod) == null) {
          GrpcServiceGrpc.getGetCurrentMessageMethod = getGetCurrentMessageMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.example.grpc.GrpcServiceOuterClass.GrpcResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getCurrentMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.GrpcServiceOuterClass.GrpcResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GrpcServiceMethodDescriptorSupplier("getCurrentMessage"))
              .build();
        }
      }
    }
    return getGetCurrentMessageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.GrpcServiceOuterClass.GrpcRequest,
      com.google.protobuf.Empty> getClientStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "clientStream",
      requestType = com.example.grpc.GrpcServiceOuterClass.GrpcRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.example.grpc.GrpcServiceOuterClass.GrpcRequest,
      com.google.protobuf.Empty> getClientStreamMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.GrpcServiceOuterClass.GrpcRequest, com.google.protobuf.Empty> getClientStreamMethod;
    if ((getClientStreamMethod = GrpcServiceGrpc.getClientStreamMethod) == null) {
      synchronized (GrpcServiceGrpc.class) {
        if ((getClientStreamMethod = GrpcServiceGrpc.getClientStreamMethod) == null) {
          GrpcServiceGrpc.getClientStreamMethod = getClientStreamMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.GrpcServiceOuterClass.GrpcRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "clientStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.GrpcServiceOuterClass.GrpcRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new GrpcServiceMethodDescriptorSupplier("clientStream"))
              .build();
        }
      }
    }
    return getClientStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.example.grpc.GrpcServiceOuterClass.GrpcResponse> getServerStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "serverStream",
      requestType = com.google.protobuf.Empty.class,
      responseType = com.example.grpc.GrpcServiceOuterClass.GrpcResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.example.grpc.GrpcServiceOuterClass.GrpcResponse> getServerStreamMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, com.example.grpc.GrpcServiceOuterClass.GrpcResponse> getServerStreamMethod;
    if ((getServerStreamMethod = GrpcServiceGrpc.getServerStreamMethod) == null) {
      synchronized (GrpcServiceGrpc.class) {
        if ((getServerStreamMethod = GrpcServiceGrpc.getServerStreamMethod) == null) {
          GrpcServiceGrpc.getServerStreamMethod = getServerStreamMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.example.grpc.GrpcServiceOuterClass.GrpcResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "serverStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.GrpcServiceOuterClass.GrpcResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GrpcServiceMethodDescriptorSupplier("serverStream"))
              .build();
        }
      }
    }
    return getServerStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.grpc.GrpcServiceOuterClass.GrpcRequest,
      com.example.grpc.GrpcServiceOuterClass.GrpcResponse> getBiDirectionalStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "biDirectionalStream",
      requestType = com.example.grpc.GrpcServiceOuterClass.GrpcRequest.class,
      responseType = com.example.grpc.GrpcServiceOuterClass.GrpcResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.example.grpc.GrpcServiceOuterClass.GrpcRequest,
      com.example.grpc.GrpcServiceOuterClass.GrpcResponse> getBiDirectionalStreamMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.GrpcServiceOuterClass.GrpcRequest, com.example.grpc.GrpcServiceOuterClass.GrpcResponse> getBiDirectionalStreamMethod;
    if ((getBiDirectionalStreamMethod = GrpcServiceGrpc.getBiDirectionalStreamMethod) == null) {
      synchronized (GrpcServiceGrpc.class) {
        if ((getBiDirectionalStreamMethod = GrpcServiceGrpc.getBiDirectionalStreamMethod) == null) {
          GrpcServiceGrpc.getBiDirectionalStreamMethod = getBiDirectionalStreamMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.GrpcServiceOuterClass.GrpcRequest, com.example.grpc.GrpcServiceOuterClass.GrpcResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "biDirectionalStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.GrpcServiceOuterClass.GrpcRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.GrpcServiceOuterClass.GrpcResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GrpcServiceMethodDescriptorSupplier("biDirectionalStream"))
              .build();
        }
      }
    }
    return getBiDirectionalStreamMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GrpcServiceStub newStub(io.grpc.Channel channel) {
    return new GrpcServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GrpcServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new GrpcServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GrpcServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new GrpcServiceFutureStub(channel);
  }

  /**
   * <pre>
   *Логическое объединение методов
   * </pre>
   */
  public static abstract class GrpcServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getMessage(com.example.grpc.GrpcServiceOuterClass.GrpcRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.GrpcServiceOuterClass.GrpcResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetMessageMethod(), responseObserver);
    }

    /**
     */
    public void getCurrentMessage(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.example.grpc.GrpcServiceOuterClass.GrpcResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetCurrentMessageMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.example.grpc.GrpcServiceOuterClass.GrpcRequest> clientStream(
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      return asyncUnimplementedStreamingCall(getClientStreamMethod(), responseObserver);
    }

    /**
     */
    public void serverStream(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.example.grpc.GrpcServiceOuterClass.GrpcResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getServerStreamMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.example.grpc.GrpcServiceOuterClass.GrpcRequest> biDirectionalStream(
        io.grpc.stub.StreamObserver<com.example.grpc.GrpcServiceOuterClass.GrpcResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getBiDirectionalStreamMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetMessageMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.grpc.GrpcServiceOuterClass.GrpcRequest,
                com.example.grpc.GrpcServiceOuterClass.GrpcResponse>(
                  this, METHODID_GET_MESSAGE)))
          .addMethod(
            getGetCurrentMessageMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                com.example.grpc.GrpcServiceOuterClass.GrpcResponse>(
                  this, METHODID_GET_CURRENT_MESSAGE)))
          .addMethod(
            getClientStreamMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                com.example.grpc.GrpcServiceOuterClass.GrpcRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_CLIENT_STREAM)))
          .addMethod(
            getServerStreamMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                com.example.grpc.GrpcServiceOuterClass.GrpcResponse>(
                  this, METHODID_SERVER_STREAM)))
          .addMethod(
            getBiDirectionalStreamMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.example.grpc.GrpcServiceOuterClass.GrpcRequest,
                com.example.grpc.GrpcServiceOuterClass.GrpcResponse>(
                  this, METHODID_BI_DIRECTIONAL_STREAM)))
          .build();
    }
  }

  /**
   * <pre>
   *Логическое объединение методов
   * </pre>
   */
  public static final class GrpcServiceStub extends io.grpc.stub.AbstractStub<GrpcServiceStub> {
    private GrpcServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GrpcServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GrpcServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GrpcServiceStub(channel, callOptions);
    }

    /**
     */
    public void getMessage(com.example.grpc.GrpcServiceOuterClass.GrpcRequest request,
        io.grpc.stub.StreamObserver<com.example.grpc.GrpcServiceOuterClass.GrpcResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetMessageMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getCurrentMessage(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.example.grpc.GrpcServiceOuterClass.GrpcResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetCurrentMessageMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.example.grpc.GrpcServiceOuterClass.GrpcRequest> clientStream(
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getClientStreamMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void serverStream(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.example.grpc.GrpcServiceOuterClass.GrpcResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getServerStreamMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.example.grpc.GrpcServiceOuterClass.GrpcRequest> biDirectionalStream(
        io.grpc.stub.StreamObserver<com.example.grpc.GrpcServiceOuterClass.GrpcResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getBiDirectionalStreamMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   *Логическое объединение методов
   * </pre>
   */
  public static final class GrpcServiceBlockingStub extends io.grpc.stub.AbstractStub<GrpcServiceBlockingStub> {
    private GrpcServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GrpcServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GrpcServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GrpcServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.grpc.GrpcServiceOuterClass.GrpcResponse getMessage(com.example.grpc.GrpcServiceOuterClass.GrpcRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetMessageMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.grpc.GrpcServiceOuterClass.GrpcResponse getCurrentMessage(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), getGetCurrentMessageMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.example.grpc.GrpcServiceOuterClass.GrpcResponse> serverStream(
        com.google.protobuf.Empty request) {
      return blockingServerStreamingCall(
          getChannel(), getServerStreamMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *Логическое объединение методов
   * </pre>
   */
  public static final class GrpcServiceFutureStub extends io.grpc.stub.AbstractStub<GrpcServiceFutureStub> {
    private GrpcServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GrpcServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GrpcServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GrpcServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.GrpcServiceOuterClass.GrpcResponse> getMessage(
        com.example.grpc.GrpcServiceOuterClass.GrpcRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetMessageMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.grpc.GrpcServiceOuterClass.GrpcResponse> getCurrentMessage(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getGetCurrentMessageMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_MESSAGE = 0;
  private static final int METHODID_GET_CURRENT_MESSAGE = 1;
  private static final int METHODID_SERVER_STREAM = 2;
  private static final int METHODID_CLIENT_STREAM = 3;
  private static final int METHODID_BI_DIRECTIONAL_STREAM = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GrpcServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GrpcServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_MESSAGE:
          serviceImpl.getMessage((com.example.grpc.GrpcServiceOuterClass.GrpcRequest) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.GrpcServiceOuterClass.GrpcResponse>) responseObserver);
          break;
        case METHODID_GET_CURRENT_MESSAGE:
          serviceImpl.getCurrentMessage((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.GrpcServiceOuterClass.GrpcResponse>) responseObserver);
          break;
        case METHODID_SERVER_STREAM:
          serviceImpl.serverStream((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.GrpcServiceOuterClass.GrpcResponse>) responseObserver);
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
        case METHODID_CLIENT_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.clientStream(
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
        case METHODID_BI_DIRECTIONAL_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.biDirectionalStream(
              (io.grpc.stub.StreamObserver<com.example.grpc.GrpcServiceOuterClass.GrpcResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class GrpcServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GrpcServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.grpc.GrpcServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GrpcService");
    }
  }

  private static final class GrpcServiceFileDescriptorSupplier
      extends GrpcServiceBaseDescriptorSupplier {
    GrpcServiceFileDescriptorSupplier() {}
  }

  private static final class GrpcServiceMethodDescriptorSupplier
      extends GrpcServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GrpcServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (GrpcServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GrpcServiceFileDescriptorSupplier())
              .addMethod(getGetMessageMethod())
              .addMethod(getGetCurrentMessageMethod())
              .addMethod(getClientStreamMethod())
              .addMethod(getServerStreamMethod())
              .addMethod(getBiDirectionalStreamMethod())
              .build();
        }
      }
    }
    return result;
  }
}
