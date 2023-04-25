package domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
public class LinkSubscription {
    private long id;
    private long tgUserId;
    private String link;
    private LocalDateTime lastUpdate;

    public LinkSubscription() {

    }
}
