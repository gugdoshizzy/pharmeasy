package com.pharmeasy.model.impl;

import com.pharmeasy.utils.UUIDUtils;

public class Person {

	protected String id;
	protected String name;
	protected long contactNo;
	protected String address;
	
	protected Person(PersonBuilder personBuilder) {
		super();
		this.id = personBuilder.id;
		this.name = personBuilder.name;
		this.contactNo = personBuilder.contactNo;
		this.address = personBuilder.address;
	}
	
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public long getContactNo() {
		return contactNo;
	}
	
	public String getAddress() {
		return this.address;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", contactNo=" + contactNo + ", address=" + address + "]";
	}
	
	public static class PersonBuilder<SELF extends PersonBuilder<SELF>> {

		private String id;
		private String name;
		private long contactNo;
		private String address;
		
		public PersonBuilder() {
			this.id = UUIDUtils.getUUID();
		}
		
		public PersonBuilder(Person person) {
			this.id = person.id;
			this.name = person.name;
			this.contactNo = person.contactNo;
			this.address = person.address;
		}
				
		public SELF addId(String id) {
			this.id = id;
    		return self();
    	}

        public SELF addName(String name) {
        	this.name = name;
            return self();
        }

        public SELF addContactNo(long contactNo) {
        	this.contactNo = contactNo;
            return self();
        }

        public SELF addAddress(String address) {
        	this.address = address;
            return self();
        }

        @SuppressWarnings("unchecked")
		protected SELF self() {
        	return (SELF) this;
        }
        
        public Person build() {
            Person p = new Person(this);
         	return p;
        }
	}
}