package com.phoenix.message.web.controller;

import com.phoenix.message.common.constant.SqlConstant;
import com.phoenix.message.common.entity.PushTaskConfig;
import com.phoenix.message.common.util.JacksonUtil;
import com.phoenix.message.proto.RpcFindTaskConfigListReq;
import com.phoenix.message.proto.RpcFindTaskConfigListResp;
import com.phoenix.message.proto.TaskServiceGrpc;
import io.grpc.Channel;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {
    @GrpcClient("message-grpc")
    private TaskServiceGrpc.TaskServiceBlockingStub stub;

    @GetMapping("/test")
    public String test() {
        RpcFindTaskConfigListReq.Builder reqBuilder = RpcFindTaskConfigListReq.newBuilder();
        RpcFindTaskConfigListReq req = reqBuilder.setAppName("phoenix").build();
        RpcFindTaskConfigListResp resp = stub.rpcFindTaskConfigList(req);
        return resp.toString();
    }
}
