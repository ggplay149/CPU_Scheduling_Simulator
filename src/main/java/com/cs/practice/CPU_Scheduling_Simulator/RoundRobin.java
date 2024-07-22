package com.cs.practice.CPU_Scheduling_Simulator;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class RoundRobin {
    public void exec(int TQ){

        //프로세스, 출력판 초기화
        Process process = new Process();
        Process[] inputProcess = process.inputProcess();
        int totalTime = process.totalTime(inputProcess);
        String[][] board = new String[inputProcess.length][totalTime];

        //Round_Robin 알고리즘 시작
         Queue<Process> queue = new LinkedList<>();
        int timeCount = 0;
        int completedProcessNum = 0;
        int processNum = inputProcess.length;
        while(processNum>completedProcessNum) {

            System.out.print(completedProcessNum+"/"+timeCount + "sec : ");

            for(int i = completedProcessNum ; i < processNum ; i ++){
                if(inputProcess[i].arrivalTime<=timeCount){
                    if(inputProcess[i].remainTime > 0){
                        inputProcess[i].remainTime -=1;
                        queue.offer(inputProcess[i]);
                    }else{
                        inputProcess[i].remainTime = 0;
                        queue.offer(inputProcess[i]);
                        completedProcessNum++;
                    }
                }
            }
            for(Process p : queue){
                System.out.print(p.processName + "/"+p.remainTime+" ");
            }
            System.out.println();
            queue.poll();
            timeCount++;

        }



        //출력
//        System.out.println("\n-------------------------- [ round_robin ] --------------------------");
//        process.printBoard(board,inputProcess,totalTime);
    }
}
