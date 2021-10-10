package ex42;

/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Donovan Reynolds
 */
import java.io.*;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;


public class App
{
    public static void main(String[] args) throws IOException {
        //Read in input from file
        BufferedReader read = readInput();

        //Store input into an array
        ArrayList<String> input = storeInput(read);

        //Break array into smaller pieces based on breakpoints
        ArrayList<Person> peopleList = brokenUpInput(input,",");

        //Make output File
        File outputFile = makeFile("input/ex42/exercise42_output.txt",false);

        //Store into an output
        output(outputFile,peopleList);

    }

    public static BufferedReader readInput() throws IOException {
        File fileIn = makeFile("input/ex42/exercise42_input.txt",true);
        if (fileIn == null)
        {
            System.out.println("FILE NOT FOUND");
            System.exit(0);
        }
        try
        {
            FileReader fileRead = new FileReader(fileIn);
            return new BufferedReader(fileRead);
        }
        catch (FileNotFoundException fnf)
        {
            System.out.println("FILE NOT FOUND");
            System.exit(0);
        }
        return null;
    }

    public static ArrayList<String> storeInput(BufferedReader read) throws IOException {
        ArrayList<String> temp = new ArrayList<>();
        String line;
        while((line = read.readLine()) != null)
        {
            temp.add(line);
        }
        return temp;
    }

    public static ArrayList<Person> brokenUpInput(ArrayList<String> info, String breakup)
    {
        ArrayList<Person> temp = new ArrayList<>();
        for(String s: info)
        {
            String[] arr = s.split(breakup);
            String firstName = arr[1];
            String lastName = arr[0];
            int salary = Integer.parseInt(arr[2]);

            Person tempPerson = new Person(salary,firstName,lastName);
            temp.add(tempPerson);
        }
        return temp;
    }

    public static void output (File file,ArrayList<Person> people) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(file);
        String toAdd = StringUtils.rightPad("Last" , 20);
        toAdd += StringUtils.rightPad("First" , 20);
        toAdd += StringUtils.rightPad("Salary" , 10);
        writer.println(toAdd);
        writer.println("-------------------------------------------------");
        for (Person p: people)
        {
            writer.println(p);
        }
        writer.close();
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
