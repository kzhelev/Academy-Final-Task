package application.assignmentdatahandler.overlapfinder;

import application.assignmentdatahandler.overlapcalculator.OverlapCalculator;
import application.mainclasses.Assignment;
import application.mainclasses.Employee;
import application.mainclasses.WorkPeriod;

import java.time.LocalDate;
import java.util.Map;

public class SimpleOverlapFinder implements OverlapFinder {

    private OverlapCalculator calculator;

    public SimpleOverlapFinder(OverlapCalculator calculator) {

        this.calculator = calculator;
    }


    /**
     * Passes through all work periods of a pair of employees and return the total collaboration period in days.
     */

    @Override
    public long check(long period, Map.Entry<String, Assignment> assignmentEntry, Employee firstEmployee, Employee secondEmployee,
                      int firstEmployeeWorkPeriodsCount, int secondEmployeeWorkPeriodsCount) {

        for (int firstEmplWorkPeriod = 0; firstEmplWorkPeriod < firstEmployeeWorkPeriodsCount; firstEmplWorkPeriod++) {

            for (int secondEmplWorkPeriod = 0; secondEmplWorkPeriod < secondEmployeeWorkPeriodsCount; secondEmplWorkPeriod++) {

                WorkPeriod firstOneWorkPeriod = assignmentEntry.getValue().getAssignmentInfo().get(firstEmployee).get(firstEmplWorkPeriod);
                WorkPeriod secondOneWorkPeriod = assignmentEntry.getValue().getAssignmentInfo().get(secondEmployee).get(secondEmplWorkPeriod);

                LocalDate employeeOneStartDate = firstOneWorkPeriod.getDateFrom();
                LocalDate employeeOneEndDate = firstOneWorkPeriod.getDateTo();

                LocalDate employeeTwoStartDate = secondOneWorkPeriod.getDateFrom();
                LocalDate employeeTwoEndDate = secondOneWorkPeriod.getDateTo();

                //Check if there is an overlap between two work periods.
                if (employeeOneStartDate.isBefore(employeeTwoEndDate) && employeeOneEndDate.isAfter(employeeTwoStartDate)) {
                    period += calculator.calculateOverlap(employeeOneStartDate, employeeOneEndDate, employeeTwoStartDate, employeeTwoEndDate);
                }
            }
        }
        return period;
    }
}
