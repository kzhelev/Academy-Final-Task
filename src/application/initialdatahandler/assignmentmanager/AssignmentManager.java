package application.initialdatahandler.assignmentmanager;

import application.mainclasses.Assignment;

import java.util.Map;

public interface AssignmentManager {

    public void addToMap(Map<String, Assignment> assignments, Assignment assignment);
}
