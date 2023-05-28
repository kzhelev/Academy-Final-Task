package application.initialdatahandler.assignmentmanager;

import application.mainclasses.Assignment;
import application.mainclasses.Employee;
import application.mainclasses.WorkPeriod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SimpleAssignmentManager implements AssignmentManager {

    @Override
    public void addToMap(Map<String, Assignment> assignments, Assignment assignment) {

        if (!assignments.containsKey(assignment.getProjectID())) {

            assignments.put(assignment.getProjectID(), assignment);

        } else {

            Map<Employee, List<WorkPeriod>> assignmentInfo = assignments.get(assignment.getProjectID()).getAssignmentInfo();

            if (!assignmentInfo.containsKey(assignment.getFirstEmployee())) {
                assignmentInfo.put(assignment.getFirstEmployee(), new ArrayList<>(Arrays.asList(assignment.getFirstWorkPeriod())));
            } else {
                assignmentInfo.get(assignment.getFirstEmployee()).add(assignment.getFirstWorkPeriod());
            }

        }
    }
}
