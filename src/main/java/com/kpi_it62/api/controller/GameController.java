package com.kpi_it62.api.controller;

import com.kpi_it62.api.model.Game;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/games")
class GameController {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Game> findAll() {
        return Game.Games;
    }

    @RequestMapping(value = "/{chatId}", method = RequestMethod.GET)
    @ResponseBody
    public Game find(@PathVariable("chatId") Long chatId) {

        for (Game game : Game.Games) {

            if (game.getChatId() == chatId) {
                return game;
            }
        }

        return null;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Game resource) {
        Game.Games.add(resource);
    }

    @RequestMapping(value = "/{chatId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable( "chatId" ) Long chatId, @RequestBody Game resource) {

        Game game = find(chatId);

        if(game != null) {

            game.setChatId(resource.getChatId());
            game.setNumber(resource.getNumber());
            game.setTries(resource.getTries());
        }
    }

    @RequestMapping(value = "/{chatId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("chatId") Long chatId) {

        Game game = find(chatId);

        if(game != null) {
            Game.Games.remove(game);
        }
    }
}