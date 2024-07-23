package com.cs.practice.CPU_Scheduling_Simulator.algorithm;

import com.cs.practice.CPU_Scheduling_Simulator.Process;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@NoArgsConstructor
public class MLFQ {

    public void exec(int queueNum, int TQ) {

        //프로세스, 출력판 초기화
        Process process = new Process();
        Process[] inputProcess = process.inputProcess();
        int totalTime = process.totalTime(inputProcess);
        String[][] board = new String[inputProcess.length][totalTime];

        List<Queue<Process>> queueList = new ArrayList<>();
        for (int i = 0; i < queueNum; i++) {
            Queue<Process> queue = new LinkedList<>();
            queueList.add(queue);
        }

        int timeCount = 0;

        //MLFQ 알고리즘

        //출력
        System.out.println("\n------------------- [ Round_Robin TQ : " + TQ + " ] -------------------");
        process.printBoard(board, inputProcess, totalTime);
    }
}
