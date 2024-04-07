package pl.painm;

import org.json.simple.parser.ParseException;
import pl.painm.BasketSplitter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        List<String> products = new ArrayList<>();
        products.addAll(Arrays.asList("Fond - Chocolate", "Chocolate - Unsweetened", "Nut - Almond, Blanched, Whole", "Haggis", "Mushroom - Porcini Frozen", "Cake - Miini Cheesecake Cherry", "Sauce - Mint", "Longan", "Bag Clear 10 Lb", "Nantucket - Pomegranate Pear", "Puree - Strawberry", "Numi - Assorted Teas", "Apples - Spartan", "Garlic - Peeled", "Cabbage - Nappa", "Bagel - Whole White Sesame", "Tea - Apple Green Tea"));
        BasketSplitter basketSplitter = new BasketSplitter("src\\main\\resources\\config.json");
        System.out.println(basketSplitter.split(products));
        //basketSplitter.displayAllProducts();
        //basketSplitter.displayAllDeliverMethods();
    }
}
