package application.assignmentdatahandler.overlapfinder;

import application.mainclasses.Assignment;
import application.mainclasses.Employee;

import java.util.Map;

public interface OverlapFinder {

    public long check(long period, Map.Entry<String, Assignment> assignmentEntry, Employee firstEmployee, Employee secondEmployee,
                      int firstEmployeeWorkPeriods, int secondEmployeeWorkPeriods);
}
