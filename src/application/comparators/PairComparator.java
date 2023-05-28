package application.comparators;

import application.mainclasses.Pair;

import java.util.Comparator;

public class PairComparator implements Comparator<Pair> {

    /**
     * The method compares two Pair objects based on the total amount of the days the employees of the Pair have worked together.
     */

    @Override
    public int compare(Pair first, Pair second) {

        long firstPairTotalPeriod = calculate(first);
        long secondPairTotalPeriod = calculate(second);

        return Long.compare(secondPairTotalPeriod, firstPairTotalPeriod);
    }

    private long calculate(Pair pair) {
        return pair.getCollaborationInfo().values().stream().mapToLong(e -> e).sum();
    }
}
