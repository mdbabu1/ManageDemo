package system;

import java.util.ArrayList;

public class AllMessages {
private ArrayList<Message> allMessages = new ArrayList<Message>();
	
	public ArrayList<Message> getAllProperties(){
		return allMessages;
	}
	
	public void addMessage(Message message) {
		allMessages.add(message);
	}
	public void removeMessage(Message message) {
		allMessages.remove(message);
	}
	/*
	 * This method checks if a property exists in the list.
	 * If so, returns the index. If not, returns -1.
	 */
	public int getmessageIndex (Message message) {
		int i;
		for (i = 0; i < allMessages.size(); i++) {
			if (allMessages.get(i).equals(message)) {
				return i;
			}
		}
		return -1;
	}
}
