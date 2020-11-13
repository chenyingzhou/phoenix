package com.phoenix.message.common.dto.taskconfig;

import com.phoenix.message.common.dto.JsonColumn;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TaskConfigContentConfigDto implements JsonColumn {
    private String type;
}
