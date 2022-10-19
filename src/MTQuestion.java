import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class MTQuestion {
    public static void main(String[] args) {
        HashMap< String, ArrayList<String>> carsColors = getCarsAndColors();
        String color = "Black";
        ArrayList<String> byColor = getCarsOfColor( carsColors, color);
        showOutput( byColor, color);
    }
    private static void showOutput(ArrayList<String> byColor, String color) {
        System.out.printf("These cars have color:%s", color);
        for(String car : byColor) {
            System.out.printf("\n  Car:%s", car);
        }
    }
    private static ArrayList<String> getCarsOfColor(HashMap<String, ArrayList<String>> carsColors, String inColor) {
        ArrayList<String> cars = new ArrayList<>();
        for(String key : carsColors.keySet()) {
            if(carsColors.get(key).contains(inColor)) {
                cars.add(key);
            }
        }
        return cars;
    }
    private static HashMap<String,ArrayList<String>> getCarsAndColors() {
        HashMap<String, ArrayList<String>> carColors = new HashMap<>();
        ArrayList<String>  rbwb = new ArrayList<String>(Arrays.asList("Red", "Blue", "White", "Black"));
        carColors.put("Accord", rbwb );
        ArrayList<String>  bw = new ArrayList<String>(Arrays.asList("Black", "White"));
        carColors.put("Encore", bw);
//        ArrayList<String>  brb = new ArrayList<String>(Arrays.asList("Blue", "Red", "Black"));
        carColors.put("Camry", bw);
//        ArrayList<String>  br = new ArrayList<String>(Arrays.asList( "Red", "Green"));
        carColors.put("Tacoma", bw);
//        ArrayList<String>  wbr = new ArrayList<String>(Arrays.asList("White", "Blue", "Red"));
        carColors.put("Corolla", bw);

        return carColors;
    }
}
