package telegram.commands;


import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TrackCommand extends CommandWithReply{

    @Override
    public String getMessageToReply() {
        return "Пришлите мне ссылку, которую вы хотите отследить";
    }

    @Override
    public String getCommand() {
        return "/track";
    }

    @Override
    public String getDescription() {
        return "подписать новую ссылку";
    }

    @Override
    public SendMessage handle(Update update) {
        log.info("/track command");
        Long chatId = update.message().chat().id();
        if (isOriginalCommand(update)){
            return sendMessageWithForceReply(chatId);
        }
        else if (isReplyToMessage(update)){
            String linkFromText = update.message().text();
            subscribeLink(linkFromText);
            String message = "ссылка была подписана";
            return new SendMessage(chatId, message);
        }
        return null;
    }


    private void subscribeLink(String link){
        log.info("Subscribing to " + link);
    }
}