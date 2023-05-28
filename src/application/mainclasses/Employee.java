package application.mainclasses;

public class Employee implements Comparable<Employee> {

    private final String employeeID;

    public Employee(String employeeId) {

        this.employeeID = employeeId;
    }

    public String getEmployeeID() {

        return employeeID;
    }

    @Override
    public int compareTo(Employee other) {

        return employeeID.compareTo(other.getEmployeeID());
    }

    @Override
    public boolean equals(Object anObject) {

        Employee employee;

        if (anObject instanceof Employee) {
            employee = (Employee) anObject;
        } else {
            return false;
        }

        if (this == anObject) {
            return true;
        }

        return compareTo(employee) == 0;
    }
    
    @Override
    public int hashCode() {
        return 31 * employeeID.hashCode();
    }
}
