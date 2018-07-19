package com.in28minutes.rest.webservices.restfulwebservices;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.rest.webservices.restfulwebservices.helloworld.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
