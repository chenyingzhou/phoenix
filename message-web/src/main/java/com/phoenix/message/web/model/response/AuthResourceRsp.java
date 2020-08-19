package com.phoenix.message.web.model.response;

import lombok.Data;

import java.util.List;

@Data
public class AuthResourceRsp {
	private List<AuthResourceRspItem> appName;
	private List<AuthResourceRspItem> messageType;
}
