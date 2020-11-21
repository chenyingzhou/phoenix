package com.phoenix.message.web.model.provider;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.phoenix.message.common.dto.JsonColumn;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class TaskConfigVersionConfig implements JsonColumn {
    @JsonProperty("ios_min")
    private String iosMin;
    @JsonProperty("ios_max")
    private String iosMax;
    @JsonProperty("android_min")
    private String androidMin;
    @JsonProperty("android_max")
    private String androidMax;
}
