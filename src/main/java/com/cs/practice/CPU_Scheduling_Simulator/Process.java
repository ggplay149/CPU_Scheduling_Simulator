package com.cs.practice.CPU_Scheduling_Simulator;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Process {

    String processName;
    int arrivalTime;
    int serviceTime;
    int remainTime;

    public Process[] inputProcess(){
        return new Process[]{
                new Process("A",0,3,3),
                new Process("B",2,6,6),
                new Process("C",4,4,4),
                new Process("D",6,5,5),
                new Process("E",8,2,2)
        };
    }

    //총시간 구하기
    public int totalTime(Process[] inputProcess){
        int totalTime = 0;
        for(Process p : inputProcess) totalTime += p.serviceTime;
        return totalTime;
    }

    //경과 출력용
    public void printBoard(String[][] board,Process[] inputProcess, int totalTime){
        for(int i = 0 ; i < inputProcess.length ; i ++){
            System.out.print(inputProcess[i].processName);
            for(int j = 0 ; j < totalTime ; j++ ){
                if(board[i][j]==null)System.out.print(" O ");
                else System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
