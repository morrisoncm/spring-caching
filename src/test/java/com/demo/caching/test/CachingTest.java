package com.demo.caching.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
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

	@ParameterizedTest
	@ValueSource(strings = { "messages", "humor", "busy", "greeting" })
	void test_text_equals(String category) {
		assertNotNull(messagingRepository.getByCategpry(category));
		assertEquals("Hey, its me!", getSimpleMessage(category));
	}

	private String getSimpleMessage(String category) {
		Cache cache = cacheManager.getCache("messages");
		ValueWrapper valueWrapper = cache.get(category);
		return ((SimpleMessage) valueWrapper.get()).getText();
	}

}