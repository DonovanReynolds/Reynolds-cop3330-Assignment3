package ex41;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class AppTest {

    @Test
    @DisplayName("Test Make Array")
    public void testMakeArray() throws IOException {
        ArrayList<String> temp = new ArrayList<>();

        temp.add("Ling, Mai");
        temp.add("Johnson, Jim");
        temp.add("Zarnecki, Sabrina");
        temp.add("Jones, Chris");
        temp.add("Jones, Aaron");
        temp.add("Swift, Geoffrey");
        temp.add("Xiong, Fong");

        FileReader fileIn = new FileReader("input/ex41/ex41_input.txt");
        BufferedReader testIn = new BufferedReader(fileIn);

        ArrayList<String> actual = ex41.App.makeArray(testIn);

        assertArrayEquals(temp.toArray(),actual.toArray());

    }

}
