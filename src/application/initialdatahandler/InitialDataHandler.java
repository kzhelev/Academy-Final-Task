package application.initialdatahandler;

import application.customexceptions.ParseException;
import application.mainclasses.Assignment;

import java.util.zip.DataFormatException;

public interface InitialDataHandler {

    public Assignment parseAssignment(String nextLine, int rowNumber) throws DataFormatException, ParseException;
}
