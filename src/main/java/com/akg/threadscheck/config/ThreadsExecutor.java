package com.akg.threadscheck.config;

import com.akg.threadscheck.config.Config.ThreadType;

import lombok.Data;

@Data
public class ThreadsExecutor {
	
	private int maxNumber;
	private int poolSize;
	private ThreadType type;
}
