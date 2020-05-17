package com.agilisium.app.service.dto;

public class ConfigsDto {

	String configInfo;

	public String getConfigInfo() {
		return configInfo;
	}

	public void setConfigInfo(String configInfo) {
		this.configInfo = configInfo;
	}

	public ConfigsDto(String configInfo) {
		super();
		this.configInfo = configInfo;
	}

}
