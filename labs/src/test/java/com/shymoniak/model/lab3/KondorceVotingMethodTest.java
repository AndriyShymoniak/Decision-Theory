package com.shymoniak.model.lab3;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Objects;

public class KondorceVotingMethodTest {

    static class CandidatePairs {
        private int voters;
        private String candidateWinner;
        private String candidateLooser;

        public CandidatePairs(int voters, String candidateWinner, String candidateLooser) {
            this.voters = voters;
            this.candidateWinner = candidateWinner;
            this.candidateLooser = candidateLooser;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof CandidatePairs)) return false;
            CandidatePairs that = (CandidatePairs) o;
            return voters == that.voters &&
                    Objects.equals(candidateWinner, that.candidateWinner) &&
                    Objects.equals(candidateLooser, that.candidateLooser);
        }

        @Override
        public int hashCode() {
            return Objects.hash(voters, candidateWinner, candidateLooser);
        }
    }

    /*
    22 A B C
    14 A C B
     */
    private static final ArrayList<CandidatePairs> expected = new ArrayList<>();

    @Before
    public final void setUpCandidatesData() {
        expected.add(new CandidatePairs(22, "A", "B"));
        expected.add(new CandidatePairs(22, "A", "C"));
        expected.add(new CandidatePairs(22, "B", "C"));
        expected.add(new CandidatePairs(14, "A", "C"));
        expected.add(new CandidatePairs(14, "A", "B"));
        expected.add(new CandidatePairs(14, "C", "B"));
    }

    @After
    public final void tearDownCandidatesData() {
        expected.clear();
    }

    @Test(timeout = 1000)
    public void findBestCandidate() {
        ArrayList<CandidatePairs> candidatePairs = new ArrayList<>();

        int[] votingNumbers = new int[]{22, 14};
        String[][] candidatesMatrix = new String[][]{{"A","B","C"},
                {"A","C","B"}};
        for (int i = 0; i < candidatesMatrix.length; i++) {
            for (int j = 0; j < candidatesMatrix[0].length; j++) {
                for (int k = 1; k < candidatesMatrix[0].length; k++) {
                    if ((j + k) < candidatesMatrix[0].length) {
                        candidatePairs.add(new CandidatePairs(votingNumbers[i], candidatesMatrix[i][j], candidatesMatrix[i][j + k]));
                    }
                }
            }
        }
        System.out.println("Everything is fine");
        Assert.assertEquals(expected, candidatePairs);
    }
}