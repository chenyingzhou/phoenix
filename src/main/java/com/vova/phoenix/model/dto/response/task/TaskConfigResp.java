
package com.vova.phoenix.model.dto.response.task;

import com.vova.phoenix.model.json.TaskConfigExtra;
import com.vova.phoenix.model.json.TaskConfigTargetTag;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class TaskConfigResp implements Serializable {

    private Integer id;
    private java.lang.String appPlatform;
    private java.lang.String messageTitle;
    private java.lang.String messageBody;
    private java.lang.String targetLink;
    private java.lang.String imageLink;
    private Integer taskType;
    private Integer priority;
    private java.lang.String remarks;
    private Integer periods;
    private Date expectedTime;
    private Date lastTime;
    private Date startTime;
    private Date endTime;
    private Integer status;
    private TaskConfigTargetTag targetTag;
    private List<String> countries;
    private TaskConfigExtra extra;

}
