package application;

import application.assignmentdatahandler.AssignmentDataHandler;
import application.assignmentdatahandler.CollaborationPairCreator;
import application.assignmentdatahandler.overlapcalculator.OverlapCalculator;
import application.assignmentdatahandler.overlapcalculator.SimpleCalculator;
import application.assignmentdatahandler.overlapfinder.OverlapFinder;
import application.assignmentdatahandler.overlapfinder.SimpleOverlapFinder;
import application.comparators.PairComparator;
import application.initialdatahandler.AssignmentCreator;
import application.initialdatahandler.InitialDataHandler;
import application.initialdatahandler.assignmentmanager.AssignmentManager;
import application.initialdatahandler.assignmentmanager.SimpleAssignmentManager;
import application.mainclasses.Assignment;
import application.mainclasses.Pair;
import application.merger.Merger;
import application.merger.PairMerger;
import application.reader.Reader;
import application.reader.ReaderDefiner.ReaderDefiner;

import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.zip.DataFormatException;

/**
 * A class that gathers and executes the logic of the application.
 * <p>
 * Has only one public method "execute()".
 */

public class Engine {

    private Reader reader;
    private InitialDataHandler initialDataHandler;
    private Map<String, Assignment> assignments;
    private AssignmentDataHandler assignmentDataHandler;
    private List<Pair> pairs;
    private Merger pairMerger;
    private Comparator<Pair> pairComparator;
    private AssignmentManager assignmentManager;
    private ReaderDefiner readerDefiner;
    private OverlapFinder overlapFinder;
    private OverlapCalculator overlapCalculator;


    public Engine() {

        this.readerDefiner = new ReaderDefiner();
        setReader();
        this.initialDataHandler = new AssignmentCreator();
        this.assignments = new HashMap<>();
        this.overlapCalculator = new SimpleCalculator();
        this.overlapFinder = new SimpleOverlapFinder(overlapCalculator);
        this.assignmentDataHandler = new CollaborationPairCreator(overlapFinder);
        this.pairs = new ArrayList<>();
        this.pairMerger = new PairMerger();
        this.pairComparator = new PairComparator();
        this.assignmentManager = new SimpleAssignmentManager();
    }

    /**
     * The method takes a string as an input /file path/ and set a reader for the specified file.
     * <p>
     * Supported file types: .CSV .TXT
     * <p>
     * Throws a RuntimeException with an error message "The file ... is not found!" if the file is not found.
     * Throws a RuntimeException with an error message "Illegal file extension!" if the file extension is not supported.
     * <p>
     * If the file path is not valid or the file extension is not supported, the user is prompted to enter a new file path
     * until a valid file is found.
     */

    private void setReader() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter filepath here:");

        boolean isDefined = false;

        while (!isDefined) {
            try {
                String filepath = scanner.nextLine();
                this.reader = readerDefiner.define(filepath);
                isDefined = true;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("Enter new filepath:");
            }
        }
    }


    public void execute() {

        // Reads the file line by line and with the information from every line creates an Assignment object that adds to
        // a Map of assignments.
        createListOfAssignmentsFromFileInfo();

        // Takes the assignments, analise the data from them and creates a list of pairs.
        pairs = assignmentDataHandler.parsePair(assignments);

        //Merges the pairs that have the same set of employees in them.
        pairs = pairMerger.merge(pairs);

        // Sorts the list in descending order based on the total amount of days the employees of the Pair have worked together.
        pairs.sort(pairComparator);

        printLongestWorkingTogetherPair();
    }

    private void createListOfAssignmentsFromFileInfo() {
        while (reader.hasNextLine()) {

            Assignment assignment = null;

            try {
                assignment = initialDataHandler.parseAssignment(reader.nextLine());
            } catch (DataFormatException | DateTimeParseException e) {
                assignments.clear();
                setReader();
                continue;
            }

            assignmentManager.addToMap(assignments, assignment);
        }

        reader.close();
    }

    private void printLongestWorkingTogetherPair() {

            System.out.println(pairs.get(0));
    }
}
