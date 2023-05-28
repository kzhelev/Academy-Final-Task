package application.assignmentdatahandler.overlapcalculator;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class SimpleCalculator implements OverlapCalculator {

    @Override
    public long calculateOverlap(LocalDate employeeOneStartDate, LocalDate employeeOneEndDate, LocalDate employeeTwoStartDate, LocalDate employeeTwoEndDate) {

        long period = 0;

        LocalDate laterStartingDate = employeeOneStartDate.isBefore(employeeTwoStartDate) ? employeeTwoStartDate : employeeOneStartDate;

        LocalDate earlieEndDate = employeeOneEndDate.isBefore(employeeTwoEndDate) ? employeeOneEndDate : employeeTwoEndDate;

        period = calculateWorkDaysOverlap(laterStartingDate, earlieEndDate);

        return period;
    }

    private static long calculateWorkDaysOverlap(LocalDate laterStartingDate, LocalDate earlieEndDate) {
        long period;
        long daysUntilSaturday = 0;

        boolean isSunday = false;

        if (laterStartingDate.getDayOfWeek() == DayOfWeek.SUNDAY) {
            isSunday = true;
        }

        while (laterStartingDate.getDayOfWeek() != DayOfWeek.SATURDAY) {

            daysUntilSaturday++;

            laterStartingDate = laterStartingDate.plusDays(1);
        }

        long daysBetweenTheDates = laterStartingDate.until(earlieEndDate, ChronoUnit.DAYS);

        long weeks = daysBetweenTheDates / 7;

        long remainder =  daysBetweenTheDates % 7;

        long daysToSubtract = 0;

        if (remainder == 1) {
            daysToSubtract = 1;
        } else if (remainder > 1) {
            daysToSubtract = 2;
        }

        period = daysUntilSaturday + (weeks) * 5 + remainder - daysToSubtract;

        if(isSunday) {
            period--;
        }
        return period;

    }
}
