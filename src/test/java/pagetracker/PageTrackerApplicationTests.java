package pagetracker;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pagetracker.models.Page;
import pagetracker.repository.PageTrackerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PageTrackerApplicationTests {

	@Autowired
	PageTrackerRepository repo;

	@Test
	public void testHit() throws Exception {
		repo.addHit("7a4b060e-8955-8e3a-1a69-6ba6b690c4cb", "/feed", "1518339086");
		Assert.assertEquals(1, repo.hitCounter());
	}

	@Test
	public void testContact() throws Exception {
		repo.addContact("7a4b060e-8955-8e3a-1a69-6ba6b690c4cb", "John Doe", "john@doe.com");
		Assert.assertEquals(1, repo.contactCounter());
	}

	@Test
	public void testGetPageFromUrl() {
		Page page = Page.getFromUrl("/feed");
		Assert.assertEquals("Event Feed", page.getTitle());
	}

	@Test
	public void testGetNonExistingPageFromUrl() {
		Page page = Page.getFromUrl("/none");
		Assert.assertEquals(null, page);
	}

}
