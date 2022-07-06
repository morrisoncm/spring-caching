package com.demo.caching.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.caching.dao.MessagingRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@AllArgsConstructor
public class AppRunner implements CommandLineRunner {

	private final MessagingRepository messagingRepository;
	
	@Override
	public void run(String... args) throws Exception {
		log.info(".... Getting messages");
	    log.info("messaging category -> humor" + messagingRepository.getByCategpry("humor"));
	    log.info("messaging category -> busy" + messagingRepository.getByCategpry("busy"));
	    log.info("messaging category -> greeting" + messagingRepository.getByCategpry("greeting"));
	    log.info("messaging category -> plans" + messagingRepository.getByCategpry("plans"));
	    
	    log.info(".... Calling cached messages");
	    log.info("messaging cached category -> humor" + messagingRepository.getByCategpry("humor"));
	    log.info("messaging cached category -> busy" + messagingRepository.getByCategpry("busy"));
	    log.info("messaging cached category -> greeting" + messagingRepository.getByCategpry("greeting"));
	    log.info("messaging cached category -> plans" + messagingRepository.getByCategpry("plans"));
	    
	    log.info(".... Did you see how much faster calling cached messages");
	    log.info("messaging cached category -> humor" + messagingRepository.getByCategpry("humor"));
	    log.info("messaging cached category -> busy" + messagingRepository.getByCategpry("busy"));
	    log.info("messaging cached category -> greeting" + messagingRepository.getByCategpry("greeting"));
	    log.info("messaging cached category -> plans" + messagingRepository.getByCategpry("plans"));
	}

}
