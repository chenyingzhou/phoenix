package com.phoenix.message.web.model.response;

import lombok.Data;

import java.util.List;

@Data
public class AuthRoleTree {

    private Integer id;

    private String name;

    private String code;

    private List<AuthRoleTree> children;
}
