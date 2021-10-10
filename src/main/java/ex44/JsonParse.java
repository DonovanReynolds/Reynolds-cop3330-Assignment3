package ex44;

import com.google.gson.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;


public class JsonParse {

    static ArrayList<Product> products = new ArrayList<>();

    public JsonParse() throws IOException {
        Gson gson = new Gson();


        JsonObject obj = new JsonObject();
        JsonArray arr = new JsonArray();
        obj = gson.fromJson(getFile("input/ex44/exercise44_input.json"),JsonObject.class);
        arr = (JsonArray) obj.get("products");
        makeArr(arr);
    }

    public ArrayList<Product> getProducts()
    {
        return products;
    }

    private static void makeArr(JsonArray arr)
    {

        for (Object item :arr)
        {
            JsonObject temp = (JsonObject) item;

            String[] nameTemp = temp.get("name").toString().split("\"");
            String name = nameTemp[1];
            double price = Double.parseDouble(temp.get("price").toString());
            int quantity = Integer.parseInt(temp.get("quantity").toString());

            products.add(new Product(name,price,quantity));

        }
    }

    private static FileReader getFile(String path) throws FileNotFoundException {
        return new FileReader(path);
    }



}




