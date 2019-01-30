package com.cobelu.dib.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.cobelu.dib.model.Plan;

/**
 * Automagically builds basic API functionality for Plan objects.
 * 
 * @author cobelu
 */
public interface PlanRepository extends PagingAndSortingRepository<Plan, Long> {

}
