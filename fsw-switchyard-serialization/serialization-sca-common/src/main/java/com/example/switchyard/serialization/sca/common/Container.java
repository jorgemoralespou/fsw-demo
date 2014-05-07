package com.example.switchyard.serialization.sca.common;

import java.io.Serializable;
import java.util.List;

public class Container<T, K> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String operation;
	private K target;
	private List<T> resources;

	private Container(ContainerBuilder<T, K> builder) {
		this.id = builder.id;
		this.operation = builder.operation;
		this.target = builder.target;
		this.resources = builder.resources;
	}

	
	
	public String getId() {
		return id;
	}



	public String getOperation() {
		return operation;
	}



	public K getTarget() {
		return target;
	}



	public List<T> getResources() {
		return resources;
	}



	public boolean equals(Container<?, ?> item) {
		return this.id == item.id;
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public boolean equals(Object item) {
		return equals((Container<?, ?>) item);
	}
	
	@Override
	public String toString() {
		return "Container{operation=" + operation + ", target=" + target
				+ ", Id=" + id +  '}';
	}
	public static class ContainerBuilder<T, K> {
		private String id;
		private String operation;
		private K target;
		private List<T> resources;

		public ContainerBuilder(String id) {
			this.id = id;
		}

		public ContainerBuilder<T, K> setOperation(String operation) {
			this.operation = operation;
			return this;
		}

		public ContainerBuilder<T, K> setTarget(K target) {
			this.target = target;
			return this;
		}

		public ContainerBuilder<T, K> setResources(List<T> resources) {
			this.resources = resources;
			return this;
		}

		public Container<T, K> build() {
			return new Container<T, K>(this);
		}
	}

}
