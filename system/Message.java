package system;
/*
 * This class represents a message. 
 * A Message object is created on request of user.
 * 
 * 
 */
public class Message {
	private String message;
	private String senderID;
	private String recieverID; 
	
	public Message() {
	  	
    }
	public Message(String message, String recieverID) {
	  	this.message = message;
	  	//this.senderID = senderID;
	  	this.recieverID = recieverID;
    }
	//Getter methods
	public String getMessage() {
		return this.message;
	}
	public String getSender() {
		return this.senderID;
	}
	public String getReciever() {
		return this.recieverID;
	}
	//Setter methods
	public void setReviever(String rec) {
		this.recieverID = rec;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setSenderID(String senderID) {
		int ID = Integer.parseInt(senderID);
		this.senderID = senderID;
	}
}
