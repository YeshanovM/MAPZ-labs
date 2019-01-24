package com.kpi_it62.bot.command;

import com.kpi_it62.api.controller.GameController;
import com.kpi_it62.api.model.Game;
import com.kpi_it62.bot.util.MessageSender;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

public class StartCmd extends BotCommand {

    private static final String IDENTIFIER = "start";
    private static final String DESCRIPTION = "I'll make up a number and you'll have to guess it";

    public StartCmd() {
        super(IDENTIFIER, DESCRIPTION);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {

        long chatId = chat.getId();

        GameController gameController = new GameController();
        Game game = gameController.find(chatId);

        if(game == null) {

            int number = ((int) (Math.random() * 99)) + 1;

            game = new Game(chatId, number, 0);
            gameController.create(game);

            MessageSender.sendGameSuccessfullyStartedMessage(absSender, chatId);
        } else {
            MessageSender.sendGameAlreadyStartedMessage(absSender, chatId);
        }
    }
}
