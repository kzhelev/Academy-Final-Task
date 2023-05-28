package application.assignmentdatahandler.overlapcalculator;

import java.time.LocalDate;

public interface OverlapCalculator {

    public long calculateOverlap(LocalDate employeeOneStartDate, LocalDate employeeOneEndDate,
                                 LocalDate employeeTwoStartDate, LocalDate employeeTwoEndDate);
}
