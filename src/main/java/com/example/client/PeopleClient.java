package com.example.client;

import java.util.Collection;
import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;



@FeignClient(name="db-via-rest")
public interface PeopleClient {

	@GetMapping("/persons")
	CollectionModel<Map<String,Object>> getAllPeople();
	
}
