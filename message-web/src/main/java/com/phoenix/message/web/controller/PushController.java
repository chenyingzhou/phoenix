package com.phoenix.message.web.controller;

import com.phoenix.message.common.Pagination;
import com.phoenix.message.common.constant.SqlConstant;
import com.phoenix.message.common.entity.PushTaskConfig;
import com.phoenix.message.common.filter.PushTaskConfigFilter;
import com.phoenix.message.common.util.JacksonUtil;
import com.phoenix.message.proto.PushServiceGrpc;
import com.phoenix.message.proto.RpcFindPushTaskConfigListReq;
import com.phoenix.message.proto.RpcFindPushTaskConfigListResp;
import com.phoenix.message.web.model.BaseListResponse;
import com.phoenix.message.web.model.BaseResponse;
import com.phoenix.message.web.model.request.PushTaskConfigReq;
import com.phoenix.message.web.model.response.PushTaskConfigRsp;
import io.grpc.Channel;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class PushController extends BaseController {

    @GrpcClient("admin-service")
    private Channel serverChannel;

    @GetMapping("/push/task-config")
    public BaseListResponse<PushTaskConfigRsp> taskConfigList(PushTaskConfigFilter pushTaskConfigFilter, Pagination pagination) {

        PushServiceGrpc.PushServiceBlockingStub stub = PushServiceGrpc.newBlockingStub(serverChannel);
        RpcFindPushTaskConfigListResp resp = stub.rpcFindPushTaskConfigList(RpcFindPushTaskConfigListReq.newBuilder().setAppName("vova").build());

        pagination.setOrderBy(PushTaskConfig.ID);
        pagination.setOrderType(SqlConstant.ORDER_DESC);
        List<PushTaskConfig> pushTaskConfigList = pushService.findTaskConfigList(pushTaskConfigFilter, pagination);
        List<PushTaskConfigRsp> pushTaskConfigRspList = JacksonUtil.transList(pushTaskConfigList, PushTaskConfigRsp.class);
        return sendList(pushTaskConfigRspList, pagination);
    }

    @PostMapping("/push/task-config")
    public BaseResponse<?> saveTaskConfig(@RequestBody PushTaskConfigReq pushTaskConfigReq) {
        pushService.savePushTaskConfig(JacksonUtil.transObject(pushTaskConfigReq, PushTaskConfig.class));
        return sendOk();
    }

}
