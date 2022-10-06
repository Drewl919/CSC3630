import lib.DBAbstract;

import java.util.ArrayList;
import java.util.HashMap;

public class inClass_10_4_DBStuff {
    public static void main(String[] args) {
        String pwFile = "input/pw.txt";
        String dbName = "45.55.136.114:3306/csc3610";
        DBAbstract db = new DBAbstract(dbName, pwFile);
        HashMap<String, ArrayList<Auto>> autos = getDataFromDB2(db);
        System.out.printf("\nDid this work?------------");
        for(String key : autos.keySet()) {
            ArrayList<Auto> cars = autos.get(key);
            for(Auto car : cars) {
                System.out.printf("\n key:%s  Auto:%s", key, car.toString());
            }
        }
        String qKey = "Hona:Accord";
        if(autos.containsKey(qKey)) {
            System.out.printf("\n -------------Auto:%s", autos.get(qKey).toString());
        } else {
            System.out.printf("Don't got the key:%s", qKey);
        }
    }

    private static HashMap<String,Auto> getDataFromDB(DBAbstract db) {
        String sql = "Select  make, model,  description, car_condition, color from cars order by make";
        ArrayList<String> carStrRows = db.doQueryAL(sql);
        // Let try to show it
        HashMap<String, Auto> retData = new HashMap<>();
        for(String row : carStrRows) {
//            System.out.printf("\nRow:%s", row);
            String[] toks = row.split(";");
            Auto a = new Auto(toks[0], toks[1], toks[2], toks[3], toks[4]);
            String key = toks[0] + ':' + toks[1];
            retData.put(key, a);

        }

        return retData;
    }

    private static HashMap<String,ArrayList<Auto>> getDataFromDB2(DBAbstract db) {
        String sql = "Select  make, model,  description, car_condition, color from cars order by make";
        ArrayList<String> carStrRows = db.doQueryAL(sql);
        // Let try to show it
        HashMap<String, ArrayList<Auto>> retData = new HashMap<>();
        for(String row : carStrRows) {
//            System.out.printf("\nRow:%s", row);
            String[] toks = row.split(";");
            Auto a = new Auto(toks[0], toks[1], toks[2], toks[3], toks[4]);
            String key = toks[0] + ':' + toks[1];
            if(retData.containsKey(key)) {
                ArrayList<Auto> autos = retData.get(key);
                autos.add(a);
                retData.put(key, autos);
            } else {
                ArrayList<Auto> autos = new ArrayList<>();
                autos.add(a);
                retData.put(key, autos);
            }
        }

        return retData;
    }
}
