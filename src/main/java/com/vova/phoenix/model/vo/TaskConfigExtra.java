
package com.vova.phoenix.model.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class TaskConfigExtra implements Serializable {

    private String iosMin;
    private String iosMax;
    private String androidMin;
    private String androidMax;
    private Integer couponConfigId;
    private String tagSource;

}
