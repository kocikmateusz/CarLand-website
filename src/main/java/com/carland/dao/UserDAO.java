package com.carland.dao;

import com.carland.entity.User;

public interface UserDAO {

	public void save(User theUser);
	public User findByUsername(String username);
}
