package application.merger;

import application.mainclasses.Pair;

import java.util.List;

/**
 * An interface that defines a merge method for pairs.
 */

public interface Merger {

    public List<Pair> merge(List<Pair> pairs);
}
