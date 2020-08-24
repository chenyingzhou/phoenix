package com.phoenix.message.common.service;

import com.phoenix.message.common.entity.PushTaskConfig;

import java.util.List;

public interface PushService {

    List<PushTaskConfig> findAllTaskConfig();

}
