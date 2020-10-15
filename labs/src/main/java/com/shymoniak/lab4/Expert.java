package com.shymoniak.lab4;

import java.util.ArrayList;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Expert {
    private String name;
    private Map<String, Double> preferences;
    private Map<String, Double> coefficients;
    private ArrayList<Double> carSum;
}
