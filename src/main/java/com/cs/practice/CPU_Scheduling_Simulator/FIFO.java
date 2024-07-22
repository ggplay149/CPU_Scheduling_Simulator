package com.cs.practice.CPU_Scheduling_Simulator;

import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.Queue;

@NoArgsConstructor
public class FIFO {

    public void exec(){

        //프로세스, 출력판 초기화
        Process process = new Process();
        Process[] inputProcess = process.inputProcess();
        int totalTime = process.totalTime(inputProcess);
        String[][] board = new String[inputProcess.length][totalTime];

        //FIFO 알고리즘
        Queue<Integer> queue = new LinkedList<>();
        int timeCount = 0;
        for(Process p : inputProcess) queue.offer(p.serviceTime);
        for(int i = 0 ; i < inputProcess.length ; i ++){
            int serviceTime = queue.poll();
            for(int j = timeCount ; j < timeCount+serviceTime ; j ++) board[i][j]=" V ";
            timeCount+=serviceTime;
        }

        //출력
        System.out.println("\n-------------------------- [ FIFO ] --------------------------");
        process.printBoard(board,inputProcess,totalTime);

    }
}
