package com.shymoniak.lab1;

import com.shymoniak.lab1.criterias.BayesLaplaceCriterion;
import com.shymoniak.tools.*;

import java.io.File;

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
public class TaskB {
    public static final String FILE_DIRECTORY = "D:\\Навчання\\4 курс І семестр\\Теорія прийняття рішень\\Програма\\Decision-Theory\\varaint_lab1.txt";
    public static final double[] COEFFICIENTS = {0.5, 0.35, .015};

    public void run() {
        FileWorker fileWorker = new FileWorker();
        MatrixActions matrixActions = new MatrixActions();
        int[][] matrix = fileWorker.readTwoDimensionalArray(new File(FILE_DIRECTORY), 3, 3);
        System.out.println("    Task B\n");
        matrixActions.print(matrix);
        System.out.print("Coefficients: ");
        matrixActions.print(COEFFICIENTS);
        System.out.println();

        BayesLaplaceCriterion bayesLaplaceCriterion = new BayesLaplaceCriterion(matrix, COEFFICIENTS);
        System.out.println("The best solution by Bayes-Laplace criteria:");
        int[] bayesLaplaceSolution = bayesLaplaceCriterion.bestSolution();
        System.out.println("Answer:");
        matrixActions.print(bayesLaplaceSolution);

    }
}
