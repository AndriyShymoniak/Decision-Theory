package com.shymoniak.model.lab3;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class CondorcetVotingVotingMethod extends VotingMethodParent {

    public void findBestCandidate() {
        ArrayList<CandidatePairs> candidatePairs = new ArrayList<>();
        for (int i = 0; i < candidatesMatrix.length; i++) {
            for (int j = 0; j < candidatesMatrix[0].length; j++) {
                for (int k = 1; k < candidatesMatrix[0].length; k++) {
                    if ((j + k) < candidatesMatrix[0].length) {
                        candidatePairs.add(new CandidatePairs(votingNumbers[i], candidatesMatrix[i][j],
                                                                candidatesMatrix[i][j + k]));
                    }
                }
            }
        }
        candidatePairs = addSimilarPairs(candidatePairs);
        candidatePairs = findWinningCandidates(candidatePairs);
        long countA = candidatePairs.stream().filter(el -> el.getCandidateWinner().equals("A")).count();
        long countB = candidatePairs.stream().filter(el -> el.getCandidateWinner().equals("B")).count();
        long countC = candidatePairs.stream().filter(el -> el.getCandidateWinner().equals("C")).count();
        System.out.println("A wins " + countA + " times\n"
                            + "B wins " + countB + " times\n"
                            + "C wins " + countC + " times");
        printResults(countA, countB, countC);
    }

    private ArrayList<CandidatePairs> addSimilarPairs(ArrayList<CandidatePairs> oldPairs) {
        ArrayList<CandidatePairs> resultList = new ArrayList<>();
        int index;
        CandidatePairs oldValue;
        for (CandidatePairs oldPair : oldPairs) {
            if (resultList.contains(oldPair)) {
                index = resultList.indexOf(oldPair);
                oldValue = resultList.get(index);
                resultList.set(index, new CandidatePairs(oldValue.getVoters() + oldPair.getVoters(),
                                                            oldValue.getCandidateWinner(),
                                                            oldValue.getCandidateLooser()));
            } else {
                resultList.add(oldPair);
            }
        }
        return resultList;
    }

    private ArrayList<CandidatePairs> findWinningCandidates(ArrayList<CandidatePairs> oldPairs) {
        ArrayList<CandidatePairs> resultList = new ArrayList<>();
        for (CandidatePairs pairOutside : oldPairs) {
            for (CandidatePairs pairInside : oldPairs) {
                if ((pairInside.getCandidateWinner().equals(pairOutside.getCandidateLooser()))
                        && (pairInside.getCandidateLooser().equals(pairOutside.getCandidateWinner()))) {
                    if (pairInside.getVoters() > pairOutside.getVoters()) {
                        resultList.add(pairInside);
                    } else {
                        resultList.add(pairOutside);
                    }
                }
            }
        }
        return resultList.stream().distinct().collect(Collectors.toCollection(ArrayList::new));
    }

    public CondorcetVotingVotingMethod(String[][] matrix) {
        votingNumbers = createVotingNumbers(matrix);
        candidatesMatrix = createCandidatesMatrix(matrix);
    }
}