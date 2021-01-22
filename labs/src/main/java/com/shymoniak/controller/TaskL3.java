package com.shymoniak.controller;

import com.shymoniak.model.lab3.BordaVotingVotingMethod;
import com.shymoniak.model.lab3.KondorceVotingVotingMethod;
import com.shymoniak.tools.Constants;
import com.shymoniak.tools.TxtFileReader;
import com.shymoniak.tools.MatrixActions;

import java.io.File;
import java.util.Arrays;

public class TaskL3 {
    public void run() {
        TxtFileReader txtFileReader = new TxtFileReader();
        MatrixActions matrixActions = new MatrixActions();
        String[][] matrix = txtFileReader.readTwoDimensionalArrayStr(new File(Constants.LAB3_FILE_DIRECTORY), 5, 4);
        System.out.println(Arrays.toString(matrix));
        System.out.println("Kondorce method");
        KondorceVotingVotingMethod kondorceVotingMethod = new KondorceVotingVotingMethod(matrix);
        kondorceVotingMethod.findBestCandidate();
        System.out.println("Borda method");
        BordaVotingVotingMethod bordaVotingMethod = new BordaVotingVotingMethod(matrix);
        bordaVotingMethod.findBestCandidate();
    }
}
