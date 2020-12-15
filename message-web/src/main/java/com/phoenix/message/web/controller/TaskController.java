package com.phoenix.message.web.controller;

import com.phoenix.message.proto.*;
import com.phoenix.message.web.annotation.RequestGetBody;
import com.phoenix.message.web.mapstruct.TaskConfigMapStruct;
import com.phoenix.message.web.model.BaseResponse;
import com.phoenix.message.web.model.provider.TaskConfig;
import com.phoenix.message.web.model.request.TaskConfigListReq;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
@Api(tags = {"任务模块"})
public class TaskController extends BaseController {

    @GrpcClient("message-grpc-service")
    private TaskServiceGrpc.TaskServiceBlockingStub stub;

    @GetMapping("/config")
    @ApiOperation(value = "任务配置列表")
    public BaseResponse<BaseResponse.Pagination<TaskConfig>> taskConfigList(@RequestGetBody TaskConfigListReq taskConfigListReq) {
        RpcFindTaskConfigListWithPaginationReq rpcReq = TaskConfigMapStruct.INSTANCE.toRpc(taskConfigListReq);
        RpcFindTaskConfigListWithPaginationResp rpcResp = stub.rpcFindTaskConfigListWithPagination(rpcReq);
        return TaskConfigMapStruct.INSTANCE.fromRpc(rpcResp);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "任务配置详情")
    public BaseResponse<TaskConfig> taskConfigDetail(@PathVariable Integer id) {
        RpcFindTaskConfigByIdReq rpcReq = RpcFindTaskConfigByIdReq.newBuilder().setId(id).build();
        RpcFindTaskConfigByIdResp rpcResp = stub.rpcFindTaskConfigById(rpcReq);
        return TaskConfigMapStruct.INSTANCE.fromRpc(rpcResp);
    }

}
