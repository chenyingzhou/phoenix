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
 * 任务进程
 * </p>
 *
 * @author nome
 * @since 2020-12-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TaskProcess对象", description="任务进程")
public class TaskProcess extends Model<TaskProcess> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "任务ID")
    private Integer taskId;

    @ApiModelProperty(value = "起始偏移")
    private Integer startOffset;

    @ApiModelProperty(value = "终止偏移")
    private Integer endOffset;

    @ApiModelProperty(value = "上次执行偏移")
    private Integer lastOffset;

    @ApiModelProperty(value = "错误次数")
    private Integer errorCount;

    @ApiModelProperty(value = "状态：0-已就绪 1-执行中 2-已完成 3-已终止")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "最近更新时间")
    private LocalDateTime updateTime;


    public static final String ID = "id";

    public static final String TASK_ID = "task_id";

    public static final String START_OFFSET = "start_offset";

    public static final String END_OFFSET = "end_offset";

    public static final String LAST_OFFSET = "last_offset";

    public static final String ERROR_COUNT = "error_count";

    public static final String STATUS = "status";

    public static final String CREATE_TIME = "create_time";

    public static final String UPDATE_TIME = "update_time";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
