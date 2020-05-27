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
@Profile("prod")
public class ProdCacheManager implements CacheManager {

	@Override
	public void initiateCache() {
		System.out.println(this.getClass().getSimpleName() + " - Prod cache initiated.");
	}
}
