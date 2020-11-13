package com.phoenix.message.common.dto.taskconfig;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.phoenix.message.common.dto.JsonColumn;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class TaskConfigUserConfigDto implements JsonColumn {
    private List<String> gender;
    @JsonProperty("region_code")
    private List<String> regionCode;
}
