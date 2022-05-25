package com.akg.threadscheck.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "commons")
@Data
public class Config {
	
	private ThreadsExecutor threadsExecutor;
	
	public enum ThreadType {

		PLATFORM("platform"),
	    VIRTUAL("virtual"); 

		private final String mode;
	    private ThreadType(String mode) {
	        this.mode = mode;
	    }

	    public String getValue() {
			return mode;
		}
	}
}
