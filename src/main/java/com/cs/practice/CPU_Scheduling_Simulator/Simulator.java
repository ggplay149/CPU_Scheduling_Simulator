package com.cs.practice.CPU_Scheduling_Simulator;


import com.cs.practice.CPU_Scheduling_Simulator.algorithm.*;

public class Simulator {

    public static void main(String[] args) {

        FCFS fcfs = new FCFS();
        SJF sjf = new SJF();
        RR rr = new RR();
        SRT srt = new SRT();
        MLFQ mlfq = new MLFQ();


        //fcfs.exec();
        //sjf.exec();
        //rr.exec(1);
        //rr.exec(4);
        //srt.exec();
        mlfq.exec(3,1 , 3);
    }


}
