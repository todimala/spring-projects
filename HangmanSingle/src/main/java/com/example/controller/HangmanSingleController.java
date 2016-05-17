package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HangmanSingleController {

	private Map<String, HangmanGame> activeGames = new HashMap<String, HangmanGame>();

	@RequestMapping("/hello")
    public String index() {
        return "Greetings from Spring Boot 1!";
    }
	
	@RequestMapping(value = "/listGames", method = RequestMethod.GET)
	public String listGames(ModelMap model) {
		JSONObject jo;
		JSONArray ja = new JSONArray();
		for (String gameId : activeGames.keySet()) {
			jo = new JSONObject();
			jo.put("gameId", gameId);
			ja.put(jo);
		}
		return ja.toString();
	}
	
	@RequestMapping(value = "/getGame", method = RequestMethod.GET)
	public String getGame(@RequestParam(name="gameId") String gameId, ModelMap model) {
		if (activeGames.containsKey(gameId)) {
			HangmanGame game = activeGames.get(gameId);
			model.addAttribute("game_id", game.getGameId());
			model.addAttribute("guess_word", game.getGuessWord());
			model.addAttribute("max_lives", game.getMaxLives());
			model.addAttribute("used_lives", game.getMaxLives());
			return game.toJson();
		} else {
			model.addAttribute("code", 404);
			model.addAttribute("message", "Game not found");
		}
		return "Error";	
	}

	@RequestMapping(value = "/newGame", method = RequestMethod.POST)
	public String newGame(@RequestParam(name="name") String name,
			ModelMap model) 
	{
		HangmanGame game = new HangmanGame("Hello World");
		activeGames.put(game.getGameId(), game);
		model.addAttribute("game_id", game.getGameId());
		model.addAttribute("guess_word", game.getGuessWord());
		model.addAttribute("max_lives", game.getMaxLives());
		model.addAttribute("used_lives", game.getMaxLives());

		return game.toJson();
	}
	
	@RequestMapping(value = "/playGame", method = RequestMethod.PUT)
	public String playGame(@RequestParam(name="gameId") String gameId, 
					@RequestParam(name="guessChar") Character guessChar, ModelMap model) 
	{
		HangmanGame game = activeGames.get(gameId);
		game.guessChar(guessChar);
		model.addAttribute("game_id", game.getGameId());
		model.addAttribute("guess_word", game.getGuessWord());
		model.addAttribute("max_lives", game.getMaxLives());
		model.addAttribute("used_lives", game.getMaxLives());
		return game.toJson();
	}

	@RequestMapping(value = "/guessWord", method = RequestMethod.PUT)
	public String guessWord(@RequestParam(name="gameId") String gameId, 
					@RequestParam(name="guessWord") String guessWord, ModelMap model) 
	{
		HangmanGame game = activeGames.get(gameId);
		if (activeGames.containsKey(gameId)) {
			model.addAttribute("game_id", game.getGameId());
			model.addAttribute("max_lives", game.getMaxLives());
			model.addAttribute("used_lives", game.getMaxLives());
			
			if (game.guessTheWord(guessWord)) {
				model.addAttribute("guess_word", guessWord);
			} else 
			{
				model.addAttribute("guess_word", game.getGuessWord());
			}
			return game.toJson();
		} else {
			model.addAttribute("code", 404);
			model.addAttribute("message", "Game not found");
		}
		return "Error";
	}
	
}
