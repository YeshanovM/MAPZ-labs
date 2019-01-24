package com.kpi_it62.bot;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class BotRunner {

    public static void main(String[] args) {

        ApiContextInitializer.init();

        TelegramBotsApi botsApi = new TelegramBotsApi();

        try {
            botsApi.registerBot(new GuessWhatNumberBot());
        } catch (TelegramApiException ex) {
            System.err.println("Bot registration failed:");
            ex.printStackTrace();
        }

        System.out.println("Bot initialization finished");
    }
}
