package application.assignmentdatahandler;

import application.mainclasses.Assignment;
import application.mainclasses.Pair;

import java.util.List;
import java.util.Map;

public interface AssignmentDataHandler {

    public List<Pair> parsePair(Map<String,Assignment> assignments);
}
