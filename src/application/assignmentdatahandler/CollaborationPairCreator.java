package application.assignmentdatahandler;

import application.assignmentdatahandler.overlapfinder.OverlapFinder;
import application.comparators.PairComparator;
import application.mainclasses.Assignment;
import application.mainclasses.Employee;
import application.mainclasses.Pair;

import java.time.Instant;
import java.util.*;

public class CollaborationPairCreator implements AssignmentDataHandler {

    private Map<Integer,Pair> pairs;
    private Set<List<Assignment>> assignmentPairs;
    private OverlapFinder overlapFinder;


    public CollaborationPairCreator(OverlapFinder overlapFinder) {

        this.pairs = new HashMap<>();
        this.assignmentPairs = new HashSet<>();
        this.overlapFinder = overlapFinder;
    }

    /**
     * The method uses the information from the paired assignments to create Pair objects representing employees who have
     * worked together on the same project. It also adds to the Pair objects the information about the period of
     * collaboration /in days/ between each pair of employees.
     * <p>
     * The method returns a List of all Pair objects.
     */

    @Override
    public Map<Integer,Pair> parsePair(Map<String, Assignment> assignments) {

        long period = 0;

        Instant currentInstant1 = Instant.now();
        System.out.println(currentInstant1);

        for (Map.Entry<String, Assignment> entry : assignments.entrySet()) {

            List<Employee> employeeList = entry.getValue().getAssignmentInfo().keySet().stream().toList();

            for (int firstEmplNumber = 0; firstEmplNumber < employeeList.size(); firstEmplNumber++) {

                period = 0;

                for (int secondEmplNumber = firstEmplNumber + 1; secondEmplNumber < employeeList.size(); secondEmplNumber++) {

                    period = 0;

                    Employee firstEmployee = getEmployee(employeeList, firstEmplNumber);
                    Employee secondEmployee = getEmployee(employeeList, secondEmplNumber);

                    int firstEmployeeWorkPeriods = getCount(entry, firstEmployee);
                    int secondEmployeeWorkPeriods = getCount(entry, secondEmployee);

                    period = overlapFinder.check(period, entry, firstEmployee, secondEmployee, firstEmployeeWorkPeriods, secondEmployeeWorkPeriods);

                    if (period != 0) {
                        addEmployeesPairInfo(period, firstEmployee, secondEmployee, entry.getKey());
                    }
                }
            }
        }
        return pairs;
    }

    private static Employee getEmployee(List<Employee> employeeList, int firstEmplNumber) {
        return employeeList.get(firstEmplNumber);
    }

    private static int getCount(Map.Entry<String, Assignment> assignmentEntry, Employee firstEmployee) {
        return assignmentEntry.getValue().getAssignmentInfo().get(firstEmployee).size();
    }

    private void addEmployeesPairInfo(long period, Employee firstEmployee, Employee secondEmployee, String projectID) {

        Pair newPairToBeAdd = new Pair(firstEmployee, secondEmployee);

        if (!pairs.containsKey(newPairToBeAdd.hashCode())) {
            newPairToBeAdd.addCollaborationInfo(projectID, period);
            pairs.put(newPairToBeAdd.hashCode(), newPairToBeAdd);
        } else {
            Pair existingPair = pairs.get(newPairToBeAdd.hashCode());

            existingPair.addCollaborationInfo(projectID,period);
        }
    }

}
