package telegram;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SetMyCommands;
import configuration.BotConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import telegram.commands.CommandFactory;

@Component
@Slf4j
public class LinksNotifierBot extends Bot {

    final CommandFactory commandFactory;

    public LinksNotifierBot(BotConfig botConfig, CommandFactory commandFactory) {
        super(botConfig);
        this.commandFactory = commandFactory;
        telegramBot.execute(new SetMyCommands(commandFactory.getAllBotCommands()));
    }

    @Override
    public void handle(Update update){
        if (hasMessage(update)) {
            Long chatId = update.message().chat().id();
            log.info("Обработка обновления от " + chatId);
            if (isTextMessage(update)){
                telegramBot.execute(commandFactory.sendMessageForCommandFromUpdate(update));
            }
        }
    }

    private boolean hasMessage(Update update){
        return update.message() != null;
    }
    private boolean isTextMessage(Update update){
        return hasMessage(update) && update.message().text() != null;
    }
}