package com.woolbro.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.woolbro.model.AjaxResponseBody;
import com.woolbro.model.SearchCriteria;
import com.woolbro.model.User;
import com.woolbro.services.UserService;

@RestController
public class SearchController {

	UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/api/search")
	public ResponseEntity<?> getSearchResultViaAjax(@Valid @RequestBody SearchCriteria search,Errors errors){
		AjaxResponseBody result = new AjaxResponseBody();
		
		if(errors.hasErrors()) {
			result.setMsg(errors.getAllErrors().stream().map(x->x.getDefaultMessage()).collect(Collectors.joining(",")));
			return ResponseEntity.badRequest().body(result);
		}
		List<User> users = userService.findByUserNameOrEmail(search.getUsername());
		if(users.isEmpty()) {
			result.setMsg("사용자가 존재하지 않습니다!");
		}else {
			result.setMsg("성공입니다!");
		}
		result.setResult(users);
		
		return ResponseEntity.ok(result);
	}

}
