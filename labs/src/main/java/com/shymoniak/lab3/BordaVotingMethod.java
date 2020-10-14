package com.shymoniak.lab3;

public class BordaVotingMethod extends MethodParent {
    private int[] votingNumbers;
    private String[][] candidatesMatrix;

    public BordaVotingMethod(String[][] matrix) {
        votingNumbers = createVotingNumbers(matrix);
        candidatesMatrix = createCandidatesMatrix(matrix);
    }

    public void findBestCandidate() {
        long candidateASum = 0;
        long candidateBSum = 0;
        long candidateCSum = 0;

        for (int i = 0; i < candidatesMatrix.length; i++) {
            for (int j = 0; j < candidatesMatrix[0].length; j++) {
                if (candidatesMatrix[i][j].equals("A")){
                    candidateASum += votingNumbers[i] * (candidatesMatrix[0].length - (j+1));
                } else if (candidatesMatrix[i][j].equals("B")){
                    candidateBSum += votingNumbers[i] * (candidatesMatrix[0].length - (j+1));
                } else if (candidatesMatrix[i][j].equals("C")){
                    candidateCSum += votingNumbers[i] * (candidatesMatrix[0].length - (j+1));
                }
            }
        }
        System.out.println("Candidate A gets - " + candidateASum + " points");
        System.out.println("Candidate B gets - " + candidateBSum + " points");
        System.out.println("Candidate C gets - " + candidateCSum + " points");

        printResults(candidateASum,candidateBSum,candidateCSum);
    }

}
