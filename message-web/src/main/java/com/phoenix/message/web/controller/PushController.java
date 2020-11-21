package com.phoenix.message.web.controller;

import com.phoenix.message.proto.RpcFindTaskConfigListWithPaginationReq;
import com.phoenix.message.proto.RpcFindTaskConfigListWithPaginationResp;
import com.phoenix.message.proto.TaskServiceGrpc;
import com.phoenix.message.web.annotation.RequestGetBody;
import com.phoenix.message.web.mapstruct.TaskConfigMapStruct;
import com.phoenix.message.web.model.BaseResponse;
import com.phoenix.message.web.model.provider.TaskConfig;
import com.phoenix.message.web.model.request.TaskConfigListReq;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class PushController extends BaseController {

    @GrpcClient("message-grpc")
    private TaskServiceGrpc.TaskServiceBlockingStub stub;

    @GetMapping("/config")
    public BaseResponse<BaseResponse.Pagination<TaskConfig>> taskConfigList(@RequestGetBody TaskConfigListReq taskConfigListReq) {
        RpcFindTaskConfigListWithPaginationReq rpcReq = TaskConfigMapStruct.INSTANCE.toRpc(taskConfigListReq);
        RpcFindTaskConfigListWithPaginationResp rpcResp = stub.rpcFindTaskConfigListWithPagination(rpcReq);
        return TaskConfigMapStruct.INSTANCE.fromRpc(rpcResp);
    }

}
