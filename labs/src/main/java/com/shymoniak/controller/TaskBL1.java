package com.shymoniak.controller;

import com.shymoniak.model.lab1.criterias.BayesLaplaceCriterion;
import com.shymoniak.tools.*;

import java.io.File;
import java.util.Arrays;

/**
 * Б) Прийняти рішення в умовах ризику
 * Нехай отримані експертні оцінки ймовірностей стану зовнішнього середовища
 * p1=0.5, p2=0.35, p3=0.15. Оцінити альтернативні рішення по критерію БайесаЛапласа.
 * Результати обчислень цінностей альтернативних рішень занести в ту ж
 * таблицю. Вибрати найкраще рішення. Порівняти результати вибору з
 * отриманими раніше результатами вибору рішення в умовах невизначеності.
 *
 * Матриця
 * цінностей
 * № варіанту 1 (29-28=1)
 *
 * 100 80 50
 * 90 90 70
 * 60 70 80
 */
public class TaskBL1 {

    public void run() {
        TxtFileReader txtFileReader = new TxtFileReader();
        int[][] matrix = txtFileReader.readTwoDimensionalArrayInt(new File(Constants.LAB1_FILE_DIRECTORY), 3, 3);
        System.out.println("    Task B\n");
        System.out.println(Arrays.toString(matrix));
        System.out.print("Coefficients: ");
        System.out.println(Arrays.toString(Constants.LAB1B_COEFFICIENTS));
        System.out.println();

        BayesLaplaceCriterion bayesLaplaceCriterion = new BayesLaplaceCriterion(matrix, Constants.LAB1B_COEFFICIENTS);
        System.out.println("Bayes-Laplace criteria:");
        int[] bayesLaplaceSolution = bayesLaplaceCriterion.bestSolution();
        System.out.print("The best solution is: ");
        System.out.println(Arrays.toString(bayesLaplaceSolution));
        System.out.println("__________________________________\n");
    }
}