package service;

import domains.TgUser;

public interface TgUserService {
    void addTgUser(TgUser tgUser);
    void removeTgUser(long tgUserId);
    TgUser findByChatId(long chatId);
}
