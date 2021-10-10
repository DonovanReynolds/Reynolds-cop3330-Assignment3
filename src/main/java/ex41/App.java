package ex41;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Donovan Reynolds
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class App {


    public static void main(String[] args) throws IOException {
        BufferedReader in = null;
        ArrayList<String> names = new ArrayList<>();
        File outputFile = makeFile("input/ex41/exercise41_output.txt",false);
        File inputFile = makeFile("input/ex41/exercise41_input.txt" ,true);
        PrintWriter writer = new PrintWriter(outputFile);

        try {
            //check if file is null
            if(inputFile == null)
            {
                throw new FileNotFoundException();
            }
            //create the file in which to read
            FileReader fileIn = new FileReader(inputFile);
            in = new BufferedReader(fileIn);

            //store these names line by line
            names = makeArray(in);

            //sort these names using sort
            sort(names);

            //create the file output location
            outputFile.delete();

            //write to the file
            writer.println("Total of " + names.size() + " names");
            writer.println("-----------------------------------");
            for (String s: names)
            {
                writer.println(s);
            }
            writer.close();

        }
        //Check for any errors
        catch (FileNotFoundException e) {
            outputFile.delete();
            writer.println("ERROR: FILE NOT FOUND");
            writer.close();
        }
        finally
        {
            try{
                in.close();
                writer.close();
            }
            catch(NullPointerException ignored)
            {
            }
        }


    }

    public static ArrayList<String> makeArray(BufferedReader in) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        String line;

        while((line = in.readLine()) != null)
        {
            list.add(line);
        }
        return list;
    }

    public static void sort(ArrayList<String> arr)
    {
        Collections.sort(arr);
    }

    public static File makeFile(String path, boolean input) throws IOException {
        File temp = new File(path);
        if (input && temp.exists())
        {
            return temp;
        }
        else if (input)
        {
            return null;
        }
        else
        {
            temp.createNewFile();
        }
        return temp;
    }



}
