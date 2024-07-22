package com.cs.practice.CPU_Scheduling_Simulator;


public class Simulator {

    public static void main (String[] args){

        FIFO fifo = new FIFO();
        SJF sjf = new SJF();
        RoundRobin roundRobin = new RoundRobin();

        fifo.exec();
        sjf.exec();
        roundRobin.exec(1);

    }


}
