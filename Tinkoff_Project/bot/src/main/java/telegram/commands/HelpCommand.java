package telegram.commands;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HelpCommand implements Command {

    private static String HELP_MESSAGE = """
            /start - старт
            /help -- показать все команды
            /track -- начать слежение за новой ссылкой
            /untrack - прекратить слежение за ссылкой
            /list - показать все отслеживаемые ссылки
             """;

    @Override
    public String getCommand() {
        return "/help";
    }

    @Override
    public String getDescription() {
        return "показать все команды";
    }

    @Override
    public SendMessage handle(Update update) {
        log.info("/help command");
        Long chatId = update.message().chat().id();
        return new SendMessage(chatId, HELP_MESSAGE);
    }
}