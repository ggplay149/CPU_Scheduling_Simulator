package com.cs.practice.CPU_Scheduling_Simulator;

public class RoundRobin {
    public void exec(int TQ){

        //프로세스, 출력판 초기화
        Process process = new Process();
        Process[] inputProcess = process.inputProcess();
        int totalTime = process.totalTime(inputProcess);
        String[][] board = new String[inputProcess.length][totalTime];

        //Round_Robin 알고리즘 시작

        int timeCount = 0;
        int completedProcessNum = 0;
        int processNum = inputProcess.length;

        while(completedProcessNum<processNum){
            re
        }

        //출력
        System.out.println("\n-------------------------- [ round_robin ] --------------------------");



    }
}
