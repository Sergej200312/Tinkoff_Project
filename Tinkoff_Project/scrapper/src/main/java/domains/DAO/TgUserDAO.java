package domains.DAO;

import domains.TgUser;

import java.util.List;

public interface TgUserDAO {
    TgUser add(TgUser tgUser);

    void remove(long id);

    List<TgUser> findAll();
}
