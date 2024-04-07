import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class BasketSplitterTest {
  BasketSplitter basketSplitter = new BasketSplitter("src\\main\\resources\\config.json");
  List<String> products = new ArrayList<>();

  BasketSplitterTest() throws IOException, ParseException {
  }


  @Test
  public void shouldSplitCorrect() {
    //given
    Map<String, List<String>> excepted = new HashMap<>();
    excepted.put("Next day shipping", Arrays.asList("Cocoa Butter", "Table Cloth 54x72 White"));
    excepted.put("Express Collection", Arrays.asList("Tart - Raisin And Pecan", "Flower - Daisies", "Fond - Chocolate", "Cookies - Englishbay Wht"));
    products.add("Cocoa Butter");
    products.add("Tart - Raisin And Pecan");
    products.add("Table Cloth 54x72 White");
    products.add("Flower - Daisies");
    products.add("Fond - Chocolate");
    products.add("Cookies - Englishbay Wht");

    //when
    Map<String, List<String>> result = basketSplitter.split(products);

    //then
    Assert.assertEquals(excepted, result);
  }
}

