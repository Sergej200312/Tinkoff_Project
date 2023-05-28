package domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TgUser {
    private long id;
    private long chatId;
    private String userName;

    public TgUser() {

    }
}
