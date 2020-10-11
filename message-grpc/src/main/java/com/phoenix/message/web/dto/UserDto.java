package com.phoenix.message.web.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private Integer id;
    private String name;
    private UserExtraDto extra;
    private List<UserPetDto> petList;
}
