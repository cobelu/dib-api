package com.cobelu.dib.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cobelu.dib.model.User;

/*
 * No way to access User info from API
 */
@RepositoryRestResource(exported = false)
public interface UserRepository extends CrudRepository<User, Long> {

	User findByUsername(String username);
	
}
