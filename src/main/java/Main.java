import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        BasketSplitter basketSplitter = new BasketSplitter("src\\main\\resources\\config.json");
        basketSplitter.displayAllProducts();
        basketSplitter.displayAllDeliverMethods();
    }
}
