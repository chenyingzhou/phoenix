package com.phoenix.message.web.service;

import com.phoenix.message.proto.*;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GrpcTaskService extends TaskServiceGrpc.TaskServiceImplBase {
    @Override
    public void rpcFindTaskConfigList(RpcFindTaskConfigListReq request, StreamObserver<RpcFindTaskConfigListResp> responseObserver) {
        RpcTaskConfig.Builder taskConfigBuilder = RpcTaskConfig.newBuilder();
        RpcPaginationResult.Builder paginationResultBuild = RpcPaginationResult.newBuilder();
        RpcFindTaskConfigListResp.Builder rpcFindTaskConfigListRespBuild = RpcFindTaskConfigListResp.newBuilder();

        taskConfigBuilder.setAppName("phoenix");
        paginationResultBuild.setTotalCount(102)
                .addList(taskConfigBuilder)
                .addList(taskConfigBuilder)
                .build();
        rpcFindTaskConfigListRespBuild.setCode(0)
                .setMsg("hello")
                .setData(paginationResultBuild);

        responseObserver.onNext(rpcFindTaskConfigListRespBuild.build());
        responseObserver.onCompleted();
    }

}
