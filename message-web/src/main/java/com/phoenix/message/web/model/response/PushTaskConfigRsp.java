package com.phoenix.message.web.model.response;

import com.phoenix.message.common.entity.json.PushTaskConfigExtra;
import com.phoenix.message.common.entity.json.PushTaskConfigTags;
import lombok.Data;

import java.util.Date;

@Data
public class PushTaskConfigRsp {

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

    /**
     * 上次执行时间(执行时更新)
     */
    private Date lastTime;

    private Date startTime;

    private Date endTime;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    private PushTaskConfigTags tags;

    private PushTaskConfigExtra extra;

}
