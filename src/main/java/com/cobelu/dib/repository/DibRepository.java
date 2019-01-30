package com.cobelu.dib.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.cobelu.dib.model.Dib;

/**
 * Automagically builds basic API functionality for Dib objects.
 * 
 * @author cobelu
 */
public interface DibRepository extends PagingAndSortingRepository<Dib, Long> {

}
