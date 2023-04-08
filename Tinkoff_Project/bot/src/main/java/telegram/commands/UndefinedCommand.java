package telegram.commands;

import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Component;
import com.pengrad.telegrambot.model.Update;

@Component
public class UndefinedCommand implements Command {
    @Override
    public String getCommand() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public SendMessage handle(Update update) {
        Long chatId = update.message().chat().id();
        return new SendMessage(chatId, "Неизвестная команда");
    }
}