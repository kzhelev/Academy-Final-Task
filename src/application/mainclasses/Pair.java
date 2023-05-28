package application.mainclasses;

import java.util.HashMap;
import java.util.Map;

public class Pair {

    private final Employee firstEmployee;
    private final Employee secondEmployee;
    private final Map<String,Long> collaborationInfo;

    public Pair(Employee firstEmployee, Employee secondEmployee) {

        this.firstEmployee = firstEmployee;
        this.secondEmployee = secondEmployee;
        this.collaborationInfo = new HashMap<>();
    }

    public void addCollaborationInfo(String projectID,long period) {

        collaborationInfo.put(projectID,period);
    }

    public Map<String, Long> getCollaborationInfo() {

        return collaborationInfo;
    }

    public String[] getInfoProjectID() {

        return collaborationInfo.keySet().toArray(String[]::new);
    }

    public Employee getFirstEmployee() {

        return firstEmployee;
    }

    public Employee getSecondEmployee() {

        return secondEmployee;
    }

    @Override
    public boolean equals(Object anObject) {

        Pair other;

        if (anObject instanceof Pair) {
            other = (Pair) anObject;
        } else {
            return false;
        }

        if (this == anObject) {
            return true;
        }

        if (firstEmployee.compareTo(other.getFirstEmployee()) == 0 && secondEmployee.compareTo(other.getSecondEmployee()) == 0 ||
                firstEmployee.compareTo(other.getSecondEmployee()) == 0 && secondEmployee.compareTo(other.getFirstEmployee()) == 0 ) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {

        int totalPeriod = getCollaborationInfo().values().stream().mapToInt(Long::intValue).sum();

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Detailed information:\n");

        for (Map.Entry<String, Long> entry : collaborationInfo.entrySet()) {
            stringBuilder.append(String.format("Project ID: %s - %d days;\n",entry.getKey(),entry.getValue()));
        }

        return String.format("Employees who have worked together on common projects for the longest period:\nEmployee ID: %s, Employee ID: %s - total period working together: %d days.\n%s",firstEmployee.getEmployeeID(),
                secondEmployee.getEmployeeID(), totalPeriod,stringBuilder);
    }
}
