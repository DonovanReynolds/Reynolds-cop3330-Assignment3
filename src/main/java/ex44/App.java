package ex44;
/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Donovan Reynolds
 */

import HelpfulMethods.Methods;

import java.io.*;
import java.util.ArrayList;


public class App {

    //Get the file to parse from the .json
    //Parse file from json to arrayList of products
        //Create each product from the .json file
    //Take arraylist and find product inside
    //Print the product
    //If product does not exist then keep looping until it does

    public static void main(String[] args) throws IOException {

        JsonParse parse = new JsonParse();
        ArrayList<Product> list = parse.getProducts();
        String input;
        System.out.println(list);
        do
        {
             input = Methods.inputOutput("What is the product name?");
        } while(!checkArr(input,list));
    }

    public static boolean checkArr(String name, ArrayList<Product> arr)
    {
        for(Product p: arr)
        {
            if (p.getName().toLowerCase().contains(name.toLowerCase()))
            {

                System.out.println(p);
                return true;
            }
        }
        System.out.println("Sorry, that product was not found in our inventory.");
        return false;
    }


}
