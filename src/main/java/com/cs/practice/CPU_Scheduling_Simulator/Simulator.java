package com.cs.practice.CPU_Scheduling_Simulator;


public class Simulator {

    public static void main(String[] args) {

        FCFS fcfs = new FCFS();
        SJF sjf = new SJF();
        RoundRobin roundRobin = new RoundRobin();

        fcfs.exec();
        sjf.exec();
        roundRobin.exec(1);
        roundRobin.exec(4);

    }


}
