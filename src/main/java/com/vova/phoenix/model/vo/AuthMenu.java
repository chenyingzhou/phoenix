package com.vova.phoenix.model.vo;

import lombok.Data;

import java.util.*;

@Data
public class AuthMenu {
    /**
     * ID
     */
    private Integer id = 0;

    /**
     * 父节点ID
     */
    private Integer parentId = 0;

    /**
     * 节点名称
     */
    private String name = "";

    /**
     * 节点code
     */
    private String code = "";

    /**
     * 状态
     */
    private Integer status = 1;

    /**
     * 子节点
     */
    private List<AuthMenu> children = new ArrayList<>();
}
