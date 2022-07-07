package com.demo.caching.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.demo.caching.Application;
import com.demo.caching.dao.MessagingRepository;
import com.demo.caching.domain.SimpleMessage;

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
	
	private SimpleMessage getSimpleMessage(String category) {
		Cache cache = cacheManager.getCache("messages");
		ValueWrapper valueWrapper = cache.get(category);
		return (SimpleMessage) valueWrapper.get();	
	}
	
	@Test
	void testGetByCategpryHumorTest() {
		assertNotNull(messagingRepository.getByCategpry("humor"));
	}
	
	@Test
	void testGetSimpleMessageHumor() {
		SimpleMessage simpleMessage = getSimpleMessage("humor");
		assertEquals("Hey, its me!", simpleMessage.getText());
	}
	
	@Test
	void testGetByCategpry() {
		assertNotNull(messagingRepository.getByCategpry("busy"));
	}
	
	@Test
	void testGetSimpleMessageBusy() {
		SimpleMessage simpleMessage = getSimpleMessage("busy");
		assertEquals("Hey, its me!", simpleMessage.getText());
	}
	
	@Test
	void testGetByCategpryGreeting() {
		assertNotNull(messagingRepository.getByCategpry("greeting"));
	}
	
	@Test
	void testGetSimpleMessageGreeting() {
		SimpleMessage simpleMessage = getSimpleMessage("greeting");
		assertEquals("Hey, its me!", simpleMessage.getText());
	}
	
	@Test
	void testGetByCategpryPlans() {
		assertNotNull(messagingRepository.getByCategpry("plans"));
	}
	
	@Test
	void testGetSimpleMessagePlans() {
		SimpleMessage simpleMessage = getSimpleMessage("plans");
		assertEquals("Hey, its me!", simpleMessage.getText());
	}
	
	
}