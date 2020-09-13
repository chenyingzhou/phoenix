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
                        .setList(0, RpcPushTaskConfig.newBuilder()
                                .setAppName("vova")
                                .build())
                        .setList(1, RpcPushTaskConfig.newBuilder()
                                .setAppName("airyclub")
                                .build())
                        .build())
                .build()
        );
    }

}
