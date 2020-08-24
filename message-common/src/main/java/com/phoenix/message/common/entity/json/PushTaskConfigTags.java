package com.phoenix.message.common.entity.json;

import lombok.Data;

import java.util.List;

@Data
public class PushTaskConfigTags{
	private List<String> country;
	private List<Integer> gender;
	private List<Integer> level;
	private List<Integer> login;
}