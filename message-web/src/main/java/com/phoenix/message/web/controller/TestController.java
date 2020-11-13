package com.phoenix.message.web.controller;

import com.phoenix.message.common.dto.TaskConfigFilterDto;
import com.phoenix.message.proto.TaskServiceGrpc;
import com.phoenix.message.web.mapstruct.TaskConfigMapStruct;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GrpcClient("message-grpc")
    private TaskServiceGrpc.TaskServiceBlockingStub stub;

    @GetMapping("/test")
    public String test(TaskConfigFilterDto taskConfigFilterDto) {
        var req = TaskConfigMapStruct.INSTANCE.dto2RpcFindTaskConfigListWithPaginationReq(taskConfigFilterDto);
        var resp = stub.rpcFindTaskConfigListWithPagination(req);
        return resp.toString();
    }
}
