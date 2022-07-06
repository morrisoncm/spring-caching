package com.demo.caching.dao;

import com.demo.caching.domain.SimpleMessage;

public interface MessagingRepository {
	
	SimpleMessage getByCategpry(String category);

}
