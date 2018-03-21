package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.UserRepository;
import com.demo.model.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired //Dependency Injection!
	protected UserRepository repo;
	

	@Override
	public User save(User user) {
		return repo.save(user);
		
	}


	@Override
	public List<User> findAll() {
		return repo.findAll();
	}


	@Override
	public void delete(Long id) {
		repo.delete(id);
		
	}
}
