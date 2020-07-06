
package com.phoenix.message.model.dto.response.task;

import com.phoenix.message.model.json.TaskConfigExtra;
import com.phoenix.message.model.json.TaskConfigTargetTag;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class TaskConfigResp implements Serializable {

    private Integer id;
    private String appPlatform;
    private String messageTitle;
    private String messageBody;
    private String targetLink;
    private String imageLink;
    private Integer taskType;
    private Integer priority;
    private String remarks;
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
