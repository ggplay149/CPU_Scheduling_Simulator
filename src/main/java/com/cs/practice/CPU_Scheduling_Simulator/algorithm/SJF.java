package com.cs.practice.CPU_Scheduling_Simulator.algorithm;

import com.cs.practice.CPU_Scheduling_Simulator.Process;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.PriorityQueue;

@NoArgsConstructor
public class SJF {
    public void exec() {

        //프로세스, 출력판 초기화
        Process process = new Process();
        Process[] inputProcess = process.inputProcess();
        int totalTime = process.totalTime(inputProcess);
        String[][] board = new String[inputProcess.length][totalTime];
        int timeCount = 0;

        //SJF 알고리즘
        PriorityQueue<Process> queue = new PriorityQueue<>(new Comparator<Process>() {
            @Override
            public int compare(Process p1, Process p2) {
                return Integer.compare(p1.serviceTime, p2.serviceTime);
            }
        });
        for (Process p : inputProcess) queue.offer(p);

        for (int i = 0; i < inputProcess.length; i++) {

            Process currentProcess = queue.poll();
            int serviceTime = currentProcess.serviceTime;
            String processName = currentProcess.processName;

            int processIdx = 0;
            for (int j = 0; j < inputProcess.length; j++) {
                if (inputProcess[j].processName.equals(processName)) {
                    processIdx = j;
                    break;
                }
            }

            for (int j = timeCount; j < timeCount + serviceTime; j++) board[processIdx][j] = " 1 ";
            timeCount += serviceTime;

        }

        //출력
        System.out.println("\n-------------------------- [ SJF ] --------------------------");
        process.printBoard(board, inputProcess, totalTime);

    }
}
