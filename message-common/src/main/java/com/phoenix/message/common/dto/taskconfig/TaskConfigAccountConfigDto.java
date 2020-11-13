package com.phoenix.message.common.dto.taskconfig;

import com.phoenix.message.common.dto.JsonColumn;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TaskConfigAccountConfigDto implements JsonColumn {
    private String sender;
}
