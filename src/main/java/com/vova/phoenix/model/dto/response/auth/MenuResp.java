package com.vova.phoenix.model.dto.response.auth;

import lombok.Data;

import java.util.List;

@Data
public class MenuResp {
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
