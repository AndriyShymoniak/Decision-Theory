package com.shymoniak.tools;

import java.io.*;

public class FileWorker {

    public int[][] readTwoDimensionalArrayInt(File file, int rows, int cols) {
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String tempStr;
            while ((tempStr = bufferedReader.readLine()) != null) {
                stringBuilder.append(tempStr + " ");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return convertTextToIntMatrix(stringBuilder, rows, cols);
    }
    public String[][] readTwoDimensionalArrayStr(File file, int rows, int cols) {
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String tempStr;
            while ((tempStr = bufferedReader.readLine()) != null) {
                stringBuilder.append(tempStr + " ");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return convertTextToStrMatrix(stringBuilder, rows, cols);
    }

    private int[][] convertTextToIntMatrix(StringBuilder stringBuilder, int rows, int cols) {
        String[] strArray = stringBuilder.toString().split(" ");
        int[][] converted = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                converted[i][j] = Integer.valueOf(strArray[i * cols + j]);
            }
        }
        return converted;
    }

    private String[][] convertTextToStrMatrix(StringBuilder stringBuilder, int rows, int cols) {
        String[] strArray = stringBuilder.toString().split(" ");
        String[][] converted = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                converted[i][j] = strArray[i * cols + j];
            }
        }
        return converted;
    }
}
