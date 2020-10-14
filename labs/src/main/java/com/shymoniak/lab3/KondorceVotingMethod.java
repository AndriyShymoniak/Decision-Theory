package com.shymoniak.lab3;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

public class KondorceVotingMethod {
    private int[] votingNumbers;
    private String[][] candidatesMatrix;

    public KondorceVotingMethod(String[][] matrix) {
        votingNumbers = createVotingNumbers(matrix);
        candidatesMatrix = createCandidatesMatrix(matrix);
    }

    private class CandidatePairs {
        private int voters;
        private String candidateWinner;
        private String candidateLooser;

        public CandidatePairs(int voters, String candidateWinner, String candidateLooser) {
            this.voters = voters;
            this.candidateWinner = candidateWinner;
            this.candidateLooser = candidateLooser;
        }

        public int getVoters() {
            return voters;
        }

        public String getCandidateWinner() {
            return candidateWinner;
        }

        public String getCandidateLooser() {
            return candidateLooser;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof CandidatePairs)) return false;
            CandidatePairs that = (CandidatePairs) o;
            return Objects.equals(candidateWinner, that.candidateWinner) &&
                    Objects.equals(candidateLooser, that.candidateLooser);
        }

        @Override
        public int hashCode() {
            return Objects.hash(candidateWinner, candidateLooser);
        }
    }

    public void findBestCandidate() {
        ArrayList<CandidatePairs> candidatePairs = new ArrayList<>();
        for (int i = 0; i < candidatesMatrix.length; i++) {
            for (int j = 0; j < candidatesMatrix[0].length; j++) {
                for (int k = 1; k < candidatesMatrix[0].length; k++) {
                    if ((j + k) < candidatesMatrix[0].length) {
                        candidatePairs.add(new CandidatePairs(votingNumbers[i], candidatesMatrix[i][j], candidatesMatrix[i][j + k]));
                    }
                }
            }
        }
        candidatePairs = addSimilarPairs(candidatePairs);
        candidatePairs = findWinningCandidates(candidatePairs);
        printResults(candidatePairs);
    }

    private int[] createVotingNumbers(String[][] matrix) {
        int[] result = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            result[i] = Integer.valueOf(matrix[i][0]);
        }
        return result;
    }

    private String[][] createCandidatesMatrix(String[][] matrix) {
        String[][] result = new String[matrix.length][matrix[0].length - 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                result[i][j - 1] = matrix[i][j];
            }
        }
        return result;
    }

    private ArrayList<CandidatePairs> addSimilarPairs(ArrayList<CandidatePairs> oldPairs){
        ArrayList<CandidatePairs> resultList = new ArrayList<>();
        int index;
        CandidatePairs oldValue;
        for (CandidatePairs oldPair: oldPairs) {
            if (resultList.contains(oldPair)){
                index = resultList.indexOf(oldPair);
                oldValue = resultList.get(index);
                resultList.set(index, new CandidatePairs(oldValue.voters + oldPair.voters, oldValue.candidateWinner, oldValue.candidateLooser));
            } else {
                resultList.add(oldPair);
            }
        }
        return resultList;
    }

    private ArrayList<CandidatePairs> findWinningCandidates(ArrayList<CandidatePairs> oldPairs){
        ArrayList<CandidatePairs> resultList = new ArrayList<>();
        for (CandidatePairs pairOutside: oldPairs) {
            for (CandidatePairs pairInside: oldPairs) {
                if ((pairInside.getCandidateWinner().equals(pairOutside.getCandidateLooser()))
                        && (pairInside.getCandidateLooser().equals(pairOutside.getCandidateWinner()))){
                    if (pairInside.getVoters() > pairOutside.getVoters()){
                        resultList.add(pairInside);
                    } else {
                        resultList.add(pairOutside);
                    }
                }
            }
        }
        return resultList.stream().distinct().collect(Collectors.toCollection(ArrayList::new));
    }

    private void printResults(ArrayList<CandidatePairs> pairs){
        long countA = pairs.stream().filter(el -> el.getCandidateWinner().equals("A")).count();
        long countB = pairs.stream().filter(el -> el.getCandidateWinner().equals("B")).count();
        long countC = pairs.stream().filter(el -> el.getCandidateWinner().equals("C")).count();

        System.out.println("A wins " + countA + " times");
        System.out.println("B wins " + countB + " times");
        System.out.println("C wins " + countC + " times");

        long max = Math.max(Math.max(countA, countB), countC);
        if ((max == countA && max == countB)
            || (max == countA && max == countC)
                || (max == countB && max == countC)){
            System.out.println("There is no one winner");

        } else if (max == countA){
            System.out.println("Candidate A wins");
        } else if (max == countB){
            System.out.println("Candidate B wins");
        } else if (max == countC){
            System.out.println("Candidate C wins");
        }
        System.out.println();
    }

}
