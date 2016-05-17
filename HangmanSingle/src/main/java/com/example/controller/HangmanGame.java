package com.example.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONObject;

public class HangmanGame {
	private final String gameId;
	private final String secretWord;
	private List<Character> guessWord;
	private final int maxLives = 11;
	private int usedLives = 0;
	private Map<Character, Integer> charMap;
	private Set<Character> guessedChars;
	private StringBuilder gameStr;
	

	public HangmanGame(String word) {
		this.gameId = String.valueOf(System.currentTimeMillis());
		this.secretWord = word.toLowerCase();
		this.guessWord = new ArrayList<Character>(word.length());
		this.charMap = new HashMap<Character, Integer>();
		this.guessedChars = new HashSet<Character>();
		for (int index=0; index< secretWord.length(); index++) {
			
			Character ch = secretWord.charAt(index);
			if (ch != ' ') {
				guessWord.add('*');
			} else {
				guessWord.add(' ');
			}
			
			if (charMap.containsKey(ch)) {
				charMap.put(ch, charMap.get(ch)+1);
			} else {
				charMap.put(ch, 1);
			}
		}
	}
	
	public int charPresent(char guessChar) {
		if (!charMap.containsKey(guessChar)) {
			return 0;	
		}
		int numCharOccurences = charMap.get(guessChar);
		
		return numCharOccurences;
	}
	
	public String guessChar(char guessChar) {
		if (usedLives >= maxLives) {
			return guessWord.toString();
		}
		
		if (!charMap.containsKey(guessChar)) {
			usedLives++;
			return guessWord.toString();	
		}
		charMap.remove(guessChar);
		guessedChars.add(guessChar);
		
		for (int index=0; index< secretWord.length(); index++) {
			if (secretWord.charAt(index) == guessChar) {
				guessWord.set(index, guessChar);
			}
		}
		
		return guessWord.toString();
	}
	
	public boolean guessTheWord(String word) {
		if (usedLives >= maxLives) {
			return false;
		}
		
		System.out.println("Gussed Word: " + word);
		System.out.println("Secret Word: " + secretWord);
		boolean match = this.secretWord.matches(word.toLowerCase());
		if (match) {
			for (int index=0; index< secretWord.length(); index++) {
				Character ch = secretWord.charAt(index);
				guessWord.set(index, ch);
			}	
		}
		return match;
	}
	
	/**
	 * @return the gameId
	 */
	public String getGameId() {
		return gameId;
	}

	/**
	 * @return the secretWord
	 */
	private String getSecretWord() {
		return secretWord;
	}
	
	public String getGuessWord() {
		StringBuilder currGuessWord = new StringBuilder(guessWord.size());
		for (Character ch : guessWord) {
			currGuessWord.append(ch);
		}
		return currGuessWord.toString();
	}

	/**
	 * @return the maxPlays
	 */
	public int getMaxLives() {
		return maxLives;
	}

	/**
	 * @return the playsCompleted
	 */
	public int getUsedLives() {
		return usedLives;
	}

	/**
	 * @param playsCompleted the playsCompleted to set
	 */
	public void setUsedLives(int playsCompleted) {
		this.usedLives = playsCompleted;
	}
	
	@Override
	public String toString() {
		JSONObject json = new JSONObject();
		json.put("GameId", gameId);
		json.put("GuessWord", getGuessWord());
		json.put("MaxLives", maxLives);
		json.put("UsedLives", usedLives);
		return json.toString();
	}
	
	public String toJson() {
		JSONObject json = new JSONObject();
		json.put("GameId", gameId);
		json.put("GuessWord", getGuessWord());
		json.put("MaxLives", maxLives);
		json.put("UsedLives", usedLives);
		return json.toString();
	}
}

