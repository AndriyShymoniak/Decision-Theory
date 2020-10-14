package com.shymoniak.lab3;

public class VotingMethodParent {

    protected void printResults(long candidateASum, long candidateBSum, long candidateCSum){
        long max = Math.max(Math.max(candidateASum, candidateBSum), candidateCSum);
        if ((max == candidateASum && max == candidateBSum)
                || (max == candidateASum && max == candidateCSum)
                || (max == candidateBSum && max == candidateCSum)){
            System.out.println("There is no one winner");

        } else if (max == candidateASum){
            System.out.println("Candidate A wins");
        } else if (max == candidateBSum){
            System.out.println("Candidate B wins");
        } else if (max == candidateCSum){
            System.out.println("Candidate C wins");
        }
        System.out.println();
    }

    protected int[] createVotingNumbers(String[][] matrix) {
        int[] result = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            result[i] = Integer.valueOf(matrix[i][0]);
        }
        return result;
    }

    protected String[][] createCandidatesMatrix(String[][] matrix) {
        String[][] result = new String[matrix.length][matrix[0].length - 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                result[i][j - 1] = matrix[i][j];
            }
        }
        return result;
    }
}
