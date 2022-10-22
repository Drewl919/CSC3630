import lib.FileIO;

import java.io.FileNotFoundException;
import java.util.*;

public class TrucksInAnAlley {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Truck> trucks = getTrucksFromFile();
        Scanner s = new Scanner(System.in);
        String currentList = String.format("\n---- Showing the Current alley of Trucks ----");
        String mustMove = "---- Showing trucks that must move first ----";
        while (true) {
            showTrucks(trucks, currentList);
            System.out.printf("\nEnter TruckID to Remove (%s) or Q->", getTruckIdsArray(trucks));
            String input = s.next();
            if (input.equalsIgnoreCase("q")) {
                break;
            }
            boolean gotTruck = haveTruck(input, trucks);
            if (gotTruck) {
                int truckID = Integer.parseInt(input);
                ArrayList<Truck> mustMoveTrucks = removeTruck(trucks, truckID);
                if (mustMoveTrucks.size() != 0) {
                    System.out.printf("\nYou must move these trucks first...");
                    showTrucks(mustMoveTrucks, mustMove);
                }
            }
        }
    }

    private static ArrayList<Truck> removeTruck(ArrayList<Truck> trucks, int truckID) {
        ArrayList<Truck> mustMoveTrucks = new ArrayList<>();
        for (int i = 0; i < trucks.size(); i++) {
            if (trucks.get(i).getId() == truckID) {
                trucks.remove(i);
                break;
            } else {
                mustMoveTrucks.add(trucks.get(i));
            }
        }
        return mustMoveTrucks;
    }

    private static boolean haveTruck(String input, ArrayList<Truck> trucks) {
        boolean gotTruck = false;
        try {
            int truckID = Integer.parseInt(input);
            if (getTruckIdsArray(trucks).contains(truckID)) {
                gotTruck = true;
            }
            if (!gotTruck) {
                System.out.printf("\nTry again, id:%s not found.", truckID);
            }
        } catch (Exception e) {
            System.out.printf("\n\nInvalid input try again.");
        }
        return gotTruck;
    }

    private static ArrayList<Integer> getTruckIdsArray(ArrayList<Truck> trucks) {
        ArrayList<Integer> truckIds = new ArrayList<>();
        for (Truck truck : trucks) {
            truckIds.add(truck.getId());
        }
        Collections.sort(truckIds);
        return truckIds;
    }

    private static void showTrucks(ArrayList<Truck> trucks, String text) {
        System.out.printf("\n%s", text);
        for (Truck truck : trucks) {
            System.out.printf("\n %s", truck.toString());
        }
    }

    private static ArrayList<Truck> getTrucksFromFile() throws FileNotFoundException {
        Deque<Truck> tmpTrucks = new ArrayDeque<>();
        FileIO fio = new FileIO("data/truckOrder.txt");
        fio.setFileData();
        ArrayList<String> inLines = fio.getFileData();
        boolean firstLine = true;
        for (String line : inLines) {
            if (firstLine) {
                firstLine = false;
                continue;
            }
            String[] toks = line.split(",");
            try {
                int id = Integer.parseInt(toks[0]);
                int zip = Integer.parseInt(toks[1]);
                int packages = Integer.parseInt(toks[2]);
                tmpTrucks.push(new Truck(id, zip, packages));
            } catch (Exception e) {
                System.out.printf("\n Invalid input");
            }
        }
        ArrayList<Truck> trucks = new ArrayList<>();
        while (!tmpTrucks.isEmpty()) {
            trucks.add(tmpTrucks.pop());
        }
        return trucks;
    }
}

class Truck {
    private int id;
    private int zip;
    private int packages;

    public Truck(int id, int zip, int packages) {
        this.id = id;
        this.zip = zip;
        this.packages = packages;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Truck id:" + id + "  Zip:" + zip + "  Number of Packages:" + packages;
    }
}