package pagetracker.models;

import lombok.Data;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Data
public class Hit extends Event {

	String userId;
    Page page;
	LocalDateTime timestamp;

    public Hit(String userId, Page page, LocalDateTime timestamp) {

    	this.setUserId(userId);
        this.setPage(page);
        this.setTimestamp(timestamp);
        this.setType(Type.HIT);

    }

    public static Hit create(String userId, String url, String timestamp) {

        return new Hit(
        		userId,
                Page.getFromUrl(url),
				LocalDateTime.ofInstant(Instant.ofEpochSecond(Long.parseLong(timestamp)), ZoneOffset.UTC)
		);

    }

}
