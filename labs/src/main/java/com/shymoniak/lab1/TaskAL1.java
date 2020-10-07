package com.shymoniak.lab1;

import com.shymoniak.lab1.criterias.*;
import com.shymoniak.tools.*;

import java.io.File;

/**
 * Компанія має три альтернативних варіанти своєї стратегії розвитку. Оцінка його
 * прибутку в залежності від стану зовнішнього середовища наведено в таблиці .
 *
 * А) Прийняти рішення в умовах невизначеності.
 * Необхідно знайти оптимальні стратегії при песимістичній оцінці (по критерію Вальда),
 * оцінці Лапласа, по критерію Гурвіца. Значення коефіцієнта оптимізму вибрати
 * самостійно. Результати вибору рішення відобразити в таблиці. Зробити висновки по
 * застосуванню критеріїв
 *
 * Матриця
 * цінностей
 * № варіанту 1 (29-28=1)
 *
 * 100 80 50
 * 90 90 70
 * 60 70 80
 */
public class TaskAL1 {

    public void run(){
        FileWorker fileWorker = new FileWorker();
        MatrixActions matrixActions = new MatrixActions();
        int[][] matrix = fileWorker.readTwoDimensionalArray(new File(Constants.LAB1_FILE_DIRECTORY), 3, 3);
        System.out.println("    Task A\n");
        matrixActions.print(matrix);

        WaldCriteria waldCriteria = new WaldCriteria(matrix);
        System.out.println("The best solution by Wald criteria:");
        int[] waldSolution = waldCriteria.bestSolution();
        matrixActions.print(waldSolution);
        System.out.println();

        LaplaceCriterion laplaceCriterion = new LaplaceCriterion(matrix);
        System.out.println("The best solution by Laplace criterion:");
        int[] laplaceSolution = laplaceCriterion.bestSolution();
        matrixActions.print(laplaceSolution);
        System.out.println();

        HurwitzCriteria hurwitzCriteria = new HurwitzCriteria(matrix);
        System.out.println("The best solution by Hurwitz criteria:");
        int[] hurwitzSolution = hurwitzCriteria.bestSolution();
        System.out.println("Answer: ");
        matrixActions.print(hurwitzSolution);
        System.out.println("____________________________\n");
    }
}
