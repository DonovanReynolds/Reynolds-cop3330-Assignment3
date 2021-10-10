package ex43;

import ex43.WebsiteGen;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class WebsiteGenTest {

    @Test
    @DisplayName("Generating name")
    void generateIndexContent_test1() throws IOException {
        String title = "testTitle";
        String author = "testAuthor";
        String expected = "<!DOCTYPE html>\n\n<html>\n\t<head>\n" +
                "\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" author =\"" + author + "\">\n" +
                "\t\t<title>" + title + "</title>\n" +
                "\t</head>\n\t<body>\n" +
                "\t\t<p>\n\t\t\t<----Replace with something useful---->\n\t\t</p>\n" +
                "\t</body>\n</html>";

        String actual = (new WebsiteGen()).generateIndexContent(title, author);

        assertTrue(expected.contentEquals(actual));
    }

    @Test
    @DisplayName("Generate with empty parameters")
    void generateIndexContent_test2() throws IOException {
        String title = "";
        String author = "";
        String expected = "<!DOCTYPE html>\n\n<html>\n\t<head>\n" +
                "\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" author =\"" + author + "\">\n" +
                "\t\t<title>" + title + "</title>\n" +
                "\t</head>\n\t<body>\n" +
                "\t\t<p>\n\t\t\t<----Replace with something useful---->\n\t\t</p>\n" +
                "\t</body>\n</html>";

        String actual = (new WebsiteGen()).generateIndexContent(title, author);

        assertTrue(expected.contentEquals(actual));
    }
}