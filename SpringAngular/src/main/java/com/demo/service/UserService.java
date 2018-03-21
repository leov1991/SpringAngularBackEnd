package com.demo.service;

import java.util.List;

import com.demo.model.User;

public interface UserService {

	User save(User user);

	List<User> findAll();

	void delete(Long id);

}
