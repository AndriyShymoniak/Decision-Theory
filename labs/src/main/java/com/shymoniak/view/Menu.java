package com.shymoniak.view;

import com.shymoniak.controller.*;

import java.util.Scanner;

public class Menu {
    public void run() {
        Scanner scan = new Scanner(System.in);
        int fromUser = 0;
        while (fromUser != 9) {
            printMenu();
            fromUser = getNumber(scan);
            switch (fromUser) {
                case 1:
                    new TaskAL1().run();
                    break;
                case 2:
                    new TaskBL1().run();
                    break;
                case 3:
                    new TaskL2().run();
                    break;
                case 4:
                    new TaskL3().run();
                    break;
                case 5:
                    new TaskL4().run();
                    break;
                case 6:
                    new TaskL5().run();
                    break;
                case 9:
                    break;
                default:
                    System.out.println("Error. Please try again.");
                    break;
            }
        }
    }

    private void printMenu() {
        System.out.println("\n__________________________________\n");
        System.out.println("Choose a laboratory work:");
        System.out.println("1. Lab 1 Task A");
        System.out.println("2. Lab 1 Task B");
        System.out.println("3. Lab 2");
        System.out.println("4. Lab 3");
        System.out.println("5. Lab 4");
        System.out.println("6. Lab 5");
        System.out.println("9. Exit");
    }

    private int getNumber(Scanner scan) {
        try {
            int number = Integer.parseInt(scan.next());
            return number;
        } catch (NumberFormatException ex) {
            System.out.println("You should enter a number.");
        }
        return 0;
    }
}