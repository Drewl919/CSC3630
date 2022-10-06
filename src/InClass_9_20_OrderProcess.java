import lib.FileIO;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class InClass_9_20_OrderProcess {
    public static void main(String[] args) throws FileNotFoundException {
        String fName = "data/order_status.csv";
        FileIO fio = new FileIO(fName);
        fio.setFileData();
        ArrayList<String> inLines = fio.getFileData();
        System.out.printf("\n len:%s", inLines.size());
        ArrayList<OrderItem> items = creatOrderItems(inLines);
        System.out.printf("\n GOT %s structured items", items.size());

        OrderManager_InClass om = new OrderManager_InClass(items);
        ArrayList<OrderItem> retItems = om.findOrder(1234);
        System.out.printf("\nGot items for 1234: size:%s", retItems.size());
        ArrayList<OrderItem> retItems2 = om.findOrder(12345);
        System.out.printf("\nGot items for 1234: size:%s", retItems2.size());
        if(om.gotThisOrder(1234)) {
            System.out.printf("\n Got order 1234");
        } else System.out.printf("\n No got 1234");

    }

    private static ArrayList<OrderItem> creatOrderItems(ArrayList<String> inLines) {
        ArrayList<OrderItem> oItems = new ArrayList<>();
        boolean firstLine = true;
        for(String line : inLines) {
            if(firstLine) {
                firstLine = false;
                continue;
            }
            String[] toks = line.split(";");
            try {
                int oId = Integer.parseInt(toks[ 0 ]);
                int lId = Integer.parseInt(toks[ 1 ]);
                int pId = Integer.parseInt(toks[ 2 ]);
                int quant = Integer.parseInt(toks[ 3 ]);
                String status = toks[ 4 ];
                double value = Double.parseDouble(toks[ 5 ]);
                oItems.add(new OrderItem(oId, lId, pId, quant, status, value));
            } catch (Exception e) {
                System.out.printf("\n ooooooooooPPPPPPPPPSSSS Helo DO SOMETHING!");
            }
        }
        return oItems;
    }
}
