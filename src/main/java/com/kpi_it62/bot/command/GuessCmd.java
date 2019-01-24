package com.kpi_it62.bot.command;

import com.kpi_it62.api.controller.GameController;
import com.kpi_it62.api.model.Game;
import com.kpi_it62.bot.util.MessageSender;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;

public class GuessCmd extends BotCommand {

    private static final String IDENTIFIER = "guess";
    private static final String DESCRIPTION = "Guess a number";

    public GuessCmd() {
        super(IDENTIFIER, DESCRIPTION);
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {

        long chatId = chat.getId();

        try {

            int guessedNumber = Integer.parseInt(strings[0]);

            GameController gameController = new GameController();
            Game game = gameController.find(chatId);

            if (game == null) {
                MessageSender.sendGameNotStartedMessage(absSender, chatId);
            } else {

                game.setTries(game.getTries() + 1);

                int realNumber = game.getNumber();

                if (realNumber == guessedNumber) {

                    gameController.delete(chatId);

                    MessageSender.sendGameFinishedMessage(absSender, chatId, game.getTries());
                } else  {

                    gameController.update(chatId, game);

                    if(realNumber > guessedNumber) {
                        MessageSender.sendGreaterMessage(absSender, chatId);
                    } else {
                        MessageSender.sendLessMessage(absSender, chatId);
                    }
                }
            }
        } catch (NumberFormatException ex) {
            MessageSender.sendInvalidNumberMessage(absSender, chatId);
        }
    }
}
