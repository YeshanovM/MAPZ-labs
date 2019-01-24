package com.kpi_it62.api.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Game {

    public static List<Game> Games = new ArrayList<>();

    private long chatId;
    private int number;
    private int tries;

    public Game() {
    }

    public Game(long chatId, int number, int tries) {
        this.chatId = chatId;
        this.number = number;
        this.tries = tries;
    }

    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getTries() {
        return tries;
    }

    public void setTries(int tries) {
        this.tries = tries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return chatId == game.chatId &&
                number == game.number &&
                tries == game.tries;
    }

    @Override
    public int hashCode() {
        return Objects.hash(chatId, number, tries);
    }

    @Override
    public String toString() {
        return "Game{" +
                "chatId=" + chatId +
                ", number=" + number +
                ", tries=" + tries +
                '}';
    }
}
