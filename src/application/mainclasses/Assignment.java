package application.mainclasses;

import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.zip.DataFormatException;

public class Assignment implements Comparable<Assignment> {

    private Project project;
    private Map<Employee, List<WorkPeriod>> assignmentInfo;

    public Assignment(String projectID) {

        this.project = new Project(projectID);
        this.assignmentInfo = new HashMap<>();
    }

    public void setAssignmentInfo(String employeeId, String dateFrom, String dateTo) throws DataFormatException, DateTimeParseException {

        assignmentInfo.put(new Employee(employeeId), new ArrayList<>(Arrays.asList(new WorkPeriod(dateFrom, dateTo))));
    }

    public String getProjectID() {

        return project.getProjectID();
    }

    public Map<Employee, List<WorkPeriod>> getAssignmentInfo() {

        return assignmentInfo;
    }

    public Employee getFirstEmployee() {

        return assignmentInfo.keySet().stream().findFirst().orElse(null);
    }

    public List<WorkPeriod> getWorkPeriods(Employee employee) {

        return assignmentInfo.get(employee);
    }

    public WorkPeriod getFirstWorkPeriod() {

        return getWorkPeriods(getFirstEmployee()).get(0);
    }


    @Override
    public int compareTo(Assignment other) {

        return this.getProjectID().compareTo(other.getProjectID());
    }
}
