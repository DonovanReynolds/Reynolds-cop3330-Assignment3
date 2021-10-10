package ex42;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;

import java.io.*;
import java.util.ArrayList;

import static ex42.App.brokenUpInput;
import static ex42.App.storeInput;

public class AppTest {
    static ArrayList<String> testArr;

    public static void init()
    {
        testArr = new ArrayList<>();
        testArr.add("Ling,Mai,55900");
        testArr.add("Johnson,Jim,56500");
        testArr.add("Jones,Aaron,46000");
        testArr.add("Jones,Chris,34500");
        testArr.add("Swift,Geoffrey,14200");
        testArr.add("Xiong,Fong,65000");
        testArr.add("Zarnecki,Sabrina,51500");
    }


    @AfterAll

    @Test
    @DisplayName("Test makearray")
    public void testMakearray() throws IOException {

        init();
        ArrayList<String> testInput = storeInput(App.readInput());
    }

    @Test
    @DisplayName("test splitarray")
    public void testSplit()
    {
        init();
        ArrayList<Person> test = brokenUpInput(testArr,",");
        ArrayList<Person> actual = new ArrayList<>();

        actual.add(new Person(55900,"Mai","Ling"));
        actual.add(new Person(56500,"Jim","Johnson"));
        actual.add(new Person(46000,"Aaron","Jones"));
        actual.add(new Person(34500,"Chris","Jones"));
        actual.add(new Person(14200,"Geoffrey","Swift"));
        actual.add(new Person(65000,"Fong","Xiong"));
        actual.add(new Person(51500,"Sabrina","Zarnecki"));

        Assert.assertEquals(actual.toString(),test.toString());


    }




}
