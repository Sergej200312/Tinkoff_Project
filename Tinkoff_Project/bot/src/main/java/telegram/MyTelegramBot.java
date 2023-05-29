package telegram;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;


import java.util.ArrayList;
import java.util.List;


public class MyTelegramBot extends TelegramLongPollingBot {

    private final String token;

    public MyTelegramBot() {
        this.token = "6063694409:AAEodzBg_j3XGa0e2V0Dr0YmvWXE7tSH2ms";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            if (messageText.equals("/start")) {
                sendTextMessage(chatId, "Вы зарегистрированы!");
            } else if (messageText.equals("/help")) {
                String helpText = "Список команд:\n" +
                        "/start - зарегистрировать пользователя\n" +
                        "/help -- вывести окно с командами\n" +
                        "/track -- начать отслеживание ссылки\n" +
                        "/untrack -- прекратить отслеживание ссылки\n" +
                        "/list -- показать список отслеживаемых ссылок";
                sendTextMessage(chatId, helpText);
            } else if (messageText.equals("/track")) {
                sendTextMessage(chatId, "Начато отслеживание ссылки.");
            } else if (messageText.equals("/untrack")) {
                sendTextMessage(chatId, "Отслеживание ссылки прекращено.");
            } else if (messageText.equals("/list")) {
                sendTextMessage(chatId, "Список отслеживаемых ссылок:");
            } else {
                sendTextMessage(chatId, "Такой команды нет");
            }
        }
    }

    private void sendTextMessage(long chatId, String text) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(text);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "LinkParser1234Bot";
    }

    @Override
    public String getBotToken() {
        return token;
    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyTelegramBot());
    }
}