package com.cobelu.dib.core;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

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
		 * Modulo math sucks. It's better to use a PRNG with a seed.
		 */
		Random random = new Random();
		random.setSeed(123);

		/*
		 * Populating sample data for plans
		 */
		List<Plan> bunchaPlans = new ArrayList<>();
		for (int i = 0; i <= 10; i++) {
			Plan plan = new Plan("Plan " + i, i * 10);
			bunchaPlans.add(plan);
		}

		/*
		 * Populating sample data for users
		 */
		List<User> bunchaUsers = new ArrayList<>();
		for (int i = 1; i <= 20; i++) {
			User user = new User("user" + i, "password", "ROLE_USER", new HashSet<Item>(), new HashSet<Item>(), new HashSet<Dib>());
			bunchaUsers.add(user);
		}

		/*
		 * Populating sample data for items
		 */
		List<Item> bunchaItems = new ArrayList<>();
		for (int i = 1; i <= 100; i++) {
			Item item = new Item("Item" + i, "This is Item " + i, null, new HashSet<User>(), new HashSet<Dib>());
			/*
			 * Assign a "random" user as owner
			 */
			User user = bunchaUsers.get(random.nextInt(20));
			item.setOwner(user);
			bunchaItems.add(item);
		}

		/*
		 * Creating some sharers
		 */
		for (int i = 0; i < 100; i++) {
			// Go through every Item
			Item item = bunchaItems.get(i);
			// Pick about 5 random Users to share
			for (int u = 0; u < 5; u++) {
				item.addSharer(bunchaUsers.get(random.nextInt(20)));
			}
		}

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
					Dib dib = new Dib();
					dib.setStartDate(date);
					dib.setStartTime(start);
					dib.setEndDate(date);
					dib.setEndTime(end);
					dib.setComment(comment);
					dib.setItem(bunchaItems.get(random.nextInt(bunchaItems.size() - 1)));
					dib.setUser(bunchaUsers.get(random.nextInt(bunchaUsers.size() - 1)));
					bunchaDibs.add(dib);
				}
			}
		}

		/*
		 * Finished! SAVE EVERYTHING NOW THAT ALL RELATIONSHIPS HAVE BEEN ESTABLISHED!
		 */
		plans.saveAll(bunchaPlans);
		users.saveAll(bunchaUsers);
		items.saveAll(bunchaItems);
		dibs.saveAll(bunchaDibs);

	}

}
