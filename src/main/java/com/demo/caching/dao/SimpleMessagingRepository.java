package com.demo.caching.dao;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.demo.caching.domain.SimpleMessage;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SimpleMessagingRepository implements MessagingRepository {

	@Override
	@Cacheable("messages")
	public SimpleMessage getByCategpry(String category) {
		simulateSlowService();
		return new SimpleMessage(category, "Hey, its me!");
	}

	private void simulateSlowService() {
		try {
			long time = 3000L;
			Thread.sleep(time);
		} catch (InterruptedException cause) {
			log.error("simulateSlowService() -> cause {}", cause);
			throw new IllegalStateException(cause);
		}
	}

}
