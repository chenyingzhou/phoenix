package com.vova.phoenix.model.vo;

import lombok.Data;

import java.util.List;

@Data
public class AuthMenu {
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
     * 状态
     */
    private Byte status;

    /**
     * 子节点
     */
    private List<AuthMenu> children;
}
