package com.cs.practice.CPU_Scheduling_Simulator;


import com.cs.practice.CPU_Scheduling_Simulator.algorithm.FCFS;
import com.cs.practice.CPU_Scheduling_Simulator.algorithm.MLFQ;
import com.cs.practice.CPU_Scheduling_Simulator.algorithm.RR;
import com.cs.practice.CPU_Scheduling_Simulator.algorithm.SJF;

public class Simulator {

    public static void main(String[] args) {

        FCFS fcfs = new FCFS();
        SJF sjf = new SJF();
        RR rr = new RR();
        MLFQ mlfq = new MLFQ();

        fcfs.exec();
        sjf.exec();
        rr.exec(1);
        rr.exec(4);
        mlfq.exec(1,3);

    }


}
