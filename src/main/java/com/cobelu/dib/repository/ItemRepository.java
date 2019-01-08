package com.cobelu.dib.repository;

/*
 * There are 2 different imports of page. BE SURE TO USE THE DATA DOMAIN PAGE!
 */
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import com.cobelu.dib.model.Item;

/**
 * Automagically builds basic API functionality for Item objects.
 * 
 * @author cobelu
 */
public interface ItemRepository extends PagingAndSortingRepository<Item, Long> {

	/*
	 * Creation
	 */

	@RestResource(rel = "title-contains", path = "containsTitle")
	Page<Item> findByTitleContaining(@Param("title") String title, Pageable page);

	@RestResource(rel = "with-owner", path = "withOwner")
	Page<Item> findByOwnerId(@Param("ownerId") Long id, Pageable page);

	/*
	 * Deletion
	 */

//	/*
//	 * TODO: An item can ONLY be deleted by its owner
//	 */
//	@PreAuthorize("@itemRepository.findOne(#id)?.owner?.username == authentication.name")
//	void delete(@Param("id") Long id);
//
//	/*
//	 * TODO: Add owner ability to cancel with "or"
//	 */
//	@Override
//	@PreAuthorize("#item.owner?.username == authentication.name")
//	void delete(@Param("item") Item entity);

}
