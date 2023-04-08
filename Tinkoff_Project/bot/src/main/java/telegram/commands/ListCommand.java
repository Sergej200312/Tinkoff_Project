package telegram.commands;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Component
public class ListCommand implements Command {

    List<String> links = new ArrayList<>();

    public ListCommand(){

    }

    @Override
    public String getCommand() {
        return "/list";
    }

    @Override
    public String getDescription() {
        return "показать все отслеживаемые ссылки";
    }

    @Override
    public SendMessage handle(Update update) {
        Long chatId = update.message().chat().id();
        String message = getListMessage(chatId);
        return new SendMessage(chatId, message);
    }

    private String getListMessage(Long chatId){
        log.info("Получение всех отслеживаемых ссылок для " + chatId);
        if (hasSubscriptions(chatId)){
            return getListOfSubscribedLinksForChatId(chatId);
        }
        else {
            return "У вас нет никаких ссылок в отслеживании";
        }
    }

    private boolean hasSubscriptions(Long chatId){
        return !links.isEmpty();
    }

    private String getListOfSubscribedLinksForChatId(Long chatId){
        return String.join("\n\n", links);
    }
}
