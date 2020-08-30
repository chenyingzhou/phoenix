package com.phoenix.message.common.entity;

import com.phoenix.message.common.entity.json.PushTaskConfigExtra;
import com.phoenix.message.common.entity.json.PushTaskConfigTags;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.Data;

@Data
@Table(name = "push_task_config")
public class PushTaskConfig implements Serializable {
    /**
     * 自增id
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * vova/airyclub
     */
    @Column(name = "app_name")
    private String appName;

    /**
     * 标签来源
     */
    @Column(name = "tag_source")
    private String tagSource;

    /**
     * 推送消息标题CODE
     */
    @Column(name = "title")
    private String title;

    /**
     * 推送消息体CODE
     */
    @Column(name = "body")
    private String body;

    /**
     * 跳转链接
     */
    @Column(name = "link")
    private String link;

    /**
     * 图片链接
     */
    @Column(name = "image_url")
    private String imageUrl;

    /**
     * 任务类型：1-营销型 2-功能型
     */
    @Column(name = "type")
    private Integer type;

    /**
     * 优先级
     */
    @Column(name = "priority")
    private Integer priority;

    /**
     * 备注
     */
    @Column(name = "notes")
    private String notes;

    /**
     * 执行周期(秒)
     */
    @Column(name = "period")
    private Integer period;

    /**
     * 首次执行时间(设置)
     */
    @Column(name = "first_time")
    private Date firstTime;

    /**
     * 上次执行时间(执行时更新)
     */
    @Column(name = "last_time")
    private Date lastTime;

    /**
     * 有效期起始
     */
    @Column(name = "start_time")
    private Date startTime;

    /**
     * 有效期结束
     */
    @Column(name = "end_time")
    private Date endTime;

    /**
     * 状态
     */
    @Column(name = "status")
    private Integer status;

    /**
     * 是否删除
     */
    @Column(name = "deleted")
    private Integer deleted;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 标签
     */
    @Column(name = "tags")
    private PushTaskConfigTags tags;

    /**
     * 其他属性
     */
    @Column(name = "extra")
    private PushTaskConfigExtra extra;

    private static final long serialVersionUID = 1L;

    public static final String ID = "id";

    public static final String DB_ID = "id";

    public static final String APP_NAME = "appName";

    public static final String DB_APP_NAME = "app_name";

    public static final String TAG_SOURCE = "tagSource";

    public static final String DB_TAG_SOURCE = "tag_source";

    public static final String TITLE = "title";

    public static final String DB_TITLE = "title";

    public static final String BODY = "body";

    public static final String DB_BODY = "body";

    public static final String LINK = "link";

    public static final String DB_LINK = "link";

    public static final String IMAGE_URL = "imageUrl";

    public static final String DB_IMAGE_URL = "image_url";

    public static final String TYPE = "type";

    public static final String DB_TYPE = "type";

    public static final String PRIORITY = "priority";

    public static final String DB_PRIORITY = "priority";

    public static final String NOTES = "notes";

    public static final String DB_NOTES = "notes";

    public static final String PERIOD = "period";

    public static final String DB_PERIOD = "period";

    public static final String FIRST_TIME = "firstTime";

    public static final String DB_FIRST_TIME = "first_time";

    public static final String LAST_TIME = "lastTime";

    public static final String DB_LAST_TIME = "last_time";

    public static final String START_TIME = "startTime";

    public static final String DB_START_TIME = "start_time";

    public static final String END_TIME = "endTime";

    public static final String DB_END_TIME = "end_time";

    public static final String STATUS = "status";

    public static final String DB_STATUS = "status";

    public static final String DELETED = "deleted";

    public static final String DB_DELETED = "deleted";

    public static final String CREATE_TIME = "createTime";

    public static final String DB_CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "updateTime";

    public static final String DB_UPDATE_TIME = "update_time";

    public static final String TAGS = "tags";

    public static final String DB_TAGS = "tags";

    public static final String EXTRA = "extra";

    public static final String DB_EXTRA = "extra";

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", appName=").append(appName);
        sb.append(", tagSource=").append(tagSource);
        sb.append(", title=").append(title);
        sb.append(", body=").append(body);
        sb.append(", link=").append(link);
        sb.append(", imageUrl=").append(imageUrl);
        sb.append(", type=").append(type);
        sb.append(", priority=").append(priority);
        sb.append(", notes=").append(notes);
        sb.append(", period=").append(period);
        sb.append(", firstTime=").append(firstTime);
        sb.append(", lastTime=").append(lastTime);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", status=").append(status);
        sb.append(", deleted=").append(deleted);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", tags=").append(tags);
        sb.append(", extra=").append(extra);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}