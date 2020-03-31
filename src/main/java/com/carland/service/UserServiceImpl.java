package com.carland.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carland.dao.UserDAO;
import com.carland.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public UserDAO userDAO;

	@Override
	@Transactional
	public void saveUser(User theUser) {
		userDAO.save(theUser);

	}

}
