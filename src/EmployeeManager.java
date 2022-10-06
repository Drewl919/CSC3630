
public class EmployeeManager {
    String[] inString;

    public EmployeeManager( String[] inString ){
        this.inString = inString;
    }

    public double getAverageSalary( String empLevel ){
        double sum = 0.0;
        int count = 0;
        for(String employee : inString) {
            String[] toks = employee.split(";");
            if(toks[2].equalsIgnoreCase(empLevel)){
                sum += Double.parseDouble(toks[3]);
                count++;
            }
        }
        return (sum/count);
    }
}

class EmployeeManagerDriver {
    public static void main(String[] args) {
        String[] employees = new String[6];
        employees[0] = "001;Jose;A;20000";
        employees[1] = "002;Jan;B;15000.24";
        employees[2] = "003;Jackie;C;12000.22";
        employees[3] = "004;Jamies;A;10000.12";
        employees[4] = "005;Jeff;A;20000.01";
        employees[5] = "006;Jessie;A;90000.01";

        EmployeeManager manager = new EmployeeManager(employees);
        System.out.printf("\n A Level Average Salary: %s", manager.getAverageSalary("A"));
        System.out.printf("\n B Level Average Salary: %s", manager.getAverageSalary("B"));
        System.out.printf("\n C Level Average Salary: %s", manager.getAverageSalary("C"));
    }
}