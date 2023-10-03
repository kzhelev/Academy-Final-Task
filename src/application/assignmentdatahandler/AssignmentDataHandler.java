package application.assignmentdatahandler;

import application.mainclasses.Assignment;
import application.mainclasses.Pair;

import java.util.Map;
import java.util.Set;

public interface AssignmentDataHandler {


    public Map<Integer,Pair> parsePair(Map<String,Assignment> assignments);
}
