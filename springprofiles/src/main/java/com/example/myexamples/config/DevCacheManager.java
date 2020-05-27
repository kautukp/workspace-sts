/**
 * 
 */
package com.example.myexamples.config;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author USER
 *
 */
@Component
@Profile("dev")
public class DevCacheManager implements CacheManager {

	@Override
	public void initiateCache() {
		System.out.println(this.getClass().getSimpleName() + " - Dev cache initiated.");
	}

}
