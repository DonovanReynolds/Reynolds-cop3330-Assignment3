package ex43;
/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Donovan Reynolds
 */

import HelpfulMethods.Methods;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        //Prompt for the name of the site
        String name = Methods.inputOutput("Site name:");
        //Prompt for the author of the site
        String author = Methods.inputOutput("Author:");
        //Ask if the user wants a folder for JavaScript files
        String javaScriptFolder = Methods.inputOutput("Do you want a folder for JavaScript?");
        boolean JSFolder = javaScriptFolder.toLowerCase().charAt(0) == 'y';
        //Ask if the user wants a folder for CSS files
        String CCS = Methods.inputOutput("Do you want a folder for CSS");
        boolean CSSFolder = CCS.toLowerCase().charAt(0) == 'y';
        //Generate an index.html file that contains the name of the site inside the <Title> tag and the author in a <meta> tag
        WebsiteGen gen = new WebsiteGen(name,author,JSFolder,CSSFolder);
        gen.makeFolders();


    }
}
