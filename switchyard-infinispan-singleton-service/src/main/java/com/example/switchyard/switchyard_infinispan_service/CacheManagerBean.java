package com.example.switchyard.switchyard_infinispan_service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.switchyard.component.bean.Service;

@ApplicationScoped
@Service(CacheManager.class)
public class CacheManagerBean implements CacheManager {

	@Inject
	private CacheService cacheService;
	
	@Override
	public void add() {
		// Adds a key to the cache
		cacheService.add();
	}
	
	@Override
	public void print() {
		// Adds a key to the cache
		System.out.println("==== Node with lock: " + cacheService.get());
	}

	@Override
	public void release() {
		cacheService.release();
		
	}
	
}
