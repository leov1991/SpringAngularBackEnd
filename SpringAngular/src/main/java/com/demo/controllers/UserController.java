package com.demo.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.User;
import com.demo.service.UserService;
import com.demo.util.RestResponse;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.jdbc.StringUtils;

@RestController
public class UserController {
	
	@Autowired
	protected UserService service;
	
	protected ObjectMapper mapper;
	
	@RequestMapping(value="/saveOrUpdate", method = RequestMethod.POST)
	public RestResponse saveOrUpdate(@RequestBody String userJson) throws JsonParseException, JsonMappingException, IOException {
		
		mapper = new ObjectMapper();
		User user = mapper.readValue(userJson, User.class);
		if(!validate(user)) {
			return new RestResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Los campos obligatorios no pueden estar en blanco");
			}
		
		this.service.save(user);
		
		
		return new RestResponse(HttpStatus.OK.value(), "Operación exitosa.");
	}
	
	@RequestMapping(value="/getUsers", method = RequestMethod.GET)
	public List<User> getUsers(){
		return service.findAll();
	}
	

	@RequestMapping(value="/deleteUser", method = RequestMethod.POST)
	public void deleteUser(@RequestBody String userJson) throws Exception{
		mapper = new ObjectMapper();
		User user = mapper.readValue(userJson, User.class);
		
		if(user.getId() == null) {
			throw new Exception("El id es nulo.");
		}
		
		service.delete(user.getId());
	}
	
	
	/*
	 * Considerar este método para agregar paginación
	@RequestMapping(value="/getUsers", method = RequestMethod.GET)
	public QueryResult getUsers() {
		
	}
	*/
	
	private boolean validate(User user) {
		
		boolean isValid = true;
		if(StringUtils.isEmptyOrWhitespaceOnly(user.getNombre())) {
			isValid = false;
		}
		
		if(StringUtils.isEmptyOrWhitespaceOnly(user.getApellido())) {
			isValid = false;
		}
		
		if(StringUtils.isEmptyOrWhitespaceOnly(user.getEmail())) {
			isValid = false;
		}
				
		
		return isValid;
	}

}
