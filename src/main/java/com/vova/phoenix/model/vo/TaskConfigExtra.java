
package com.vova.phoenix.model.vo;

import lombok.Data;

@Data
public class TaskConfigExtra {

    private String iosMin;
    private String iosMax;
    private String androidMin;
    private String androidMax;
    private Integer couponConfigId;
    private String tagSource;

}