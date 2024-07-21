package com.cs.practice.CPU_Scheduling_Simulator;

public class Simulator {

    static Process processA = new Process("A",0,3);
    static Process processB = new Process("B",2,6);
    static Process processC = new Process("C",4,4);
    static Process processD = new Process("D",6,5);
    static Process processE = new Process("E",8,2);

    static Process[] inputProcess = new Process[]{
        processA,processB,processC,processD,processE
    };

    static String[][] board;
    static int totalTime = 0;

    public static void main (String[] args){

        final FIFO fifo = new FIFO();
        final RoundRobin roundRobin = new RoundRobin();

        for(Process p : inputProcess) totalTime += p.serviceTime;

        fifo.exec(board,inputProcess,totalTime);
        roundRobin.exec(board,inputProcess,totalTime,4);

    }

    static void printBoard(String[][] board){
        for(int i = 0 ; i < inputProcess.length ; i ++){
            System.out.print(inputProcess[i].processName);
            for(int j = 0 ; j < totalTime ; j++ ){
                if(board[i][j]==null)System.out.print(" □ ");
                else System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
