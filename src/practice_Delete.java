import java.util.HashSet;
import java.util.LinkedHashMap;

public class practice_Delete {
    public static void main(String[] args) {
        LinkedHashMap<String, HashSet<String>> employees = new LinkedHashMap<String, HashSet<String>>();
        HashSet<String> emp1 = new HashSet<>();
        emp1.add("Lash");
        emp1.add("St Clare");
        emp1.add("Reyes");
        emp1.add("Petkus");
        employees.put("CS Faculty", emp1);
        HashSet<String> emp2 = new HashSet<>();
        emp2.add("Ron");
        emp2.add("Wyman");
        emp2.add("Jones");
        employees.put("Math Faculty", emp2);
        HashSet<String> emp3 = new HashSet<>();
        emp2.add("Jimmy");
        emp2.add("Kimmy");
        emp2.add("SLimy");
        employees.put("Staff", emp2);

        for(String group : employees.keySet()) {
            System.out.printf("\n%s\n\t", group);
                System.out.printf("%s", employees.get(group));

        }

        for(String group : employees.keySet()) {
            if(group.equals("CS Faculty") && employees.get(group).contains("Reyes")) {
                System.out.printf("Reyes is CS Faculty");
            }
        }

    }
}
