import lib.FileIO;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class InClass_9_27_BlockedDomains {
    public static void main(String[] args) {
        String fName = "data/blockedDomains.txt";
        ArrayList<String> inLines = getBlockedDomains(fName);
        System.out.printf("\n Size:%s", inLines.size());
        TreeSet<String> bDomains = convertToHash(inLines);
        System.out.printf("\n Size:%s", bDomains.size());
        Boolean keepGoing = true;
        while (keepGoing) {
            String uIn = getUserInput();
            if(uIn.equalsIgnoreCase("STOP")) {
                keepGoing = false;
            }
            if(bDomains.contains(uIn)) {
                System.out.printf("\n That is not good:%s", uIn);
            } else {
                System.out.printf("\n That is OK:%s", uIn);
            }
        }
        showMeTheList(bDomains);

    }

    private static void showMeTheList(TreeSet<String> bDomains) {
        for (String d : bDomains) {
            System.out.printf("\nDomain: %s", d);
        }
    }

    private static String getUserInput() {
        System.out.printf("\n Enter Domain to check (or STOP): ");
        Scanner s = new Scanner(System.in);
        return s.nextLine();
    }

    private static TreeSet<String> convertToHash(ArrayList<String> inLines) {
        TreeSet<String> bDom = new TreeSet<>();
        for(String line : inLines) {
            bDom.add(line);
        }
        return bDom;
    }

    private static ArrayList<String> getBlockedDomains(String fName) {
        FileIO fio = new FileIO(fName);
        try {
            fio.setFileData();
        } catch (Exception e) {
            System.out.printf("\n fName: %s problem", fName);
            System.out.printf("\n Exception:%s", e.getMessage());
            System.exit(1);
        }
        ArrayList<String> retLines = fio.getFileData();
        return retLines;
    }
}
