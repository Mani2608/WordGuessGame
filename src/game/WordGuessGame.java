package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class WordGuessGame {
	private static Map<String,Integer> myMap;
	private String bot_guessed;
	ProcessDictionary run = new ProcessDictionary();
	int blacklisted_letters[] = new int[26];
	boolean crct_anagrm_found = false;
	WordGuessGame()                            // initializing level to numbers
	    {
	        myMap = new HashMap<String,Integer>();
	        myMap.put("easy", 4);
	        myMap.put("medium", 5);
	        myMap.put("hard", 6);
	    }
	
	int getCommonLetters(String st1, String st2) {   // returns num of common letters
		int alphabets[] = new int[26];
		for(int i=0;i<st1.length();i++)
			alphabets[st1.charAt(i)-'a']++;
		int ans = 0;
		for(int i=0;i<st2.length();i++) {
			if(alphabets[st2.charAt(i)-'a']!=0)
				ans++;
		}
		return ans;
	}
	/*
	 * first it asks for level and then user first guesses the word.
	 * 
	 */
	void setBlacklistedLetters(String input)
	{
		for(int i=0;i<26;i++)
			blacklisted_letters[i]=0;
		int alpha;
		input=input.toUpperCase();
		for(int i=0;i<input.length();i++)
		{
			alpha=((int)(input.charAt(i)))-65;
			blacklisted_letters[alpha]=-1;
		}
		
	}
	void startgame(){
		run.processDictionary();
		Scanner sc = new Scanner(System.in);
		System.out.println("Hey, I am PyPl game bot, Let's Play and choose level");
		String level = sc.nextLine();
		int numOfDigits = myMap.get(level);
		bot_guessed = getRandomWord(numOfDigits);
		System.out.println("Now guess my word");
		String opponent_answer = "";
		int index = 0;
		while(true){
		String hum_guess_word = sc.nextLine();
		int cnt_cmn_letrs = getCommonLetters(bot_guessed,hum_guess_word);
		System.out.println("Common letters are "+cnt_cmn_letrs);
		System.out.println(runWordAlgo()); // computer guesses word
		Pair<String,Integer> next_word = getNextWord(index++);
		opponent_answer = sc.nextLine();
		if(opponent_answer.equals("You Won")){
			System.out.println("thank you");
			break;
		}
		else{
			int opponent_cmn_letrs = Integer.parseInt(opponent_answer);
			if(opponent_cmn_letrs==0))
			{
				setBlacklistedLetters(hum_guess_word);
			}
			else if(opponent_cmn_letrs==numOfDigits) {
				
			}
		}
		System.out.println();
		
		}
	}
	String getNextWord(int index) {
		ArrayList<ArrayList<String>> n_letter_word_with_anagrams = getfrompoojitha();
		while(true) {
		String next_word = n_letter_word_with_anagrams.get(index++).get(0);
		for(int i=0;i<next_word.length();i++) {
			if()
		}
		}
		
	}
	String getRandomWord(int num_of_digits) {
		
		ArrayList<String> n_letter_words = getfrompoojitha();
		Random rand = new Random();
		int index = rand.nextInt(n_letter_words.size());
		return n_letter_words.get(index);
	}

}
