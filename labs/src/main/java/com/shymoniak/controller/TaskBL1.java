package com.shymoniak.controller;

import com.shymoniak.model.lab1.BayesLaplaceCriterion;
import com.shymoniak.tools.*;

import java.io.File;
import java.util.Arrays;

/**
 * Компанія має три альтернативних варіанти своєї стратегії розвитку. Оцінка його
 * прибутку в залежності від стану зовнішнього середовища наведено в таблиці.
 * Б) Прийняти рішення в умовах ризику
 * Нехай отримані експертні оцінки ймовірностей стану зовнішнього середовища:
 * p1=0.5, p2=0.35, p3=0.15. Оцінити альтернативні рішення по критерію Байеса-
 * Лапласа. Результати обчислень цінностей альтернативних рішень занести в ту ж
 * таблицю.Вибрати найкраще рішення. Порівняти результати вибору з отриманими
 * раніше результатами вибору рішення в умовах невизначеності.
 * <p>
 * Матриця цінностей [№ варіанту 1 (29-28=1)]
 * 100 80 50
 * 90 90 70
 * 60 70 80
 */
public class TaskBL1 {

    public void run() {
        TxtFileReader txtFileReader = new TxtFileReader();
        int[][] matrix = txtFileReader.read2DArrayInt(
                new File(Constants.LAB1_FILE_DIR), 3, 3);
        System.out.println("    Task B");
        System.out.println(Arrays.deepToString(matrix));
        System.out.print("Coefficients: "
                + Arrays.toString(Constants.LAB1B_COEFFICIENTS) + "\n");

        // Bayes-Laplace criterion
        BayesLaplaceCriterion bayesLaplaceCriterion = new BayesLaplaceCriterion(
                matrix, Constants.LAB1B_COEFFICIENTS);
        System.out.println("\n---Bayes-Laplace criterion:---");
        int[] bayesLaplaceSolution = bayesLaplaceCriterion.bestSolution();
        System.out.print("The best solution is: "
                + Arrays.toString(bayesLaplaceSolution));
    }
}