package com.phoenix.message.grpc.service;

import com.phoenix.message.common.dto.Pagination;
import com.phoenix.message.common.dto.TaskConfigDto;
import com.phoenix.message.common.dto.TaskConfigFilterDto;
import com.phoenix.message.common.facade.TaskFacade;
import com.phoenix.message.grpc.mapstruct.TaskConfigMapStruct;
import com.phoenix.message.proto.*;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class GrpcTaskService extends TaskServiceGrpc.TaskServiceImplBase {

    private final TaskFacade taskFacade;

    @Autowired
    GrpcTaskService(TaskFacade taskFacade) {
        this.taskFacade = taskFacade;
    }

    @Override
    public void rpcFindTaskConfigListWithPagination(RpcFindTaskConfigListWithPaginationReq request, StreamObserver<RpcFindTaskConfigListWithPaginationResp> responseObserver) {
        TaskConfigFilterDto taskConfigFilterDto = TaskConfigMapStruct.INSTANCE.toDto(request);
        Pagination<TaskConfigDto> taskConfigDtoPagination = taskFacade.findTaskConfigWithPagination(taskConfigFilterDto);
        RpcTaskConfigListPaginationResult rpcPaginationResult = TaskConfigMapStruct.INSTANCE.fromDto(taskConfigDtoPagination);
        RpcFindTaskConfigListWithPaginationResp.Builder builder = RpcFindTaskConfigListWithPaginationResp.newBuilder();
        builder.setCode(0)
                .setMsg("")
                .setData(rpcPaginationResult);
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void rpcFindTaskConfigById(RpcFindTaskConfigByIdReq request, StreamObserver<RpcFindTaskConfigByIdResp> responseObserver) {
        int id = request.getId();
        TaskConfigDto taskConfigDto = taskFacade.findTaskConfigById(id);
        RpcTaskConfig rpcTaskConfig = TaskConfigMapStruct.INSTANCE.fromDto(taskConfigDto);
        RpcFindTaskConfigByIdResp.Builder builder = RpcFindTaskConfigByIdResp.newBuilder();
        builder.setCode(0).setMsg("");
        if (rpcTaskConfig != null) {
            builder.setData(rpcTaskConfig);
        }
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

    @Override
    public void rpcSaveTaskConfig(RpcTaskConfig request, StreamObserver<RpcSaveTaskConfigResp> responseObserver) {
        TaskConfigDto taskConfigDto = TaskConfigMapStruct.INSTANCE.toDto(request);
        Integer id = taskFacade.saveTaskConfig(taskConfigDto);
        RpcSaveTaskConfigResp.Builder builder = RpcSaveTaskConfigResp.newBuilder();
        builder.setCode(0).setMsg("");
        if (id != null) {
            builder.setData(RpcTaskConfigIdModel.newBuilder().setId(id).build());
        }
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

}
