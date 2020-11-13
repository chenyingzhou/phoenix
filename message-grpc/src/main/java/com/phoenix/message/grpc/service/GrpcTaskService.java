package com.phoenix.message.grpc.service;

import com.phoenix.message.common.dto.Pagination;
import com.phoenix.message.common.dto.TaskConfigDto;
import com.phoenix.message.common.dto.TaskConfigFilterDto;
import com.phoenix.message.common.facade.TaskFacade;
import com.phoenix.message.grpc.mapstruct.TaskConfigMapStruct;
import com.phoenix.message.proto.RpcFindTaskConfigListWithPaginationReq;
import com.phoenix.message.proto.RpcFindTaskConfigListWithPaginationResp;
import com.phoenix.message.proto.RpcTaskConfigListPaginationResult;
import com.phoenix.message.proto.TaskServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class GrpcTaskService extends TaskServiceGrpc.TaskServiceImplBase {

    @Autowired
    TaskFacade taskFacade;

    @Override
    public void rpcFindTaskConfigListWithPagination(RpcFindTaskConfigListWithPaginationReq request, StreamObserver<RpcFindTaskConfigListWithPaginationResp> responseObserver) {
        TaskConfigFilterDto taskConfigFilterDto = TaskConfigMapStruct.INSTANCE.rpcFindTaskConfigListWithPaginationReq2Dto(request);
        Pagination<TaskConfigDto> paginationResult = taskFacade.findTaskConfigWithPagination(taskConfigFilterDto);
        RpcTaskConfigListPaginationResult rpcPaginationResult = TaskConfigMapStruct.INSTANCE.dto2RpcTaskConfigListPaginationResult(paginationResult);
        RpcFindTaskConfigListWithPaginationResp.Builder builder = RpcFindTaskConfigListWithPaginationResp.newBuilder();
        builder.setCode(0)
                .setMsg("")
                .setData(rpcPaginationResult);
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

}
