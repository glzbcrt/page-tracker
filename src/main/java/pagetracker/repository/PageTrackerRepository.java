package pagetracker.repository;

public interface PageTrackerRepository {

    void addHit(String userId, String url, String timestamp) throws Exception;
    int hitCounter();

    void addContact(String userId, String name, String email) throws Exception;
    int contactCounter();

}
