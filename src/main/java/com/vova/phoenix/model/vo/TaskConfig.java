
package com.vova.phoenix.model.vo;

import lombok.Data;

import java.util.List;

@Data
public class TaskConfig {

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
    private java.lang.String expectedTime;
    private java.lang.String lastTime;
    private java.lang.String startTime;
    private java.lang.String endTime;
    private Integer status;
    private TaskConfigTargetTag targetTag;
    private List<java.lang.String> countries;
    private TaskConfigExtra extra;

}
