package com.phoenix.message.web.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserPetDto {
    private String name;
    private Date birthday;
}
