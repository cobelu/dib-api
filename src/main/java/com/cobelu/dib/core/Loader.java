package com.cobelu.dib.core;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.cobelu.dib.model.Dib;
import com.cobelu.dib.model.Item;
import com.cobelu.dib.model.Plan;
import com.cobelu.dib.model.User;
import com.cobelu.dib.repository.DibRepository;
import com.cobelu.dib.repository.ItemRepository;
import com.cobelu.dib.repository.PlanRepository;
import com.cobelu.dib.repository.UserRepository;

/**
 * Loads sample data into database.
 * 
 * @author cobelu
 */

@Component
public class Loader implements ApplicationRunner {

	private final PlanRepository plans;
	private final ItemRepository items;
	private final UserRepository users;
	private final DibRepository dibs;

	@Autowired
	public Loader(PlanRepository plans, ItemRepository items, UserRepository users, DibRepository dibs) {
		super();
		this.plans = plans;
		this.items = items;
		this.users = users;
		this.dibs = dibs;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		/*
		 * Populating sample data for plans
		 */
		List<Plan> bunchaPlans = new ArrayList<>();
		for (int i = 0; i <= 10; i++) {
			Plan plan = new Plan("Plan " + i, i * 10);
			bunchaPlans.add(plan);
		}
		plans.saveAll(bunchaPlans);

		/*
		 * Populating sample data for users
		 */
		List<User> bunchaUsers = new ArrayList<>();
		for (int i = 1; i <= 20; i++) {
			User user = new User("user" + i, "pswrd", "ROLE_USER", new HashSet<Item>(), new HashSet<Item>());
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

		/*
		 * Populating sample data for dibs
		 */
		List<Dib> bunchaDibs = new ArrayList<>();
		int year = 2019;
		for (int month = 1; month <= 12; month++) {
			for (int day = 1; day <= 29; day++) {
				Date date = Date.valueOf(year + "-" + month + "-" + day);
				for (int hour = 9; hour <= 16; hour++) {
					Time start = Time.valueOf(hour + ":00:00");
					Time end = Time.valueOf((hour + 1) + ":00:00");
					String comment = date.toString() + "/" + start.toString();
					Dib dib = new Dib(date, start, date, end, comment);
					bunchaDibs.add(dib);
				}
			}
		}
		dibs.saveAll(bunchaDibs);

	}

}
