package com.cobelu.dib.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.cobelu.dib.model.Item;
import com.cobelu.dib.model.User;
import com.cobelu.dib.repository.UserRepository;

@Component
@RepositoryEventHandler
public class ItemEventHandler {

	@Autowired
	private final UserRepository users;

	public ItemEventHandler(UserRepository users) {
		this.users = users;
	}

	@HandleBeforeCreate
	public void addOwnerBasedOnLoggedInUser(Item item) {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = users.findByUsername(username);
		item.setOwner(user);
	}

}
