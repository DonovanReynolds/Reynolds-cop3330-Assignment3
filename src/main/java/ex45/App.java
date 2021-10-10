package ex45;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Donovan Reynolds
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class App {

    public static void main (String[] args) throws IOException {
        //Read in the input from file
        //store the input in arraylist
            //Split the array up every time there is a space into a new word
        //Check to see if each element in the array contains the word "Utilize"
            //if it does contain utilize change utilize to use then store
        //Prompt for an output file
        //Write each element one by one in an output file


        BufferedReader inputFile =  getFileInput("input/ex45/exercise45_input.txt");
        ArrayList<String> inputText = makeString(inputFile);
        inputFile.close();
        change("utilize" , "use" , inputText);

        File output = new File("input/ex45/exercise45_output.txt");
        writeToFile(output, inputText);

        //System.out.println(inputText);


    }

    public static BufferedReader getFileInput(String path)
    {
        try {
            File file = new File(path);
            return new BufferedReader(new FileReader (file));
        } catch(FileNotFoundException fnf)
        {
            System.out.println("ERROR FILE NOT FOUND");
            System.exit(0);
        }
        return null;
    }

    public static ArrayList<String> makeString(BufferedReader input) throws IOException {
        String val = "";
        StringBuilder finalString = new StringBuilder();
        while((val = input.readLine())!=null)
        {
            finalString.append(val).append(" \n");
        }

        String[] temp = finalString.toString().split(" ");

        return new ArrayList<>(Arrays.asList(temp));
    }

    public static void change(String oldWord, String newWord, ArrayList<String> words)
    {

        for (int i = 0; i < words.size(); i++)
        {
            if (words.get(i).toLowerCase().contains(oldWord + "s"))
                words.set(i,newWord + "s");
            if (words.get(i).toLowerCase().contains(oldWord))
                words.set(i,newWord);
        }
    }

    public static void writeToFile(File outputFile, ArrayList<String> words) throws IOException {
        if(outputFile.exists())
        {
            outputFile.delete();
        }

        if(outputFile.createNewFile())
        {
            BufferedWriter write = new BufferedWriter(new FileWriter(outputFile));

            for (String s: words)
            {
                write.write(s + " ");
            }
            write.close();
        }
    }


}
