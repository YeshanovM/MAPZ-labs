package com.kpi_it62.bot;

import com.kpi_it62.bot.command.GuessCmd;
import com.kpi_it62.bot.command.StartCmd;
import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class GuessWhatNumberBot extends TelegramLongPollingCommandBot {

    private static final String BOT_USERNAME = "com.kpi_it62.bot.GuessWhatNumberBot";

    private static final String BOT_TOKEN = "774065887:AAHlzaM1ouRgGUXQBzFFPNlBMBA0yCewytk";

    public GuessWhatNumberBot() {

        super(BOT_USERNAME);

        registerAll(
                new StartCmd(),
                new GuessCmd());
    }

    @Override
    public void processNonCommandUpdate(Update update) {

    }

    public String getBotToken() {
        return BOT_TOKEN;
    }
}
