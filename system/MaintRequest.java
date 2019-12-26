package system;

public class MaintRequest {
	private Property property;
	private String issue;
	private boolean status;
	
	public MaintRequest() {
		
	}
	public MaintRequest(Property property, String issue) {
		this.property = property;
		this.issue = issue;
		this.status = false;
	}
	//Setter methods
	public void setProperty(Property property) {
		this.property = property;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	//Getter methods
	public Property getProperty() {
		return this.property;
	} 
	public String getIssue() {
		return this.issue;
	}
	public boolean getStatus() {
		return this.status;
	}

}
