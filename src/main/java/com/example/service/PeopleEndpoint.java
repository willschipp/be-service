package com.example.service;

import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.client.PeopleClient;

@RestController
public class PeopleEndpoint {
	
	@Autowired
	private PeopleClient peopleClient;

	@GetMapping("/people")
	public Collection<Map<String,Object>> get(HttpServletResponse httpServletResponse) {
		Collection<Map<String,Object>> people = peopleClient.getAllPeople().getContent();
		if (people.isEmpty()) {
			httpServletResponse.setStatus(HttpStatus.NOT_FOUND.value());
			return null;
		} else {
			return people;
		}//end if
	}
	
}
