package com.phoenix.message.common.dto;

import com.phoenix.message.common.entity.AuthRole;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class AuthRoleTree extends AuthRole {
    private List<AuthRoleTree> children = new ArrayList<>();
}
