package com.phoenix.message.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 任务配置
 * </p>
 *
 * @author nome
 * @since 2020-12-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TaskConfig对象", description="任务配置")
public class TaskConfig extends Model<TaskConfig> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "任务名")
    private String name;

    @ApiModelProperty(value = "类型：1-推送 2-邮件")
    private Integer type;

    @ApiModelProperty(value = "用途：0-未知 1-营销 2-功能")
    private Integer classification;

    @ApiModelProperty(value = "应用名")
    private String appName;

    @ApiModelProperty(value = "用户来源配置")
    private String userConfig;

    @ApiModelProperty(value = "内容配置")
    private String contentConfig;

    @ApiModelProperty(value = "账号配置")
    private String accountConfig;

    @ApiModelProperty(value = "版本配置")
    private String versionConfig;

    @ApiModelProperty(value = "优先级")
    private Integer priority;

    @ApiModelProperty(value = "备注")
    private String notes;

    @ApiModelProperty(value = "重复周期(天) 0不重复 -30每月同一天 -365每年同一天")
    private Integer period;

    @ApiModelProperty(value = "是否按时区发送")
    private Boolean useTimezone;

    @ApiModelProperty(value = "执行时间(设置)")
    private LocalDateTime sendTime;

    @ApiModelProperty(value = "上次执行时间(执行时更新)")
    private LocalDateTime recordTime;

    @ApiModelProperty(value = "有效期起始")
    private LocalDateTime startTime;

    @ApiModelProperty(value = "有效期结束")
    private LocalDateTime endTime;

    @ApiModelProperty(value = "状态：0-已就绪 1-执行中 2-已完成 3-已终止")
    private Integer status;

    @ApiModelProperty(value = "是否删除")
    private Boolean deleted;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;


    public static final String ID = "id";

    public static final String NAME = "name";

    public static final String TYPE = "type";

    public static final String CLASSIFICATION = "classification";

    public static final String APP_NAME = "app_name";

    public static final String USER_CONFIG = "user_config";

    public static final String CONTENT_CONFIG = "content_config";

    public static final String ACCOUNT_CONFIG = "account_config";

    public static final String VERSION_CONFIG = "version_config";

    public static final String PRIORITY = "priority";

    public static final String NOTES = "notes";

    public static final String PERIOD = "period";

    public static final String USE_TIMEZONE = "use_timezone";

    public static final String SEND_TIME = "send_time";

    public static final String RECORD_TIME = "record_time";

    public static final String START_TIME = "start_time";

    public static final String END_TIME = "end_time";

    public static final String STATUS = "status";

    public static final String DELETED = "deleted";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
