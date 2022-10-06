import java.util.LinkedHashMap;
import java.util.Set;

public class InClass_9_27_Hashmap {
    public static void main(String[] args) {
        LinkedHashMap<String,Double> prices = new LinkedHashMap<>();
        prices.put("Apples", 16.99);
        prices.put("Bananas", 12.99);
        prices.put("Hot Dogs", 15.99);

        if(prices.containsKey("Apples")) {
            System.out.printf("\n Yes we have apples at:%s", prices.get("Apples"));
        } else {
            System.out.printf("\n No got apples");
        }

        Set<String> myKeys = prices.keySet();
        for(String key : prices.keySet()) {
            Double price = prices.get(key);
            System.out.printf("\nItem:%s price:%s", key, price);
        }
        // Price increases on Bananas
        Double p = prices.get("Bananas") + 3;
        prices.put("bananas", p);
        for(String key : prices.keySet()) {
            Double price = prices.get(key);
            System.out.printf("\nItem:%s price:%s", key, price);
        }
        
        LinkedHashMap<Integer, String> parts = new LinkedHashMap<>();
        parts.put(1234, "Hammer");
        parts.put(3333, "Saw");
        
    }
}
