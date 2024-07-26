package com.cs.practice.CPU_Scheduling_Simulator;


import com.cs.practice.CPU_Scheduling_Simulator.algorithm.*;

public class Simulator {

    public static void main(String[] args) {

        FCFS fcfs = new FCFS();
        SJF sjf = new SJF();
        RR rr = new RR();
        MLFQ mlfq = new MLFQ();
        SRT srt = new SRT();


        fcfs.exec();
        sjf.exec();


        rr.exec(1);
        rr.exec(4);
        srt.exec(1);

        mlfq.exec(1, -1);
        mlfq.exec(4, -1);
        mlfq.exec(4, 3);
    }
}
