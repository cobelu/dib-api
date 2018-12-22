package com.cobelu.dib.core;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.cobelu.dib.model.Item;
import com.cobelu.dib.model.User;
import com.cobelu.dib.repository.ItemRepository;
import com.cobelu.dib.repository.UserRepository;

/**
 * Loads sample data into database.
 * 
 * @author cobelu
 */

@Component
public class Loader implements ApplicationRunner {

	private final ItemRepository items;
	private final UserRepository users;

	@Autowired
	public Loader(ItemRepository items, UserRepository users) {
		super();
		this.items = items;
		this.users = users;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		/*
		 * Populating sample data for users
		 */
		List<User> bunchaUsers = new ArrayList<>();
		for (int i = 1; i <= 20; i++) {
			User user = new User("user" + i, "pswrd", "ROLE_USER");
			bunchaUsers.add(user);
		}
		users.saveAll(bunchaUsers);
		
		/*
		 * Populating sample data for items
		 */
		List<Item> bunchaItems = new ArrayList<>();
		for (int i = 1; i <= 100; i++) {
			Item item = new Item("Item" + i, "This is Item " + i);
			/*
			 * Assign a "random" user as owner
			 */
			item.setOwner(bunchaUsers.get((i % 5) + 1));
			bunchaItems.add(item);
		}
		items.saveAll(bunchaItems);
		
	}

}
