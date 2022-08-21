package org.example;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
       System.out.println(calculateWords(readFile()));
    }
    public static ArrayList<String> readFile() throws Exception{
        FileReader fr = new FileReader("test.txt");
        Scanner sc = new Scanner(fr);
        ArrayList <String> numberOfWords = new ArrayList<>();
        while (sc.hasNextLine()){
            String temp = sc.nextLine();
            numberOfWords.addAll(List.of(temp.split(" ")));
        } return numberOfWords;
    }
    public static String calculateWords(ArrayList <String> numberOfWords){
        Map <String, Integer> words = new HashMap<>();

        String result = "";
        Collections.sort(numberOfWords);
        for (int i=0; i<numberOfWords.size(); i++){
            String temp = numberOfWords.get(i);

            if (!words.containsKey(temp)) {
                words.put(temp, 1);
            } else {
                words.put(temp, words.get(temp) + 1);
            }
        }
        for (Map.Entry<String, Integer> entry : words.entrySet()) {
            result += entry.getKey() + ": " + entry.getValue()+"\n";
        }
        return result;
    }
}
