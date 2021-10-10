package ex46;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Donovan Reynolds
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class App {

    public static void main(String[] args) throws IOException {
        //Read input from file
        //Store this input as a string
        //Split this string up for every word
        //Use an Object called word that has a String name and int frequency to count
            //If split text has new word create new object
            //else increment count
        //Sort words by frequency
        //Print out words

        ArrayList<Word> words = makeWords(getFileInput("input/ex46/exercise46_input.txt"));

        Collections.sort(words);

        for(Word w: words)
        {
            System.out.println(w);
        }

    }

    public static BufferedReader getFileInput(String path)
    {
        try {
            File file = new File(path);
            return new BufferedReader(new FileReader(file));
        } catch(FileNotFoundException fnf)
        {
            System.out.println("ERROR FILE NOT FOUND");
            System.exit(0);
        }
        return null;
    }

    public static ArrayList<Word> makeWords(BufferedReader input) throws IOException {
        String val = "";
        StringBuilder finalString = new StringBuilder();
        while((val = input.readLine())!=null)
        {
            finalString.append(val).append(" ");
        }

        String[] temp = finalString.toString().split(" ");

        ArrayList<Word> retVal = new ArrayList<>();
        boolean check = false;
        for (String s: temp)
        {
            check = false;
            for (Word w: retVal)
            {
                if (w.getName().equalsIgnoreCase(s))
                {
                    w.incrementFreq();
                    check = true;
                    break;
                }
            }
            if (!check)
                retVal.add(new Word(s));
        }
        return retVal;
    }
}
