package com.akg.threadscheck.service.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.stereotype.Service;

@Service
public class PlatformThreadService extends AbstractThreadService {

	@Override
	public ExecutorService getExecutorService() {
		return Executors.newFixedThreadPool(config.getThreadsExecutor().getPoolSize());
	}
}
