package com.example;

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
    value = "by gRPC proto compiler (version 1.15.1)",
    comments = "Source: sendMessage.proto")
public final class KotlinServiceGrpc {

  private KotlinServiceGrpc() {}

  public static final String SERVICE_NAME = "KotlinService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.SendMessage.PokemonMessage,
      com.example.SendMessage.PokemonResponseMessage> getSendMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sendMessage",
      requestType = com.example.SendMessage.PokemonMessage.class,
      responseType = com.example.SendMessage.PokemonResponseMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.example.SendMessage.PokemonMessage,
      com.example.SendMessage.PokemonResponseMessage> getSendMessageMethod() {
    io.grpc.MethodDescriptor<com.example.SendMessage.PokemonMessage, com.example.SendMessage.PokemonResponseMessage> getSendMessageMethod;
    if ((getSendMessageMethod = KotlinServiceGrpc.getSendMessageMethod) == null) {
      synchronized (KotlinServiceGrpc.class) {
        if ((getSendMessageMethod = KotlinServiceGrpc.getSendMessageMethod) == null) {
          KotlinServiceGrpc.getSendMessageMethod = getSendMessageMethod = 
              io.grpc.MethodDescriptor.<com.example.SendMessage.PokemonMessage, com.example.SendMessage.PokemonResponseMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "KotlinService", "sendMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.SendMessage.PokemonMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.SendMessage.PokemonResponseMessage.getDefaultInstance()))
                  .setSchemaDescriptor(new KotlinServiceMethodDescriptorSupplier("sendMessage"))
                  .build();
          }
        }
     }
     return getSendMessageMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static KotlinServiceStub newStub(io.grpc.Channel channel) {
    return new KotlinServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static KotlinServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new KotlinServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static KotlinServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new KotlinServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class KotlinServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void sendMessage(com.example.SendMessage.PokemonMessage request,
        io.grpc.stub.StreamObserver<com.example.SendMessage.PokemonResponseMessage> responseObserver) {
      asyncUnimplementedUnaryCall(getSendMessageMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSendMessageMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.example.SendMessage.PokemonMessage,
                com.example.SendMessage.PokemonResponseMessage>(
                  this, METHODID_SEND_MESSAGE)))
          .build();
    }
  }

  /**
   */
  public static final class KotlinServiceStub extends io.grpc.stub.AbstractStub<KotlinServiceStub> {
    private KotlinServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private KotlinServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected KotlinServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new KotlinServiceStub(channel, callOptions);
    }

    /**
     */
    public void sendMessage(com.example.SendMessage.PokemonMessage request,
        io.grpc.stub.StreamObserver<com.example.SendMessage.PokemonResponseMessage> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getSendMessageMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class KotlinServiceBlockingStub extends io.grpc.stub.AbstractStub<KotlinServiceBlockingStub> {
    private KotlinServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private KotlinServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected KotlinServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new KotlinServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<com.example.SendMessage.PokemonResponseMessage> sendMessage(
        com.example.SendMessage.PokemonMessage request) {
      return blockingServerStreamingCall(
          getChannel(), getSendMessageMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class KotlinServiceFutureStub extends io.grpc.stub.AbstractStub<KotlinServiceFutureStub> {
    private KotlinServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private KotlinServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected KotlinServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new KotlinServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_SEND_MESSAGE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final KotlinServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(KotlinServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_MESSAGE:
          serviceImpl.sendMessage((com.example.SendMessage.PokemonMessage) request,
              (io.grpc.stub.StreamObserver<com.example.SendMessage.PokemonResponseMessage>) responseObserver);
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

  private static abstract class KotlinServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    KotlinServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.SendMessage.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("KotlinService");
    }
  }

  private static final class KotlinServiceFileDescriptorSupplier
      extends KotlinServiceBaseDescriptorSupplier {
    KotlinServiceFileDescriptorSupplier() {}
  }

  private static final class KotlinServiceMethodDescriptorSupplier
      extends KotlinServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    KotlinServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (KotlinServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new KotlinServiceFileDescriptorSupplier())
              .addMethod(getSendMessageMethod())
              .build();
        }
      }
    }
    return result;
  }
}
