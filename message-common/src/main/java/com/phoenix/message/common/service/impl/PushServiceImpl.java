package com.phoenix.message.common.service.impl;

import com.phoenix.message.common.dao.PushDao;
import com.phoenix.message.common.entity.PushTaskConfig;
import com.phoenix.message.common.service.PushService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PushServiceImpl implements PushService {

    @Resource
    private PushDao pushDao;

    @Override
    public List<PushTaskConfig> findAllTaskConfig() {
        return pushDao.select(new PushTaskConfig());
    }
}
