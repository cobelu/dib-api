package com.cobelu.dib.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cobelu.dib.model.User;

/**
 * Automagically builds basic API functionality for Item objects. Note that
 * there should be no way to access User info from API.
 * 
 * @author cobelu
 */
@RepositoryRestResource(exported = false)
public interface UserRepository extends CrudRepository<User, Long> {

	User findByUsername(String username);

}
