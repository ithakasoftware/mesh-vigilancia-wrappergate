package com.ithaka.ufabc.openwebcam.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ithaka.ufabc.openwebcam.db.entity.User;

public interface IUserDAO extends JpaRepository<User, Integer> {
	
	User findByLogin(String login);

}
