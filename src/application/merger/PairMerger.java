package application.merger;

import application.mainclasses.Pair;

import java.util.List;

public class PairMerger implements Merger {

    /**
     * Merges two objects from the Pair class that have the same set of employees and update their collaboration information.
     * If the Pair objects have the same project, their collaboration periods аре summed and saved into the first object.
     * If the two objects have different projects the information about all projects is saved into the first Pair object.
     * The second of the two merged Pair objects is removed from the list, and the resulting list, containing the first
     * Pair object with the updated collaboration information, is returned.
     */

    @Override
    public List<Pair> merge(List<Pair> pairs){

        for (int firstPairNumber = 0; firstPairNumber < pairs.size()-1; firstPairNumber++) {

            for (int secondPairNumber = firstPairNumber+1; secondPairNumber < pairs.size(); secondPairNumber++) {

                Pair firstPair = pairs.get(firstPairNumber);
                Pair secondPair = pairs.get(secondPairNumber);

                if (firstPair.equals(secondPair
                )) {

                    String secondPairProjectID = secondPair.getInfoProjectID()[0];
                    long secondPairPeriod = secondPair.getCollaborationInfo().get(secondPairProjectID);

                    if (firstPair.getCollaborationInfo().containsKey(secondPairProjectID)) {

                        long firstPairPeriod = firstPair.getCollaborationInfo().get(firstPair.getInfoProjectID()[0]);
                        firstPair.getCollaborationInfo().put(secondPairProjectID, firstPairPeriod+secondPairPeriod);

                    } else {

                        firstPair.addCollaborationInfo(secondPairProjectID, secondPairPeriod);
                    }

                    pairs.remove(secondPairNumber);
                    secondPairNumber--;
                }
            }
        }

        return pairs;
    }
}
