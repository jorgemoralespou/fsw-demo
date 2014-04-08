package com.example.switchyard.serialization.sca.common;

public class User {
	private String name;
	private String lastName;
	private String id;
	
	private User(UserBuilder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.lastName = builder.lastName;
	}
	
	public static class UserBuilder{
		private String name;
		private String lastName;
		private String id;

		public UserBuilder(String id) {
			this.id = id;
		}

		public UserBuilder setName(String name) {
			this.name = name;
			return this;
		}

		public UserBuilder setLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}
		
		public User build(){
			return new User(this);
		}
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public String getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", lastName=" + lastName + ", id=" + id
				+ "]";
	}
	
	public static UserBuilder createUserBuilder(String id){
		return new UserBuilder(id);
	}
}
