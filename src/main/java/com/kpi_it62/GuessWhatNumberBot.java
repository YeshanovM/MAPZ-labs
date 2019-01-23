package com.kpi_it62;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

public class GuessWhatNumberBot extends TelegramLongPollingBot {

    private static final String BOT_USERNAME = "com.kpi_it62.GuessWhatNumberBot";

    private static final String BOT_TOKEN = "774065887:AAHlzaM1ouRgGUXQBzFFPNlBMBA0yCewytk";

    private void sendTextMessage(Message message, String text) {

        try {

            long chatId = message.getChatId();

            SendMessage sendMessage = new SendMessage()
                    .setChatId(chatId)
                    .setText(text);

            execute(sendMessage);

        } catch (Exception ex) {
            System.err.println("Error sending text message:");
            ex.printStackTrace();
        }
    }

    public void onUpdateReceived(Update update) {
        sendTextMessage(update.getMessage(), "Hello!");
    }

    public String getBotUsername() {
        return BOT_USERNAME;
    }

    public String getBotToken() {
        return BOT_TOKEN;
    }
}
