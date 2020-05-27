/**
 * 
 */
package com.example.myexamples.config;

import org.springframework.context.annotation.Configuration;

/**
 * @author USER
 *
 */
@Configuration
public class AppConfig {

	private CacheManager cacheManager;

	public AppConfig(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

	/**
	 * @return the cacheManager
	 */
	public CacheManager getCacheManager() {
		return cacheManager;
	}
}
