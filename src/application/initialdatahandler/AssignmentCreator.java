package application.initialdatahandler;

import application.mainclasses.Assignment;

import java.time.format.DateTimeParseException;
import java.util.zip.DataFormatException;


public class AssignmentCreator implements InitialDataHandler {

    @Override
    public Assignment parseAssignment(String nextLine) throws DataFormatException {

        String[] projectInfo = nextLine.split(",");

        String employeeID = projectInfo[0];
        String projectID = projectInfo[1];
        String dateFrom = projectInfo[2];
        String dateTo = projectInfo[3];

        Assignment assignment = new Assignment(projectID);

        try {
            assignment.setAssignmentInfo(employeeID,dateFrom,dateTo);
        } catch (DataFormatException e) {
            System.out.println("It is not possible to process the data from this file because it contains" +
                    " unsupported date format!");
            fixMessage();
            throw e;
        } catch (DateTimeParseException e) {
            System.out.println("It is not possible to process the data from this file because it" +
                    " contains more than one date format!");
            fixMessage();
            throw e;
        }

        return assignment;
    }

    private static void fixMessage() {
        System.out.println("Please try again after fixing the problem or use a different file!");
    }
}
