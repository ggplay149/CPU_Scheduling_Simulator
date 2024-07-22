package com.cs.practice.CPU_Scheduling_Simulator;

import java.util.LinkedList;
import java.util.Queue;

public class RoundRobin {
    public void exec(int TQ){

        //프로세스, 출력판 초기화
        Process process = new Process();
        Process[] inputProcess = process.inputProcess();
        int totalTime = process.totalTime(inputProcess);
        String[][] board = new String[inputProcess.length][totalTime];


        //RR 알고리즘

        Queue<Process> queue = new LinkedList<>();
        queue.offer(inputProcess[0]);
        System.out.print("0초 : " +inputProcess[0].processName +"/"+inputProcess[0].remainTime);
        System.out.println();
        int timeCount = 0;



        while(!queue.isEmpty()){
            Process currentProcess = queue.poll();
            String processName = currentProcess.processName;
            int remainTime = currentProcess.remainTime;
            int execTime = Math.min(TQ,remainTime);

            if(execTime > 0) {

                //현재 프로세스 index 찾기
                int processIdx = 0;
                for (int j = 0; j < inputProcess.length; j++) {
                    if (inputProcess[j].processName.equals(processName)) {
                        processIdx = j;
                        break;
                    }
                }

                int startTime = timeCount;
                for (int i = startTime; i < startTime + execTime; i++) {

                    currentProcess.remainTime--;

                    queue.offer(currentProcess);
                    timeCount++;
                    for (int j = 0; j < inputProcess.length; j++) {
                        if (inputProcess[j].arrivalTime == i) {
                            queue.offer(inputProcess[j]);
                        }
                    }
                    System.out.print(timeCount + "초 : ");
                    for(Process p : queue)System.out.print(p.processName+"/"+p.remainTime+" ");
                    System.out.println();

                    board[processIdx][i] = " 1 ";

                }

            }



        }
        //출력
        System.out.println("\n-------------------------- [ round_robin ] --------------------------");
        process.printBoard(board,inputProcess,totalTime);
    }

}
