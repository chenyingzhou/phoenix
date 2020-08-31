package com.phoenix.message.common.service;

import com.phoenix.message.common.Pagination;
import com.phoenix.message.common.entity.PushTaskConfig;
import com.phoenix.message.common.filter.PushTaskConfigFilter;

import java.util.List;

public interface PushService {

    List<PushTaskConfig> findTaskConfigList(PushTaskConfigFilter pushTaskConfigFilter, Pagination pagination);

    Boolean savePushTaskConfig(PushTaskConfig pushTaskConfig);

    public Boolean updatePushTaskConfig(PushTaskConfig pushTaskConfig);

}
