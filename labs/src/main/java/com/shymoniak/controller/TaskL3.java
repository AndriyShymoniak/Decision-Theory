package com.shymoniak.controller;

import com.shymoniak.model.lab3.BordaVotingVotingMethod;
import com.shymoniak.model.lab3.CondorcetVotingVotingMethod;
import com.shymoniak.tools.Constants;
import com.shymoniak.tools.TxtFileReader;

import java.io.File;
import java.util.Arrays;

/**
 * Який кандидат виграє А,Б,С по методу Кондорсе і по методу Борда для заданого
 * розподілу голосів?
 * 22 A->B->C
 * 14 A->C->B
 * 18 C->B->A
 * 11 B->C->A
 * 23 B->A->C
 */
public class TaskL3 {
    public void run() {
        TxtFileReader fileReader = new TxtFileReader();
        String[][] matrix = fileReader.read2DArrayStr(
                                        new File(Constants.LAB3_FILE_DIR), 5, 4);
        System.out.println(Arrays.toString(matrix));

        // Condorcet method
        System.out.println("---Condorcet method---");
        CondorcetVotingVotingMethod cvm = new CondorcetVotingVotingMethod(matrix);
        cvm.findBestCandidate();

        // Borda method
        System.out.println("---Borda method---");
        BordaVotingVotingMethod bvm  = new BordaVotingVotingMethod(matrix);
        bvm.findBestCandidate();
    }
}