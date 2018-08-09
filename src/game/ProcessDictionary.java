package game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class ProcessDictionary {
	

	static ArrayList<ArrayList<String>> easy4 = new ArrayList<>();
    static ArrayList<ArrayList<String>> medium5 = new ArrayList<>();
    static ArrayList<ArrayList<String>> hard6 = new ArrayList<>();

    static String sortedString (String unsorted){
        char temp[] = unsorted.toCharArray();
        Arrays.sort(temp);
        return new String(temp);
    }

    static ArrayList<ArrayList<String>> convertToAnagrams(ArrayList<String> input){
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        for(int i=0;i<input.size();i++){
            String temp = sortedString(input.get(i));
            ArrayList<String> anagram = new ArrayList<>();
            anagram.add(input.get(i));
            for(int j = i+1;j<input.size();j++){
                if(temp.equals(sortedString(input.get(j)))){
                    anagram.add(input.get(j));
                    input.remove(j);
                }
            }
            result.add(anagram);
        }
        return result;
    }

    public static void main(String[] args) throws  Exception {
        File file = new File("sowpods.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String word;
        ArrayList<String> letter4 = new ArrayList<>();
        ArrayList<String> letter5 = new ArrayList<>();
        ArrayList<String> letter6 = new ArrayList<>();
        while ((word = br.readLine()) != null){
            if(word.length()==4){
                letter4.add(word);
            }
            else if (word.length()==5){
                letter5.add(word);
            }
            else if(word.length()==6){
                letter6.add(word);
            }
        }
        System.out.println(letter4.size());
        System.out.println(letter5.size());
        System.out.println(letter6.size());

        easy4 = convertToAnagrams(letter4);
        medium5 = convertToAnagrams(letter5);
        hard6 = convertToAnagrams(letter6);

        System.out.println("--------------");

        System.out.println(easy4.size());
        System.out.println(medium5.size());
        System.out.println(hard6.size());

        System.out.println("--------------");

        for(int i=0;i<medium5.size();i++){
            if(medium5.get(i).size()>1)
                System.out.println(medium5.get(i));
        }
        System.out.println();


    }
}
