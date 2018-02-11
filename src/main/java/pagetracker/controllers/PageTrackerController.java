package pagetracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pagetracker.repository.PageTrackerRepository;

import javax.servlet.http.HttpServletResponse;

@RestController
public class PageTrackerController {

    @Autowired
	PageTrackerRepository repo;

    @RequestMapping(value = "/pagetracker/hit")
    public void hit(String userId, String url, String timestamp, HttpServletResponse response) throws Exception {
    	repo.addHit(userId, url, timestamp);
    	response.setContentType("text/plain");
    }

}
