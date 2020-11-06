package com.shymoniak;

import com.shymoniak.lab1.TaskAL1;
import com.shymoniak.lab1.TaskBL1;
import com.shymoniak.lab2.TaskL2;
import com.shymoniak.lab3.TaskL3;
import com.shymoniak.lab4.TaskL4;
import com.shymoniak.lab5.TaskL5;

import java.util.Scanner;

public class Menu {
    public void run() {

        printMenu();
        Scanner scan = new Scanner(System.in);
        int var = scan.nextInt();
        while (var != 9){
            if (var == 1) new TaskAL1().run();
            else if (var == 2) new TaskBL1().run();
            else if (var == 3) new TaskL2().run();
            else if (var == 4) new TaskL3().run();
            else if (var == 5) new TaskL4().run();
            else if (var == 6) new TaskL5().run();

            printMenu();
            var = scan.nextInt();
        }
    }
    private void printMenu(){
        System.out.println("Choose a laboratory work:");
        System.out.println("1. Lab 1 Task A");
        System.out.println("2. Lab 1 Task B");
        System.out.println("3. Lab 2");
        System.out.println("4. Lab 3");
        System.out.println("5. Lab 4");
        System.out.println("6. Lab 5");
        System.out.println("9. Exit");
    }
}
