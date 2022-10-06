import lib.FileIO;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class InClass_9_29_SurveySummary {
    public static void main(String[] args) {
        String fname = "data/surveyResults.txt";
        FileIO fio = new FileIO(fname);
        ArrayList<String> inLines = null;
        try {
            fio.setFileData();
            inLines = fio.getFileData();
        } catch (Exception e) {
            System.out.printf("\nCannot open file:%s", fname);
            System.out.printf("\nMsg:%s", e.getMessage());
            System.exit(1);
        }
//        System.out.printf("\nSize:%s", inLines.size());
        int field = 0;
        LinkedHashMap<String, Integer> theCounts = CountItems(inLines, field);
        showCounts(theCounts);
        System.out.printf("\n------------------------------------");
        int field2 = 1;
        LinkedHashMap<String, Integer> theCounts2 = CountItems(inLines, field2);
        showCounts(theCounts2);
    }

    private static void showCounts(LinkedHashMap<String, Integer> theCounts) {
        for(String key : theCounts.keySet()) {
            System.out.printf("\n For K:%s Ct:%s", key, theCounts.get(key));
        }
    }

    private static LinkedHashMap<String, Integer> CountItems(ArrayList<String> inLines, int field) {
        LinkedHashMap<String, Integer> theCounts = new LinkedHashMap<>();
        for(String line : inLines) {
            String[] toks = line.split(",");
            if(field > toks.length) {
                throw new IndexOutOfBoundsException("Wow field too big" + field);
            }
            String item = toks[field];
            if(!theCounts.containsKey(item)) {
                theCounts.put(item, 1);
            } else {
                int ct = theCounts.get(item);
                ct += 1;
                theCounts.put(item, ct);
            }
        }
        return theCounts;
    }
}
