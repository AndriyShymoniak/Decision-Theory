package com.shymoniak.model.lab3;

import lombok.Getter;

import java.util.Objects;

/**
 * Additional class
 */
@Getter
public class CandidatePairs {
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
        return Objects.equals(candidateWinner, that.candidateWinner) &&
                Objects.equals(candidateLooser, that.candidateLooser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(candidateWinner, candidateLooser);
    }
}