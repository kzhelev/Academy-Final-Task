package application.initialdatahandler;

import application.mainclasses.Assignment;

import java.util.zip.DataFormatException;

public interface InitialDataHandler {

    public Assignment parseAssignment(String nextLine) throws DataFormatException;
}
