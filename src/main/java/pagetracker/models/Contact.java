package pagetracker.models;

import lombok.Data;

@Data
public class Contact extends Event {

	String userId;
    String name;
    String email;

    public Contact() {
    	this.setType(Type.CONTACT);
	}

	public static Contact create(String userId, String name, String email) {
    	Contact contact = new Contact();
    	contact.setUserId(userId);
    	contact.setName(name);
    	contact.setEmail(email);

		return contact;
	}

}
