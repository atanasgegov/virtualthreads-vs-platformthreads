package com.akg.threadscheck.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import com.akg.threadscheck.config.Config;
import com.akg.threadscheck.service.thread.PlatformThreadService;
import com.akg.threadscheck.service.thread.VirtualThreadService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Executor {

	@Autowired
	private Config config;
	
	@Autowired
	private VirtualThreadService virtualThreadService;
	
	@Autowired
	private PlatformThreadService platformThreadService;

	@EventListener(ApplicationReadyEvent.class)
	public void exec() {
		log.info("Started.");
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		if( config.getThreadsExecutor().getType().equals(Config.ThreadType.VIRTUAL) ) {
			virtualThreadService.exec();
		} else if( config.getThreadsExecutor().getType().equals(Config.ThreadType.PLATFORM) ) {
			platformThreadService.exec();
		} else {
			log.warn("Please, setup properly the configuration file - application.yml.");
		}
		stopWatch.stop();
		log.info("{}, time execution: {}", config.getThreadsExecutor(), stopWatch.getTotalTimeMillis());
		log.info("Done.");
	}
}
