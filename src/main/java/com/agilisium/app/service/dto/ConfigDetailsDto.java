package com.agilisium.app.service.dto;

import java.util.List;

public class ConfigDetailsDto {

	
	
	List<ConfigsDto> configDetails;

	public ConfigDetailsDto(List<ConfigsDto> configDetails) {
		super();
		this.configDetails = configDetails;
	}

	public List<ConfigsDto> getConfigDetails() {
		return configDetails;
	}

	public void setConfigDetails(List<ConfigsDto> configDetails) {
		this.configDetails = configDetails;
	}
	
	
}
