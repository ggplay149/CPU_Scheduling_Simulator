# CPU_Scheduling_Simulator

<br>

CPU 스케쥴링 알고리즘 구현 시뮬레이터

사용한 프로세스 예시)

![image](https://github.com/user-attachments/assets/fb10158b-4b10-4b48-a9c0-df41a91ee083)



<br>



<details>

<summary> 비선점 스케쥴링 </summary>  

<br>
<br>

비선점 스케쥴링?

- 자원을 어떤 프로세스가 사용하고 있다면 다른 프로세스가 우선순위 여부와 상관없이 자원을 뺏을 수 없음
- 비효율 context switching 으로 인한 오버헤드가 적음
  




   <br>
  
 > FCFS (FIFO)


 
 ![image](https://github.com/user-attachments/assets/58a86866-c886-4f27-8e2f-311414f499af)



-  도착시간 순으로 프로세스 처리
-  앞선 프로세스 서비스가 길다면 뒤에 짧은 프로세스들이 길게 기다려야함 (호위효과)


 <br>
 
  > SJF


 
![image](https://github.com/user-attachments/assets/520d171a-8253-485b-8273-96860e556b17)


-  작업 소요시간이 적은순으로 프로세스 처리
-  짧은 프로세스가 계속 들어올경우 이론적으로 긴 프로세스는 무한대기할 가능성이 있음 (기아현상)
-  대기시간을 대비하여 우선순위를 적용한 HRN 알고리즘 혹은
-  일정주기로 오래된 프로세스에게 우선순위 스코어를 주는 Aging 을 통해 개선할수 있음

<br>
 
</details>


<details>

<summary> 선점 스케쥴링 </summary>  

<br>
<br>

선점 스케쥴링?

- 우선순위가 높은 프로세스가 현재 프로세스를 중지시키고 자신이 자원을 점유할수 있음
- 호율적이고 응답시간이 빠르지만 context switching 으로인한 오버헤드가 있음
- 전체적으로 얼만큼의 시간이 걸릴지 파악가
  


  
    <br>
  
 > Round_Robin 


 
 ![image](https://github.com/user-attachments/assets/7ea12cd4-ecdf-478e-89ab-0c745b52e876)


-  일정 주기 (TQ) 씩 프로세스들을 context switching 하며 처리
-  TQ가 너무 길경우 FCFS와 다를바 없어짐
-  TQ가 너무 짧을경우 잦은 context switching 으로 인한 오버헤드 발생
-  모든 프로게스가 균등히 진행됨으로 기아현상 없음


 <br>
 
  > SRT


 
![image](https://github.com/user-attachments/assets/746800f4-6f69-47d6-9682-472ebdac5a02)


-  남은 소요시간을 우선순위 선점형으로 처리
-  SJF와 마찬가지로 짧은 프로세스가 계속 들어올경우 기아현상 발생함

<br>

  > MLFQ


 
![image](https://github.com/user-attachments/assets/21dcebff-f61a-474a-beee-9c5d8f5ffc8f)


-  우선순위를 구분한 큐를 여러개 두고 조건에 따라 프로세스가 큐사이를 이동
-  각 큐는 각각의 우선순위와 TQ를 가질수 있음
-  각 큐는 RoundRobin 알고리즘으로 큐를 프로세스 처리
-  상위 큐에 프로세스가 없을시 하위 큐를 처리

<br>
  

-  처음 삽입된 프로세스는 가장 최우선순위 큐에 삽입
-  TQ 시간 내에 CPU 자원을 반납할경우 현재 우선순위 큐에 다시 삽입
-  (예시에서는 위 조건대신 전체 큐에 프로세스가 1개만 존재할시 최우선큐로 삽입되는것으로 대체)
-  TQ 시간 내에 작업을 처리하지 못할경우 한단계 아래 우선순위 큐로 강등
-  강등으로 인한 기아현상을 방지하기위해 일정주기로(S) 부스팅
-  S주기 마다 오래 기다린순으로 프로세스들을 최우선 큐로 이동 (기아현상 방지)
-  (예시에서 S = -1 면, 부스팅 주기가 없는것으로 함) 

<br>
 
</details>

