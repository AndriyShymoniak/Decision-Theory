package com.shymoniak.lab2;

import com.shymoniak.tools.Constants;
import com.shymoniak.tools.GSON;
import com.shymoniak.tools.MatrixActions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Компанія розглядає питання про будівництво заводу. Можливі три варіанти:
 * А) Побудувати великий завод вартістю М1 тис. доларів. При цьому варіанті можливі
 * великий попит (річний дохід в розмірі D1 тис. доларів протягом наступних 5 років) з
 * ймовірністю Р1 і низький попит (щорічні збитки D2 тис. доларів) з ймовірністю Р2 .
 * <p>
 * Б) Побудувати маленький завод вартістю М2 тис. Доларів. При цьому варіанті можливі
 * великий попит (річний дохід в розмірі D1 тис. Доларів протягом наступних 5 років) з
 * ймовірністю Р1 і низький попит (щорічні збитки D2 тис. доларів) з ймовірністю Р2
 * <p>
 * В) Відкласти будівництво заводу на 1 рік для збору додаткової інформації, яка може
 * бути позитивною або негативною з ймовірністю Р3 і Р4 відповідно. У разі позитивної
 * інформації можна побудувати заводи з зазначеним вище розцінками, а ймовірності
 * великого і низького попиту змінюються на Р1 і Р2 відповідно. Доходи на наступні 4 роки
 * залишаються колишніми. У разі негативної інформації компанія заводи будувати не
 * буде.
 * <p>
 * Варіант 1
 * A
 * M1    D1    P1    D2    P2
 * 700  280   0.8   -80   0.2
 * <p>
 * Б
 * M2    D1    P1    D2    P2
 * 300  180   0.8   -55    0.2
 * <p>
 * В
 * P3    P4    P1    P2
 * 0.7   0.3   0.9   0.1
 */
public class TaskL2 {

    public void run() {
        GSON gson = new GSON();
        MatrixActions matrixActions = new MatrixActions();
        List<DecisionTreeEntity> decisionsList = gson.readFromFile(new File(Constants.LAB2_FILE_DIRECTORY));
        ArrayList<Double> resultValues = new ArrayList<>();
        System.out.println("Decision Tree\n");

        System.out.println("Formula: [(income * incomeProbability + loss * lossProbability) * years / factoryWorth]\n");
        for (DecisionTreeEntity decision : decisionsList) {
            System.out.println(decision.toString());
            System.out.print("Value calculated with formula: ");
            resultValues.add(decision.findDecisionValue());
            System.out.println(decision.findDecisionValue() + "\n");
        }

        int indexOfTheBest = resultValues.indexOf(getBiggestInArraylist(resultValues));
        System.out.println("__________________________________");
        System.out.print("The best solution is: ");
        System.out.println(decisionsList.get(indexOfTheBest));
        System.out.println(resultValues.get(indexOfTheBest));
    }

    private Double getBiggestInArraylist(ArrayList<Double> doubleArrayList){
        return doubleArrayList.stream().max(Double::compareTo).get();
    }
}
