package com.phoenix.message.web.controller;

import com.phoenix.message.common.Pagination;
import com.phoenix.message.common.entity.PushTaskConfig;
import com.phoenix.message.common.filter.PushTaskConfigFilter;
import com.phoenix.message.common.util.JacksonUtil;
import com.phoenix.message.web.model.BaseListResponse;
import com.phoenix.message.web.model.response.PushTaskConfigRsp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PushController extends BaseController {

    @GetMapping("/push/task-config")
    public BaseListResponse<PushTaskConfigRsp> taskConfig(PushTaskConfigFilter pushTaskConfigFilter, Pagination pagination) {
        List<PushTaskConfig> pushTaskConfigList = pushService.findTaskConfigList(pushTaskConfigFilter, pagination);
        List<PushTaskConfigRsp> pushTaskConfigRspList = JacksonUtil.transList(pushTaskConfigList, PushTaskConfigRsp.class);
        return sendList(pushTaskConfigRspList, pagination);
    }

}
