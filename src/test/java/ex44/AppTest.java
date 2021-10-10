package ex44;
import ex44.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;

public class AppTest {

    @Test
    @DisplayName("Test search")
    public void testSearch()
    {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("Test1" , 121.12,15));
        products.add(new Product("Test2" , 145,11));
        products.add(new Product("Test3" , 230,2));

        boolean actual = App.checkArr("Test4" , products);

        Assert.assertFalse(actual);
        actual = App.checkArr("test1" ,products);
        Assert.assertTrue(actual);

    }
}