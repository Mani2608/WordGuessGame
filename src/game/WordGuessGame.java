package game;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordGuessGame {
	private static Map<String,Integer> myMap;
	private String bot_guessed;
	WordGuessGame()
	    {
	        myMap = new HashMap<String,Integer>();
	        myMap.put("easy", 4);
	        myMap.put("medium", 5);
	        myMap.put("hard", 6);
	    }
	
	int getCommonLetters(String st1, String st2) {
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
	void startgame(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Hey, I am PyPl game bot, Let's Play and choose level");
		String level = sc.nextLine();
		int numOfDigits = myMap.get(level);
		bot_guessed = getRandomWord();
		System.out.println("Now guess my word");
		String output = "";
		while(!output.equals("You Won")){
		String hum_guess_word = sc.nextLine();
		int cnt_cmn_letrs = getCommonLetters(bot_guessed,hum_guess_word);
		System.out.println("Common letters are "+cnt_cmn_letrs);
		System.out.println(getRandomWord()); // computer guesses word
		int opponent_cmn_letrs = sc.nextInt();
		sc.nextLine();
		if(opponent_cmn_letrs==0 || opponent_cmn_letrs==numOfDigits)
		{
			callTanyafunction();  // tanya's function.
		}
		System.out.println();
		
		}
	}
	String getRandomWord() {
		File dictionary = new File("sowpods.txt");
		
	}

}
