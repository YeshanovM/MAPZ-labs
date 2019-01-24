package com.kpi_it62.bot.util;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MessageSender {

    private static final String GAME_ALREADY_STARTED_MESSAGE = "The game was already started. Finish your previous game first.";
    private static final String GAME_SUCCESSFULLY_STARTED_MESSAGE = "I've made up a number from 1 to 100 inclusively. Now /guess {number}";
    private static final String GAME_NOT_STARTED_MESSAGE = "Game was not started yet. You can start it with /start";
    private static final String GAME_FINISHED_MESSAGE = "Congratulations! You won!\n\nTries: ";
    private static final String LESS_MESSAGE = "The actual number is LESS than you have supposed, try again.";
    private static final String GREATER_MESSAGE = "The actual number is GREATER than you have supposed, try again.";
    private static final String INVALID_NUMBER_MESSAGE = "Invalid argument format! Only number allowed.";

    public static void sendGameAlreadyStartedMessage(AbsSender absSender, long chatId) {

        sendMessage(absSender, chatId, GAME_ALREADY_STARTED_MESSAGE);
    }

    public static void sendGameSuccessfullyStartedMessage(AbsSender absSender, long chatId) {

        sendMessage(absSender, chatId, GAME_SUCCESSFULLY_STARTED_MESSAGE);
    }

    public static void sendGameNotStartedMessage(AbsSender absSender, long chatId) {

        sendMessage(absSender, chatId, GAME_NOT_STARTED_MESSAGE);
    }

    public static void sendGameFinishedMessage(AbsSender absSender, long chatId, int tries) {

        sendMessage(absSender, chatId, GAME_FINISHED_MESSAGE + tries);
    }

    public static void sendLessMessage(AbsSender absSender, long chatId) {

        sendMessage(absSender, chatId, LESS_MESSAGE);
    }

    public static void sendGreaterMessage(AbsSender absSender, long chatId) {

        sendMessage(absSender, chatId, GREATER_MESSAGE);
    }

    public static void sendInvalidNumberMessage(AbsSender absSender, long chatId) {

        sendMessage(absSender, chatId, INVALID_NUMBER_MESSAGE);
    }

    private static void sendMessage(AbsSender absSender, long chatId, String text) {

        SendMessage sendMessage = new SendMessage();

        sendMessage.setChatId(chatId);
        sendMessage.setText(text);

        try {
            absSender.execute(sendMessage);
        } catch (TelegramApiException ex) {
            System.err.println("Error sending message");
            ex.printStackTrace();
        }
    }
}
