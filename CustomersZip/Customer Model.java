package com.lti.Model;

public class Customers {

	    private int customer_id;
	    private String first_name;
	    private String last_name;
	    private String address;
	    private String city;
	    private String state;
	    private String zipcode;
	    private String email_address;
	    public Customers(){
	    	
	    }
		public Customers(int customer_id, String first_name, String last_name, String address, String city, String state,
				String zipcode, String email_address) {
			super();
			this.customer_id = customer_id;
			this.first_name = first_name;
			this.last_name = last_name;
			this.address = address;
			this.city = city;
			this.state = state;
			this.zipcode = zipcode;
			this.email_address = email_address;
		}
		public int getCustomer_id() {
			return customer_id;
		}
		public void setCustomer_id(int customer_id) {
			this.customer_id = customer_id;
		}
		public String getFirst_name() {
			return first_name;
		}
		public void setFirst_name(String first_name) {
			this.first_name = first_name;
		}
		public String getLast_name() {
			return last_name;
		}
		public void setLast_name(String last_name) {
			this.last_name = last_name;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public String getZipcode() {
			return zipcode;
		}
		public void setZipcode(String zipcode) {
			this.zipcode = zipcode;
		}
		public String getEmail_address() {
			return email_address;
		}
		public void setEmail_address(String email_address) {
			this.email_address = email_address;
		}
		@Override
		public String toString() {
			return "Customers [customer_id=" + customer_id + ", first_name=" + first_name + ", last_name=" + last_name
					+ ", address=" + address + ", city=" + city + ", state=" + state + ", zipcode=" + zipcode
					+ ", email_address=" + email_address + "]";
		}
	    
	}



