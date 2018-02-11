package pagetracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pagetracker.repository.PageTrackerRepository;

import java.util.Map;

@Controller
public class SiteController {

	@Autowired
	PageTrackerRepository repo;

	@RequestMapping("/")
	public String home(Map<String, Object> model) {
		return "home";
	}

	@RequestMapping("/about")
	public String about(Map<String, Object> model) {
		return "about";
	}

	@RequestMapping("/pricing")
	public String pricing(Map<String, Object> model) {
		return "pricing";
	}

	@RequestMapping("/contact")
	public String contact(Map<String, Object> model) {
		return "contact";
	}

	@RequestMapping("/thankyou")
	public String thankyou(String userId, String name, String email, Map<String, Object> model) throws Exception {

		repo.addContact(userId, name, email);
		model.put("name", name);

		return "thankyou";
	}

	@RequestMapping("/feed")
	public String feed(Map<String, Object> model) {
		return "feed";
	}

}
