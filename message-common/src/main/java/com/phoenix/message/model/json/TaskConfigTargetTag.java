
package com.phoenix.message.model.json;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class TaskConfigTargetTag implements Serializable {

    private Integer filter;
    private Integer baseTag;
    private List<Integer> genderTags;
    private List<Integer> levelTags;

}
