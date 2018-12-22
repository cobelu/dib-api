package com.cobelu.dib.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.cobelu.dib.model.Plan;

public interface PlanRepository extends PagingAndSortingRepository<Plan, Long> {

}
