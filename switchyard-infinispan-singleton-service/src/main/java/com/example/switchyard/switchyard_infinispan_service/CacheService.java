package com.example.switchyard.switchyard_infinispan_service;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;

import org.infinispan.Cache;
import org.infinispan.manager.CacheContainer;
import org.infinispan.notifications.Listener;
import org.infinispan.notifications.cachelistener.annotation.CacheEntryCreated;
import org.infinispan.notifications.cachelistener.annotation.CacheEntryRemoved;
import org.infinispan.notifications.cachelistener.event.CacheEntryCreatedEvent;
import org.infinispan.notifications.cachelistener.event.CacheEntryRemovedEvent;
import org.infinispan.notifications.cachemanagerlistener.annotation.ViewChanged;
import org.infinispan.notifications.cachemanagerlistener.event.ViewChangedEvent;
import org.infinispan.remoting.transport.Address;

@ApplicationScoped
@Listener
public class CacheService {
	
	private static final String KEY = "LOCKER";

	@Resource(lookup = "java:jboss/infinispan/container/switchyard")
	private CacheContainer container;

	private Cache<String, String> cache;
	private String nodeName;

	@PostConstruct
	public void start() {
		this.cache = this.container.getCache();
		this.nodeName = cache.getCacheManager().getAddress().toString();
		System.out.println("==== Cache started with nodeName: " + nodeName);
		cache.addListener(this);
		System.out.println("==== Added this as CacheListener");
	}

	// Methods to do the work
	public void release() {
		cache.remove(KEY);
	}

	public void add() {
		cache.putIfAbsent(KEY, nodeName, 10L, TimeUnit.SECONDS);
	}

	public String get() {
		return cache.get(KEY);
	}
	
	
	// Listener methods
	@CacheEntryCreated
	public void added(CacheEntryCreatedEvent event) {
		System.out.println("New entry " + event.getKey()
				+ " created in the cache. " + event.getType());
	}

	@CacheEntryRemoved
	public void removed(CacheEntryRemovedEvent event) {
		System.out.println("New entry " + event.getKey()
				+ " removed from the cache" + event.getType());
	}

	@ViewChanged
	public void viewChanged(ViewChangedEvent event) {
		List<Address> oldView = event.getOldMembers();
		List<Address> newView = event.getNewMembers();
		if (oldView.size()<newView.size()){
			System.out.println("==== Node added");
		}else
			System.out.println("==== Node removed");
	}

}
