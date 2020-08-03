package com.phoenix.message.common.model.dto.response.auth;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class MenuResp implements Serializable {
    /**
     * ID
     */
    private Integer id;

    /**
     * 父节点ID
     */
    private Integer parentId;

    /**
     * 节点名称
     */
    private String name;

    /**
     * 节点code
     */
    private String code;

    /**
     * 子节点
     */
    private List<MenuResp> children;
}
