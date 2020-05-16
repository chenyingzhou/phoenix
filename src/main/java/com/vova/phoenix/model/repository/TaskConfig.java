package com.vova.phoenix.model.repository;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "task_config")
public class TaskConfig implements Serializable {
    /**
     * 自增id
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * vova/airyclub
     */
    @Column(name = "app_platform")
    private String appPlatform;

    /**
     * 推送消息标题CODE
     */
    @Column(name = "message_title")
    private String messageTitle;

    /**
     * 推送消息体CODE
     */
    @Column(name = "message_body")
    private String messageBody;

    /**
     * 跳转链接
     */
    @Column(name = "target_link")
    private String targetLink;

    /**
     * 图片链接
     */
    @Column(name = "image_link")
    private String imageLink;

    /**
     * 任务类型：1-功能型 2-营销型
     */
    @Column(name = "task_type")
    private Byte taskType;

    /**
     * 优先级
     */
    private Integer priority;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 执行周期
     */
    private Byte periods;

    /**
     * 期望执行时间
     */
    @Column(name = "expected_time")
    private Date expectedTime;

    /**
     * 上次执行时间
     */
    @Column(name = "last_time")
    private Date lastTime;

    /**
     * 有效期
     */
    @Column(name = "start_time")
    private Date startTime;

    /**
     * 有效期
     */
    @Column(name = "end_time")
    private Date endTime;

    /**
     * 配置状态
     */
    private Byte status;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 最近更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 目标用户类型0-用户标签1-用户分层2-国家
     */
    @Column(name = "target_tag")
    private String targetTag;

    /**
     * 推送时区
     */
    private String countries;

    /**
     * 其他属性
     */
    private String extra;

    private static final long serialVersionUID = 1L;

    public static final String ID = "id";

    public static final String DB_ID = "id";

    public static final String APP_PLATFORM = "appPlatform";

    public static final String DB_APP_PLATFORM = "app_platform";

    public static final String MESSAGE_TITLE = "messageTitle";

    public static final String DB_MESSAGE_TITLE = "message_title";

    public static final String MESSAGE_BODY = "messageBody";

    public static final String DB_MESSAGE_BODY = "message_body";

    public static final String TARGET_LINK = "targetLink";

    public static final String DB_TARGET_LINK = "target_link";

    public static final String IMAGE_LINK = "imageLink";

    public static final String DB_IMAGE_LINK = "image_link";

    public static final String TASK_TYPE = "taskType";

    public static final String DB_TASK_TYPE = "task_type";

    public static final String PRIORITY = "priority";

    public static final String DB_PRIORITY = "priority";

    public static final String REMARKS = "remarks";

    public static final String DB_REMARKS = "remarks";

    public static final String PERIODS = "periods";

    public static final String DB_PERIODS = "periods";

    public static final String EXPECTED_TIME = "expectedTime";

    public static final String DB_EXPECTED_TIME = "expected_time";

    public static final String LAST_TIME = "lastTime";

    public static final String DB_LAST_TIME = "last_time";

    public static final String START_TIME = "startTime";

    public static final String DB_START_TIME = "start_time";

    public static final String END_TIME = "endTime";

    public static final String DB_END_TIME = "end_time";

    public static final String STATUS = "status";

    public static final String DB_STATUS = "status";

    public static final String CREATE_TIME = "createTime";

    public static final String DB_CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "updateTime";

    public static final String DB_UPDATE_TIME = "update_time";

    public static final String TARGET_TAG = "targetTag";

    public static final String DB_TARGET_TAG = "target_tag";

    public static final String COUNTRIES = "countries";

    public static final String DB_COUNTRIES = "countries";

    public static final String EXTRA = "extra";

    public static final String DB_EXTRA = "extra";

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", appPlatform=").append(appPlatform);
        sb.append(", messageTitle=").append(messageTitle);
        sb.append(", messageBody=").append(messageBody);
        sb.append(", targetLink=").append(targetLink);
        sb.append(", imageLink=").append(imageLink);
        sb.append(", taskType=").append(taskType);
        sb.append(", priority=").append(priority);
        sb.append(", remarks=").append(remarks);
        sb.append(", periods=").append(periods);
        sb.append(", expectedTime=").append(expectedTime);
        sb.append(", lastTime=").append(lastTime);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", targetTag=").append(targetTag);
        sb.append(", countries=").append(countries);
        sb.append(", extra=").append(extra);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    public static TaskConfig defaultInstance() {
        TaskConfig instance = new TaskConfig();
        instance.appPlatform = new String("vova");
        instance.messageTitle = new String("");
        instance.messageBody = new String("");
        instance.targetLink = new String("");
        instance.imageLink = new String("");
        instance.taskType = new Byte("0");
        instance.priority = new Integer("0");
        instance.remarks = new String("");
        instance.periods = new Byte("0");
        instance.status = new Byte("0");
        return instance;
    }
}