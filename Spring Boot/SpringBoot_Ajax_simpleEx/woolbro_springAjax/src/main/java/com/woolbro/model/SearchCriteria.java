package com.woolbro.model;

import javax.validation.constraints.NotBlank;

public class SearchCriteria {
	
	@NotBlank(message = "이름은 빈공간으로 둘 수 없습니닷!")
	String username;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
}
