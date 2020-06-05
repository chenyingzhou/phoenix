
package com.vova.phoenix.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class TaskConfigTargetTag implements Serializable {

    private java.lang.Integer filter;
    private java.lang.Integer baseTag;
    private List<java.lang.Integer> genderTags;
    private List<java.lang.Integer> levelTags;

}
