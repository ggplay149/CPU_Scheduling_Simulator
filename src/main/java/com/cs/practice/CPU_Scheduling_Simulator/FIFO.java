package com.cs.practice.CPU_Scheduling_Simulator;

import java.util.LinkedList;
import java.util.Queue;

import static com.cs.practice.CPU_Scheduling_Simulator.Simulator.printBoard;

public class FIFO {

    public void exec(String[][] board, Process[] inputProcess, int totalTime){

        System.out.println("\n-------------------------- [ FIFO ] --------------------------");
        board = new String[inputProcess.length][totalTime];
        Queue<Integer> queue = new LinkedList<>();
        int timeCount = 0;

        //큐에 순차적으로 다 담기
        for(Process p : inputProcess) queue.offer(p.serviceTime);

        for(int i = 0 ; i < inputProcess.length ; i ++){
            int serviceTime = queue.poll();
            for(int j = timeCount ; j < timeCount+serviceTime ; j ++) board[i][j]=" ■ ";
            timeCount+=serviceTime;
        }

        printBoard(board);
    }
}
