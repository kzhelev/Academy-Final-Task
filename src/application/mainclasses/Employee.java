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

        if (this == anObject) {
            return true;
        }

        if (!(anObject instanceof Employee)) {
            return false;
        }

        Employee employee = (Employee) anObject;

        return employeeID.equals(employee.employeeID);
    }
    
    @Override
    public int hashCode() {
        return Integer.parseInt(employeeID);
    }
}
