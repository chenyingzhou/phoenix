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

/**
 * <p>
 * 推送任务配置表
 * </p>
 *
 * @author nome
 * @since 2020-11-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="TaskConfig对象", description="推送任务配置表")
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
    private Integer usage;

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
    private Integer deleted;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
