
package com.vova.phoenix.model.po.json;

import java.util.List;
import lombok.Data;

@Data
public class TaskConfigTargetTag {

    private java.lang.Integer filter;
    private java.lang.Integer baseTag;
    private List<java.lang.Integer> genderTags;
    private List<java.lang.Integer> levelTags;

}
