package com.shymoniak.lab3;

import com.shymoniak.tools.Constants;
import com.shymoniak.tools.FileWorker;
import com.shymoniak.tools.MatrixActions;

import java.io.File;

public class TaskL3 {
    public void run() {
        FileWorker fileWorker = new FileWorker();
        MatrixActions matrixActions = new MatrixActions();
        String[][] matrix = fileWorker.readTwoDimensionalArrayStr(new File(Constants.LAB3_FILE_DIRECTORY), 5, 4);
        matrixActions.print(matrix);
        System.out.println("Kondorce method");
        KondorceVotingVotingMethod kondorceVotingMethod = new KondorceVotingVotingMethod(matrix);
        kondorceVotingMethod.findBestCandidate();
        System.out.println("Borda method");
        BordaVotingVotingMethod bordaVotingMethod = new BordaVotingVotingMethod(matrix);
        bordaVotingMethod.findBestCandidate();
    }
}
