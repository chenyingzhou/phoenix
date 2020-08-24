package com.phoenix.message.common.entity.json;

import lombok.Data;

@Data
public class PushTaskConfigExtra{
	private String androidMax;
	private String androidMin;
	private String iosMax;
	private String iosMin;
	private int couponConfigId;
}
