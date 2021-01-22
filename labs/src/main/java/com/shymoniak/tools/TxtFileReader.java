package com.shymoniak.tools;

import java.io.*;
import java.util.Arrays;

public class TxtFileReader {

    public String[][] read2DArrayStr(File file, int rows, int cols) {
        return convertTextToStrMatrix(getTextFromFile(file), rows, cols);
    }

    public int[][] read2DArrayInt(File file, int rows, int cols) {
        StringBuilder stringBuilder = getTextFromFile(file);
        return Arrays.stream(convertTextToStrMatrix(stringBuilder, rows, cols))
                        .map(a ->
                                Arrays.stream(a)
                                        .mapToInt(Integer::parseInt)
                                        .toArray()
                        ).toArray(int[][]::new);
    }

    private StringBuilder getTextFromFile(File file) {
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
        return stringBuilder;
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