import java.util.ArrayList;

public class AllStarBaseball {

    public static void main(String[] args) {
        BattingOrder battingOrder = getPlayers();
        ArrayList<Innings> innings = new ArrayList<>();
        int inning = 1;
        int gameScore = 0;
        while (inning<10) {
            Innings currentInning = new Innings(inning);
            System.out.printf("\n\n------------ Inning: %s - Game Score: %s Runs ------------", inning, gameScore);
            int outs = 0;
            int batter = 1;
            int hits = 0;
            while (outs<3) {
                double randomNumber = getRandomNumber();
                Players upToBat = battingOrder.getUpBat();
                if((randomNumber/100) < upToBat.homeRunAvg) {
                    currentInning.setHomeRuns(currentInning.getHomeRuns() + 1);
                    currentInning.setHits(currentInning.getHits() + 1);
                    currentInning.setRuns(currentInning.getRuns() + hits + 1);
                    System.out.printf("\n - Batter %s - %s -> BA: %s  Random Number: %s HOME RUN: %s Runs Scored", batter++, upToBat.name, upToBat.battingAvg, randomNumber, ++hits);
                    hits = 0;
                } else if((randomNumber/100) < upToBat.battingAvg) {
                    currentInning.setHits(currentInning.getHits() + 1);
                    hits++;
                    if(hits == 3) {
                        hits--;
                        currentInning.setRuns(currentInning.getRuns()+1);
                    }
                    System.out.printf("\n - Batter %s - %s -> BA: %s  Random Number: %s HIT!", batter++, upToBat.name, upToBat.battingAvg, randomNumber);
                } else {
                    outs++;
                    System.out.printf("\n - Batter %s - %s -> BA: %s  Random Number: %s Out: %s", batter++, upToBat.name, upToBat.battingAvg, randomNumber, outs);
                }
            }
            System.out.printf("\n------------ Inning Totals: %s Runs %s Hits ------------", currentInning.getRuns(), currentInning.getHits());
            inning++;
            gameScore += currentInning.getRuns();
            innings.add(currentInning);
        }
        System.out.printf("\n\n---------- Game Over - Game Score: %s Runs", gameScore);
        for(Innings displayInning : innings) {
            System.out.printf("\n Inning %s -- %s Hits   %s Home Runs   %s Runs", displayInning.getInning(), displayInning.getHits(), displayInning.getHomeRuns(), displayInning.getRuns());
        }


    }

    private static double getRandomNumber() {
        double min = 1.0;
        double max = 100.0;
        return Math.floor(Math.random()*(max-min+1)+min);
    }

    private static BattingOrder getPlayers() {
        BattingOrder battingOrder = new BattingOrder();
        battingOrder.addNode(battingOrder.head, new Players("Ted Williams", 0.344, 0.0687));
        battingOrder.addNode(battingOrder.head, new Players("Roger Hornsby", 0.359, 0.0375));
        battingOrder.addNode(battingOrder.head, new Players("Mark Mcgwire", 0.265, 0.095));
        battingOrder.addNode(battingOrder.head, new Players("Babe Ruth", 0.340, 0.085));
        return battingOrder;
    }
}

class Innings {
    private int inning = 0;
    private int hits = 0;
    private int homeRuns = 0;
    private int runs = 0;

    public Innings(int inning) {
        this.inning = inning;
        this.hits = 0;
        this.homeRuns = 0;
        this.runs = 0;
    }

    public int getInning() {
        return inning;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public int getHomeRuns() {
        return homeRuns;
    }

    public void setHomeRuns(int homeRuns) {
        this.homeRuns = homeRuns;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    @Override
    public String toString() {
        return String.format("Inning %s - %s Hits  %s HR  %s runs", inning, hits, homeRuns, runs);
    }
}

class Players {
    public String name;
    public double battingAvg;
    public double homeRunAvg;
    public Players next = null;

    Players(String name, double battingAvg, double homeRunAvg) {
        this.name = name;
        this.battingAvg = battingAvg;
        this.homeRunAvg = homeRunAvg;
    }
}

class BattingOrder {
    Players head = null;
    int size = 0;

    public void addNode(Players head, Players newPlayer) {
        if (size == 0) {
            this.head = newPlayer;
            this.head.next = null;
            this.size = 1;
        } else {
            while (head.next != null) {
                head = head.next;
            }
            head.next = newPlayer;
            head.next.next = null;
        }
    }

    public Players getUpBat() {
        Players upBat = head;
        head = head.next;
        addNode(head, upBat);
        return upBat;
    }
}