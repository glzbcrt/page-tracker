package pagetracker.models;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Page {

    String title;
    String description;

    static Map<String, Page> pages = new HashMap<>();

    static {

        pages.put("/", new Page("Main", "The landing page of our company."));
        pages.put("/about", new Page("About", "The page where we tell our history."));
        pages.put("/pricing", new Page("Pricing", "The page where we show how much our amazing services cost."));
        pages.put("/contact", new Page("Contact", "The page where our users can contact us."));
		pages.put("/thankyou", new Page("Thank You", "The page where we thanks for the contact."));
		pages.put("/feed", new Page("Event Feed", "The page where we can view the navigation feeds."));

    }

    public static Page getFromUrl(String url) {
        return pages.get(url);
    }

    public Page(String title, String description) {
        this.title = title;
        this.description = description;
    }

}
