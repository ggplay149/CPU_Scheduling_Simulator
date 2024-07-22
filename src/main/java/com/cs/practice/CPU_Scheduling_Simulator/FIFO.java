package com.cs.practice.CPU_Scheduling_Simulator;

import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

@NoArgsConstructor
public class FIFO {

    public void exec(){

        //프로세스, 출력판 초기화
        Process process = new Process();
        Process[] inputProcess = process.inputProcess();
        int totalTime = process.totalTime(inputProcess);
        String[][] board = new String[inputProcess.length][totalTime];
        int timeCount = 0;

        //FIFO 알고리즘
        PriorityQueue<Process> queue = new PriorityQueue<>(new Comparator<Process>() {
            @Override
            public int compare(Process p1, Process p2) {
                return Integer.compare(p1.arrivalTime, p2.arrivalTime);
            }
        });
        for(Process p : inputProcess) queue.offer(p);


        for(int i = 0 ; i < inputProcess.length ; i ++){

            Process currentProcess = queue.poll();
            int serviceTime = currentProcess.serviceTime;
            String processName = currentProcess.processName;

            int processIdx = 0;
            for(int j = 0 ; j < inputProcess.length ; j ++){
                if(inputProcess[j].processName.equals(processName)){
                    processIdx=j;
                    break;
                }
            }

            for(int j = timeCount ; j < timeCount+serviceTime ; j ++) board[processIdx][j]=" 1 ";
            timeCount+=serviceTime;
        }

        //출력
        System.out.println("\n-------------------------- [ FIFO ] --------------------------");
        process.printBoard(board,inputProcess,totalTime);

    }
}
