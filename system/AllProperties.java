package system;

import java.util.ArrayList;

public class AllProperties {
	private ArrayList<Property> allProperties = new ArrayList<Property>();
	
	public ArrayList<Property> getAllProperties(){
		return allProperties;
	}
	
	public void addProperty(Property property) {
		allProperties.add(property);
	}
	public void removeProperty(Property property) {
		allProperties.remove(property);
	}
	/*
	 * This method checks if a property exists in the list.
	 * If so, returns the index. If not, returns -1.
	 */
	public int getPropertyIndex (Property property) {
		int i;
		for (i = 0; i < allProperties.size(); i++) {
			if (allProperties.get(i).equals(property)) {
				return i;
			}
		}
		return -1;
	}
}
