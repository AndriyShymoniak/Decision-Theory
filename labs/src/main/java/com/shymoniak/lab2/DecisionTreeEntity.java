package com.shymoniak.lab2;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DecisionTreeEntity {
    private String variant;
    private int factoryWorth;
    private int income;
    private int loss;
    private int years;
    private double incomeProbability;
    private double lossProbability;
    private double buildingProbability;
    private double notBuildingProbability;

    public double findDecisionValue() {
        return (income * incomeProbability + loss * lossProbability) * years / factoryWorth;
    }

    public String toString() {
        return "Option - " + variant +
                "\nWorth: " + factoryWorth +
                "\nIncome: " + income + ", probability: " + incomeProbability +
                "\nLoss: " + loss + ", probability: " + lossProbability +
                "\nYears: " + years;
    }
}
