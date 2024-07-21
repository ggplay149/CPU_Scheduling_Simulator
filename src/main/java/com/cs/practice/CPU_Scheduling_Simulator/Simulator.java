package com.cs.practice.CPU_Scheduling_Simulator;

import java.util.LinkedList;
import java.util.Queue;

public class Simulator {

    static Process processA = new Process("A",0,3);
    static Process processB = new Process("B",2,6);
    static Process processC = new Process("C",4,4);
    static Process processD = new Process("D",6,5);
    static Process processE = new Process("E",8,2);

    static Process[] inputProcess = new Process[]{
        processA,processB,processC,processD,processE
    };

    public static void main (String[] args){

        FIFO();
        ROUND_ROBIN(2);

    }

    static void FIFO(){
        Queue<Integer> queue = new LinkedList<>();
        int timeCount = 0;
        int totalTime = 0;
        for(Process p : inputProcess){
            queue.offer(p.serviceTime);
            totalTime += p.serviceTime;
        }
        System.out.println("\n-------------------------- [ FIFO ] --------------------------");
        for(Process p : inputProcess){
            System.out.print(p.processName);
            for(int i = 0 ; i < timeCount ; i ++) System.out.print(" □ ");
            int serviceTime = queue.poll();
            for(int i = 0 ; i < serviceTime ; i ++) System.out.print(" ■ ");
            for(int i = 0 ; i < totalTime-timeCount-serviceTime ; i ++) System.out.print(" □ ");
            timeCount+=serviceTime;
            System.out.println();
        }
    }

    static void ROUND_ROBIN(int TQ){
        Queue<Integer> queue = new LinkedList<>();
        int timeCount = 0;
        int totalTime = 0;
        for(Process p : inputProcess){
            queue.offer(p.serviceTime);
            totalTime += p.serviceTime;
        }
        System.out.println("\n------------------- [ Round Robin - TQ "+TQ+" ] -------------------");
        for(Process p : inputProcess){
            System.out.print(p.processName);
            for(int i = 0 ; i < timeCount ; i ++) System.out.print(" □ ");
            int serviceTime = queue.poll();
            for(int i = 0 ; i < serviceTime ; i ++) System.out.print(" ■ ");
            for(int i = 0 ; i < totalTime-timeCount-serviceTime ; i ++) System.out.print(" □ ");
            timeCount+=serviceTime;
            System.out.println();
        }
    }
}
