package com.cs.practice.CPU_Scheduling_Simulator;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Process {

    public String processName;
    public int arrivalTime;
    public int serviceTime;
    public int remainTime;
    public int cpuReturnTime;


    public Process[] inputProcess(){
        return new Process[]{
                new Process("A",0,4,4,1),
                new Process("B",1,3,3,2),
                new Process("C",3,3,3,3),
                new Process("D",4,2,2,0),
                new Process("E",5,2,2,5)
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
                else System.out.print(" # ");
            }
            System.out.println();
        }
    }
}
