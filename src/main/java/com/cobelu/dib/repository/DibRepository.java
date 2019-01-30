package com.cobelu.dib.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import com.cobelu.dib.model.Dib;

/**
 * Automagically builds basic API functionality for Dib objects.
 * 
 * @author cobelu
 */
public interface DibRepository extends PagingAndSortingRepository<Dib, Long> {

	@RestResource(rel = "with-user-username", path = "withUserUsername")
	Page<Dib> findByUser_Username(@Param("userUsername") String username, Pageable page);
	
}
