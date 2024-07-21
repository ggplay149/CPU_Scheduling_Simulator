package com.cs.practice.CPU_Scheduling_Simulator;

public class Process {

    String processName;
    int arrivalTime = 0;
    int serviceTime = 0;

    public Process(String processName, int arrivalTime, int serviceTime){
        this.processName = processName;
        this.arrivalTime = arrivalTime;
        this.serviceTime = serviceTime;
    }
}
