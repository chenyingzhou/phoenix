package com.phoenix.message.grpc.service;

import com.phoenix.message.grpc.FindPushTaskConfigList;
import com.phoenix.message.grpc.PushServiceGrpc;
import com.phoenix.message.grpc.PushTaskConfig;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;


@GrpcService
public class GrpcPushService extends PushServiceGrpc.PushServiceImplBase {
    @Override
    public void rpcFindPushTaskConfigList(FindPushTaskConfigList.RpcFindPushTaskConfigListReq request, StreamObserver<FindPushTaskConfigList.RpcFindPushTaskConfigListResp> responseObserver) {
        responseObserver.onNext(FindPushTaskConfigList.RpcFindPushTaskConfigListResp
                .newBuilder()
                .setCode(0)
                .setMsg("hello")
                .setData(FindPushTaskConfigList.RpcPaginationResult
                        .newBuilder()
                        .setTotalCount(100)
                        .setList(0, PushTaskConfig.RpcPushTaskConfig
                                .newBuilder()
                                .setAppName("hello")
                                .build()
                        ).build()
                ).build()
        );
        responseObserver.onCompleted();
    }

}
