package com.demo.caching.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.demo.caching.Application;
import com.demo.caching.dao.MessagingRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class)
class CachingTest {

	@Autowired
	private CacheManager cacheManager;
	@Autowired
	private MessagingRepository messagingRepository;
	
	@BeforeEach
    void setUp() {
		messagingRepository.getByCategpry("humor");
		messagingRepository.getByCategpry("busy");
		messagingRepository.getByCategpry("greeting");
		messagingRepository.getByCategpry("plans");
    }
	
	@Test 
	void testCacheManager() {
		Cache cache = cacheManager.getCache("messages");
		assertNotNull(cache.get("humor"));
		assertNotNull(cache.get("busy"));
		assertNotNull(cache.get("greeting"));
		assertNotNull(cache.get("plans"));
	}
	
	@Test
	void testGetByCategpryHumorTest() {
		assertNotNull(messagingRepository.getByCategpry("humor"));
	}
	
	@Test
	void testGetByCategpry() {
		assertNotNull(messagingRepository.getByCategpry("busy"));
	}
	
	@Test
	void testGetByCategpryGreeting() {
		assertNotNull(messagingRepository.getByCategpry("greeting"));
	}
	
	@Test
	void testGetByCategpryPlans() {
		assertNotNull(messagingRepository.getByCategpry("plans"));
	}
	
	
}