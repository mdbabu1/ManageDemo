package system;

public class Property {
	private String address;
	private String buildDate;
	
	public Property() {
		
	}
	public Property(String address, String buildDate) {
		this.address = address;
		this.buildDate = buildDate;
	}
	//Setter methods
	public void setAddress(String address) {
		this.address = address;
	}
	public void setBuildDate(String buildDate) {
		this.buildDate = buildDate;
	}
	//Getter methods
	public String getAddress() {
		return this.address;
	}
	public String getDate() {
		return this.buildDate;
	}
}
