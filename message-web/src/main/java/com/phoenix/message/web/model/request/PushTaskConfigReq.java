package com.phoenix.message.web.model.request;

import com.phoenix.message.common.entity.json.PushTaskConfigExtra;
import com.phoenix.message.common.entity.json.PushTaskConfigTags;
import lombok.Data;

import java.util.Date;

@Data
public class PushTaskConfigReq {

    private Integer id;

    private String appName;

    private String tagSource;

    private String title;

    private String body;

    private String link;

    private String imageUrl;

    /**
     * 任务类型：1-营销型 2-功能型
     */
    private Integer type;

    /**
     * 优先级
     */
    private Integer priority;

    /**
     * 备注
     */
    private String notes;

    /**
     * 执行周期(秒)
     */
    private Integer period;

    /**
     * 首次执行时间(设置)
     */
    private Date firstTime;

    private Date startTime;

    private Date endTime;

    private PushTaskConfigTags tags;

    private PushTaskConfigExtra extra;

}
