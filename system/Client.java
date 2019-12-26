package system;

/*
 * This class represents a client. 
 * A Client object holds values retrieved from our database.
 * 
 */
public class Client {
	private int clientId;
    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String email;
    private String userType;
	
    // Default constructor
	public Client() {
    	
    }
	
	// Constructor (all fields supplied)
	public Client(int clientId, String name, String address, String city, String state, String zip,
			      String phone, String email, String userType) {
		this.clientId = clientId;
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
		this.email = email;
		this.userType = userType;
	}
	
	// Getter methods
	public int getClientId() {
		return clientId;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getState() {
		return state;
	}
	
	public String getZip() {
		return zip;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String getEmail() {
		return email;
	}
	public String getUserType() {
		return userType;
	}

	
	// Setter methods
	public void setClientId(int id) {
		this.clientId = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
}


