package com.cs.practice.CPU_Scheduling_Simulator.algorithm;

import com.cs.practice.CPU_Scheduling_Simulator.Process;
import lombok.NoArgsConstructor;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

@NoArgsConstructor
public class MLFQ {

    public void exec(int queueNum, int TQ, int S) {

        //프로세스, 출력판 초기화
        Process process = new Process();
        Process[] inputProcess = process.inputProcess();
        int totalTime = process.totalTime(inputProcess);
        String[][] board = new String[inputProcess.length][totalTime];

        int completedProcessCount = 0;
        int inputProcessCount = inputProcess.length;

        List<Deque<Process>> queueList = new ArrayList<>();

        int sCount = 0;

        for(int i = 0 ;  i <queueNum; i ++){
            queueList.add(new ArrayDeque<Process>());
        }

        //MLFQ 알고리즘

        //첫번째 프로세스 도착 시간부터 타임카운트
        int timeCount = inputProcess[0].arrivalTime;

        //첫프로세스 가장 최상단 큐에 넣기
        queueList.get(0).offer(inputProcess[0]);

        while (completedProcessCount < inputProcessCount) {
            for(int q = 0 ; q <queueNum ; q ++){

                //최우선 큐부터 검사해서 큐가 비어있지 않다면
                if(!queueList.get(q).isEmpty()){

                    System.out.print(timeCount+"sec : queue1 : ");
                    for(Process p : queueList.get(0))System.out.print(p.processName+"/"+p.remainTime+" ");
                    System.out.println();
                    System.out.print(timeCount+"sec : queue2 : ");
                    for(Process p : queueList.get(1))System.out.print(p.processName+"/"+p.remainTime+" ");
                    System.out.println();
                    System.out.print(timeCount+"sec : queue3 : ");
                    for(Process p : queueList.get(2))System.out.print(p.processName+"/"+p.remainTime+" ");
                    System.out.println();
                    System.out.println("==============================");

                    Process currentProcess = queueList.get(q).poll();

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
                    for (int i = 0; i < TQ; i++) {

                        //S 쿨타임이 차면 가장 우선순위 낮은 큐의 가장오래된 프로세스부터 최상위 큐로 push
                        if(sCount == S-1){

                            for(int z = 1; z < queueNum; z++){
                                if(!queueList.get(z).isEmpty()){
                                    int queueSize = queueList.get(z).size();
                                    for(int j = 0 ; j < queueSize ; j++){
                                        queueList.get(0).addFirst(queueList.get(z).pollLast());
                                    }
                                }
                            }
                            sCount = 0;
                        }

                        //1초씩 진행하면서 arrivalTime이 된 다음 프로세스있는지 확인
                        for (int j = 1; j < inputProcessCount; j++) {
                            if (inputProcess[j].arrivalTime == timeCount+1) {

                                //도착한 프로세스는 무조건 최상단 큐에 들어감
                                queueList.get(0).addFirst(inputProcess[j]);
                            }
                        }

                        //1초씩 remain 타임 감소, 보드판 진행, 타임카운트증가
                        currentProcess.remainTime--;
                        board[processIdx][timeCount] = " 1 ";
                        timeCount++;
                        sCount++;



                    }

                    //남은시간이 0이 아니고
                    if (currentProcess.remainTime != 0) {
                        //cpuRetrunTime이 TQ 보다 작다면 현재 우선순위 큐 유지
                        if(currentProcess.cpuReturnTime < TQ) {
                            queueList.get(q).offerLast(currentProcess);
                        }else //cpuRetrunTime이 TQ 크거나 같다면 우선순위 강등
                        {
                           if(q+1==queueNum) queueList.get(q).offerLast(currentProcess);
                           else queueList.get(q+1).offerLast(currentProcess);
                        }
                    } else {
                        //남은시간이 0이면 종료된 프로세스 카운트 증가
                        completedProcessCount++;
                    }

                    //어느 큐에서 작업했으면 다음 큐로 넘어가지 않고 일단 그 큐 계속
                    break;
                }
            }
        }

        //출력
        System.out.println("\n------------------- [ MLFQ TQ : " + TQ + " ] -------------------");
        process.printBoard(board, inputProcess, totalTime);
    }
}



