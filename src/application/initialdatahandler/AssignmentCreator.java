package application.initialdatahandler;

import application.customexceptions.ParseException;
import application.mainclasses.Assignment;

import java.security.spec.ECField;
import java.time.format.DateTimeParseException;
import java.util.zip.DataFormatException;


public class AssignmentCreator implements InitialDataHandler {

    @Override
    public Assignment parseAssignment(String nextLine, int rowNumber) throws DataFormatException, ParseException {

        String[] projectInfo = nextLine.split(",");

        String employeeID = null;
        String projectID = null;
        String dateFrom = null;
        String dateTo = null;

        try {
            employeeID = projectInfo[0];
            projectID = projectInfo[1];
            dateFrom = projectInfo[2];
            dateTo = projectInfo[3];
        } catch (Exception e) {
            throw new ParseException("There is a mistake in row " + rowNumber);
        }

        Assignment assignment = new Assignment(projectID);

        try {
            assignment.setAssignmentInfo(employeeID,dateFrom,dateTo);
        } catch (DataFormatException e) {
            System.out.println("It is not possible to process the data from this file because it contains" +
                    " unsupported date format!");
            throw e;
        } catch (DateTimeParseException e) {
            System.out.println("It is not possible to process the data from this file because it" +
                    " contains more than one date format!");
            throw e;
        }

        return assignment;
    }
}
