package pagetracker.repository.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import pagetracker.WebSocketConfig;
import pagetracker.models.Hit;
import pagetracker.models.Contact;
import pagetracker.repository.PageTrackerRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PageTrackerRepositoryImpl implements PageTrackerRepository {

	@Autowired
	private SimpMessagingTemplate template;

	ObjectMapper json = new ObjectMapper();

    Map<String, List<Hit>> hitsByUser = new HashMap<>();
	Map<String, Contact> users = new HashMap<>();

    @Override
    public void addHit(String userId, String url, String timestamp) throws Exception {

		List<Hit> userHits = hitsByUser.get(userId);

    	if (userHits == null) {
			userHits = new ArrayList<>();
			hitsByUser.put(userId, userHits);
		}

		Hit hit = Hit.create(userId, url, timestamp);

		userHits.add(hit);
		template.convertAndSend(WebSocketConfig.PREFIX, json.writeValueAsString(hit));

	}

	@Override
	public int hitCounter() {
    	int total = 0;

		for(Map.Entry<String, List<Hit>> entry : hitsByUser.entrySet()) {
			total += entry.getValue().size();
		}

		return total;
	}

	@Override
	public void addContact(String userId, String name, String email) throws Exception {

    	Contact contact = new Contact();
		contact.setUserId(userId);
		contact.setName(name);
		contact.setEmail(email);

    	users.put(userId, contact);

		template.convertAndSend(WebSocketConfig.PREFIX, json.writeValueAsString(contact));

	}

	@Override
	public int contactCounter() {
		return users.size();
	}

}
