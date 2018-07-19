package com.in28minutes.rest.webservices.restfulwebservices;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.rest.webservices.restfulwebservices.helloworld.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{

}
