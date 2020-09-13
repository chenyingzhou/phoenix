package com.phoenix.message.grpc.service;

import com.phoenix.message.proto.*;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GrpcPushService extends PushServiceGrpc.PushServiceImplBase {
    @Override
    public void rpcFindPushTaskConfigList(RpcFindPushTaskConfigListReq request, StreamObserver<RpcFindPushTaskConfigListResp> responseObserver) {
        responseObserver.onNext(RpcFindPushTaskConfigListResp.newBuilder()
                .setData(RpcPaginationResult.newBuilder()
                        .setTotalCount(10)
                        .addList(RpcPushTaskConfig.newBuilder()
                                .setAppName("vova")
                                .build())
                        .addList(RpcPushTaskConfig.newBuilder()
                                .setAppName("airyclub")
                                .build())
                        .build())
                .build()
        );
        responseObserver.onCompleted();
    }

}
