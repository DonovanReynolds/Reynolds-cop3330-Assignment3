package ex45;
import ex45.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppTest {

    @Test
    @DisplayName("Test Replace1")
    public void testReplace1() throws IOException {
        ArrayList<String> words = App.makeString(App.getFileInput("src/test/java/ex45/TestReplacedFile"));
        ArrayList<String> tempList = App.makeString(App.getFileInput("src/test/java/ex45/TestinputFile"));
        App.change ("bee" , "bird", tempList);
        StringBuilder actual = new StringBuilder();
        StringBuilder expected = new StringBuilder();

        for (String s: words)
        {
            expected.append(s).append(" ");
        }

        for (String s: tempList)
        {
            actual.append(s).append(" ") ;
        }

        Assert.assertEquals(actual.toString(),expected.toString());

    }

}