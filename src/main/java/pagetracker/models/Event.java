package pagetracker.models;

import lombok.Data;

@Data
public abstract class Event {

	public enum Type {
		HIT, CONTACT
	}

	public Type type;

}
