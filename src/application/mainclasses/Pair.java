package application.mainclasses;

import java.util.Map;
import java.util.TreeMap;

public class Pair implements Comparable<Pair>{

    private final Employee firstEmployee;
    private final Employee secondEmployee;
    private final Map<String,Long> collaborationInfo;

    public Pair(Employee firstEmployee, Employee secondEmployee) {

        this.firstEmployee = firstEmployee;
        this.secondEmployee = secondEmployee;
        this.collaborationInfo = new TreeMap<>();
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

        if (this == other) {
            return true;
        }

        return firstEmployee.equals(other.getFirstEmployee()) && secondEmployee.equals(other.getSecondEmployee()) ||
                firstEmployee.equals(other.getSecondEmployee()) && secondEmployee.equals(other.getFirstEmployee());
    }

    @Override
    public int hashCode() {

         int smallerID = Math.min(Integer.parseInt(firstEmployee.getEmployeeID()),Integer.parseInt(secondEmployee.getEmployeeID()));
         int biggerID = Math.max(Integer.parseInt(firstEmployee.getEmployeeID()),Integer.parseInt(secondEmployee.getEmployeeID()));

         int result = 17;
         result = 31 * result + smallerID;
         result = 31 * result + biggerID;
         return result;
    }

    @Override
    public String toString() {

        int totalPeriod = getCollaborationInfo().values().stream().mapToInt(Long::intValue).sum();

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Detailed information:\n");

        for (Map.Entry<String, Long> entry : collaborationInfo.entrySet()) {
            stringBuilder.append(String.format("Project ID: %s - %d days;\n",entry.getKey(),entry.getValue()));
        }

        return String.format("Employee ID: %s, Employee ID: %s - total period working together: %d days.\n%s",firstEmployee.getEmployeeID(),
                secondEmployee.getEmployeeID(), totalPeriod,stringBuilder);
    }

    @Override
    public int compareTo(Pair other) {
        if (firstEmployee.compareTo(other.getFirstEmployee()) == 0 && secondEmployee.compareTo(other.getSecondEmployee()) == 0) {
            return 0;
        } else if (firstEmployee.compareTo(other.getSecondEmployee()) == 0 && secondEmployee.compareTo(other.getFirstEmployee()) == 0) {
            return 0;
        } else {
            if (firstEmployee.compareTo(other.getFirstEmployee()) != 0) {
                return firstEmployee.compareTo(other.getFirstEmployee());
            } else {
                return secondEmployee.compareTo(other.getSecondEmployee());
            }
        }
    }

    private long calculateTotalPeriod(Pair pair) {
        return pair.getCollaborationInfo().values().stream().mapToLong(e -> e).sum();
    }
}
