package HelpfulMethods;

import java.util.Scanner;

public class Methods {
    public static String inputOutput(String textToSay)
    {
        Scanner input = new Scanner(System.in);
        System.out.println(textToSay);
        return input.nextLine();
    }

    public static char getFirstChar(String textToSay)
    {
        Scanner input = new Scanner(System.in);
        System.out.println(textToSay);
        return input.nextLine().toLowerCase().charAt(0);
    }

    public static int stringToInt(String error)
    {
        int temp = 0;
        boolean check = false;
        while(!check)
        {
            String text = inputOutput(error);
            try
            {
                temp = Integer.parseInt(text);
                check = true;
            }
            catch(NumberFormatException e)
            {
                System.out.println("You entered a value that is not a number. Please try again.");


            }
        }
        return temp;
    }
    public static int stringToIntNoLoop(String error)
    {
        int temp = -1;

            String text = inputOutput(error);
            try
            {
                temp = Integer.parseInt(text);
                return temp;
            }
            catch(NumberFormatException e)
            {
                System.out.println("Only enter number values");
                return temp;
            }

    }

    public static double stringToDouble (String error)
    {
        double temp = 0.0;
        boolean check = false;
        while(!check)
        {
            String text = inputOutput(error);
            try
            {
                temp = Double.parseDouble(text);
                check = true;
            }
            catch(NumberFormatException e)
            {
                System.out.println("You entered a value that is not a number. Please try again.");

            }
        }
        return temp;
    }
}
