package com.phoenix.message.web.controller;

import com.phoenix.message.common.service.TaskConfigService;
import com.phoenix.message.proto.RpcFindTaskConfigListReq;
import com.phoenix.message.proto.RpcFindTaskConfigListResp;
import com.phoenix.message.proto.TaskServiceGrpc;
import com.phoenix.message.web.mapper.TaskConfigMapper;
import com.phoenix.message.web.model.FindTaskConfigResp;
import com.phoenix.message.web.model.PaginationResult;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {
    @GrpcClient("message-grpc")
    private TaskServiceGrpc.TaskServiceBlockingStub stub;

    @GetMapping("/test")
    public String test() {
        RpcFindTaskConfigListReq.Builder reqBuilder = RpcFindTaskConfigListReq.newBuilder();
        RpcFindTaskConfigListReq req = reqBuilder.setAppName("phoenix").build();
        RpcFindTaskConfigListResp resp = stub.rpcFindTaskConfigList(req);
        FindTaskConfigResp findTaskConfigResp = TaskConfigMapper.INSTANCE.toPojo(resp);
        RpcFindTaskConfigListResp resp1 = TaskConfigMapper.INSTANCE.toProtobuf(findTaskConfigResp);
        return resp.toString();
    }
}
