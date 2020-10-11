package com.phoenix.message.web.model;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private Integer id;
    private String name;
    private UserExtra extra;
    private List<UserPet> petList;
}
