package com.akg.threadscheck.service.thread;

import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;

import com.akg.threadscheck.config.Config;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractThreadService {

	@Autowired
	Config config;

	public abstract ExecutorService getExecutorService();

	/**
	 * It's a main method that defines each thread execution logic.
	 */
	public void exec() {
		try (var executor = getExecutorService()) {
		    work( executor );
		}
	}

	/**
	 * The method defines the actual work that each thread should execute.
	 * @param executor - ExecutorService.
	 */
	private void work(ExecutorService executor) {
	
		IntStream.range(0, config.getThreadsExecutor().getMaxNumber()).forEach(i -> {
	        executor.submit(() -> {
	        	log.debug("thread number: {}", i);
	            Thread.sleep(Duration.ofMillis(1000));
	            return i;
	        });
	    });
	}
}

