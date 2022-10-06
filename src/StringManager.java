
public class StringManager {
    private String[] myStringList;

    public StringManager(String[] myStringList) {
        this.myStringList = myStringList;
    }

    public int howManyOfThis(char inChar){
        int count = 0;
        for(String item : myStringList) {
            for(char token : item.toLowerCase().toCharArray()) {
                if(token == inChar) {
                    count++;
                }
            }
        }
        return count;
    }

    public int countOlderThan(int inYear) {
        int ct = 0;
        for(String actor : myStringList) {
            String[] toks = actor.split(";");
            try {
                int bd = Integer.parseInt(toks[ 3 ]);
                if (bd < inYear) {
                    ct++;
                }
            } catch (Exception e) {
                System.out.printf("\n Illegal Line:%s", actor);
            }
        }
        return ct;
    }

    public int numBornBefore(int inYear) {
        int count = 0;
        for(String actor : myStringList) {
            String[] toks = actor.split(";");
            try {
                int birthYear = Integer.parseInt(toks[3]);
                if(birthYear < inYear) {
                    count++;
                }
            } catch (Exception e) {
                System.out.printf("\n Illegal Line:%s", actor);
            }
        }
        return count;
    }
}