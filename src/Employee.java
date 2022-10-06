
public class Employee implements  Comparable<Employee> {
    private int employId;
    private String name;
    private Double salary;

    public Employee(int employId, String name, Double salary) {
        this.employId = employId;
        this.name = name;
        this.salary = salary;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("Emp Id");
        sb.append( this.employId);
        sb.append( "--Name-- " + this.name);
        sb.append( "--Salary-- " + this.salary);
        return sb.toString();
    }

    public int getEmployId() {
        return employId;
    }

    public void setEmployId(int employId) {
        this.employId = employId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    // Two Employees are equal if their IDs are equal
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return this.getEmployId() == employee.getEmployId();
    }
    @Override
    public int compareTo(Employee employee) {
            return this.getEmployId() - employee.getEmployId();
    }
}
