package com.cs.practice.CPU_Scheduling_Simulator.algorithm;

import com.cs.practice.CPU_Scheduling_Simulator.Process;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

@NoArgsConstructor
public class SRT {
    public void exec(int TQ) {

        //프로세스, 출력판 초기화
        Process process = new Process();
        Process[] inputProcess = process.inputProcess();
        int totalTime = process.totalTime(inputProcess);
        String[][] board = new String[inputProcess.length][totalTime+1];

        //RR 알고리즘
        int completedProcessCount = 0;
        int inputProcessCount = inputProcess.length;

        //첫번째 프로세스 도착 시간부터 타임카운트
        int timeCount = inputProcess[0].arrivalTime+1;

        //SRT 알고리즘
        PriorityQueue<Process> queue = new PriorityQueue<>(new Comparator<Process>() {
            @Override
            public int compare(Process p1, Process p2) {
                return Integer.compare(p1.remainTime, p2.remainTime);
            }
        });

        //최초의 프로세스 넣고 시작
        queue.offer(inputProcess[0]);

        while (completedProcessCount < inputProcessCount) {

            Process currentProcess = queue.poll();

            //현재 진행중인 프로세스명 찾아두기
            int processIdx = 0;
            for (int j = 0; j < inputProcess.length; j++) {
                if (inputProcess[j].processName.equals(currentProcess.processName)) {
                    processIdx = j;
                    break;
                }
            }

            //남은시간과 TQ중 적은 시간만큼 실행
            int execTime = Math.min(TQ, currentProcess.remainTime);

            //execTime 만큼 1초씩 진행
            for (int i = 0; i < execTime; i++) {
                //1초씩 진행하면서 arrivalTime이 된 다음 프로세스있는지 확인
                for (int j = 1; j < inputProcessCount; j++) {
                    if (inputProcess[j].arrivalTime == timeCount) {
                        queue.offer(inputProcess[j]);
                    }
                }

                //1초씩 remain 타임 감소, 보드판 진행, 타임카운트증가
                currentProcess.remainTime--;
                board[processIdx][timeCount] = " 1 ";
                timeCount++;

            }

            //남은시간이 0이 아니면 큐에 다시 넣기
            if (currentProcess.remainTime != 0) {
                queue.offer(currentProcess);
            } else {
                //남은시간이 0이면 종료된 프로세스 카운트 증가
                completedProcessCount++;
            }
        }
        //출력
        System.out.println("\n--------------------- [ SRT TQ : " + TQ + " ] ---------------------");
        process.printBoard(board, inputProcess, totalTime);
    }
}
