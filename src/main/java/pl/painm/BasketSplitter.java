package pl.painm;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class BasketSplitter {
    
    private final Map<String, List<String>> productDeliveryMap;
    
    public BasketSplitter(String absolutePathToConfigFile) throws IOException, ParseException {
        this.productDeliveryMap = loadConfig(absolutePathToConfigFile);
    }

    private Map<String, List<String>> loadConfig(String absolutePathToConfigFile) throws IOException, ParseException {
        Map<String, List<String>> configMap = new HashMap<>();

        JSONParser parser = new JSONParser();
        JSONObject configJson = (JSONObject) parser.parse(new FileReader(absolutePathToConfigFile));

        for (Object key : configJson.keySet()) {
            String productName = (String) key;
            JSONArray deliveriesArray = (JSONArray) configJson.get(productName);

            List<String> deliveries = new ArrayList<>();
            for (Object deliveryObj : deliveriesArray) {
                deliveries.add((String) deliveryObj);
            }

            configMap.put(productName, deliveries);
        }

        return configMap;
    }

    public void displayAllProducts(){
        System.out.println("Display All Available products: ");
        for (Map.Entry<String, List<String>> entry : productDeliveryMap.entrySet()) {
            String key = entry.getKey();
            System.out.println(key);

        }
    }

    public void displayAllDeliverMethods(){
        System.out.println("Display All Deliver Methods:");
        Set<String> deliverMethods = new HashSet<>();
        for (Map.Entry<String, List<String>> entry : productDeliveryMap.entrySet()) {
            List<String> values = entry.getValue();
            deliverMethods.addAll(values);
        }
        for (String value: deliverMethods
             ) {
            System.out.println(value);
        }
    }

    public Map<String, List<String>> split(List<String> items) {
        Map<String, List<String>> deliveryGroups = new HashMap<>();

        for (String item : items) {
            boolean added = false;

            List<String> availableDeliveries = productDeliveryMap.getOrDefault(item, new ArrayList<>());

            for (String delivery : availableDeliveries) {

                if (deliveryGroups.containsKey(delivery)) {
                    deliveryGroups.get(delivery).add(item);
                    added = true;
                    break;
                }
            }
            if (!added && !availableDeliveries.isEmpty()) {
                String delivery = availableDeliveries.get(0);
                List<String> newGroup = new ArrayList<>();
                newGroup.add(item);
                deliveryGroups.put(delivery, newGroup);
            }
        }

        return deliveryGroups;
    }
}
