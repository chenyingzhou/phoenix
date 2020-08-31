package com.phoenix.message.common.service.impl;

import com.phoenix.message.common.Pagination;
import com.phoenix.message.common.constant.SqlConstant;
import com.phoenix.message.common.dao.PushDao;
import com.phoenix.message.common.entity.PushTaskConfig;
import com.phoenix.message.common.filter.PushTaskConfigFilter;
import com.phoenix.message.common.filter.base.ColumnFilter;
import com.phoenix.message.common.service.PushService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PushServiceImpl implements PushService {

    @Resource
    private PushDao pushDao;

    @Override
    public List<PushTaskConfig> findTaskConfigList(PushTaskConfigFilter pushTaskConfigFilter, Pagination pagination) {
        Integer id = pushTaskConfigFilter.getId();
        String appName = pushTaskConfigFilter.getAppName();
        Integer type = pushTaskConfigFilter.getType();
        Integer status = pushTaskConfigFilter.getStatus();
        Date createTimeB = pushTaskConfigFilter.getCreateTimeB();
        Date createTimeE = pushTaskConfigFilter.getCreateTimeE();

        List<ColumnFilter> filterList = new ArrayList<>();
        if (id != null) {
            filterList.add(new ColumnFilter(PushTaskConfig.ID, SqlConstant.EQ, id));
        }
        if (!StringUtils.isEmpty(appName)) {
            filterList.add(new ColumnFilter(PushTaskConfig.APP_NAME, SqlConstant.EQ, appName));
        }
        if (type != null) {
            filterList.add(new ColumnFilter(PushTaskConfig.TYPE, SqlConstant.EQ, type));
        }
        if (status != null) {
            filterList.add(new ColumnFilter(PushTaskConfig.STATUS, SqlConstant.EQ, status));
        }
        if (createTimeB != null) {
            filterList.add(new ColumnFilter(PushTaskConfig.CREATE_TIME, SqlConstant.GE, createTimeB));
        }
        if (createTimeE != null) {
            filterList.add(new ColumnFilter(PushTaskConfig.CREATE_TIME, SqlConstant.LE, createTimeE));
        }
        return pushDao.selectByFilter(PushTaskConfig.class, filterList, pagination);
    }

    @Override
    public Boolean savePushTaskConfig(PushTaskConfig pushTaskConfig) {
        return pushDao.insertSelective(pushTaskConfig);
    }

    @Override
    public Boolean updatePushTaskConfig(PushTaskConfig pushTaskConfig) {
        return pushDao.updateSelective(pushTaskConfig);
    }
}
