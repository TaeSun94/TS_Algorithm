/*
정확성  테스트
테스트 1 〉	통과 (4.23ms, 52.1MB)
테스트 2 〉	통과 (3.78ms, 52.3MB)
테스트 3 〉	통과 (5.10ms, 51.9MB)
테스트 4 〉	통과 (3.99ms, 52.1MB)
테스트 5 〉	통과 (4.63ms, 52.6MB)
테스트 6 〉	통과 (1.19ms, 52.1MB)
테스트 7 〉	통과 (3.67ms, 52.7MB)
테스트 8 〉	통과 (2.71ms, 53.8MB)
테스트 9 〉	통과 (3.31ms, 52.2MB)
테스트 10 〉	통과 (4.65ms, 53MB)
테스트 11 〉	통과 (1.32ms, 52.9MB)
테스트 12 〉	통과 (1.16ms, 52MB)
테스트 13 〉	통과 (1.47ms, 52.4MB)
테스트 14 〉	통과 (1.25ms, 52.5MB)
테스트 15 〉	통과 (1.20ms, 52.8MB)
테스트 16 〉	통과 (1.17ms, 53.2MB)
테스트 17 〉	통과 (1.21ms, 52.1MB)
테스트 18 〉	통과 (1.39ms, 52.5MB)
테스트 19 〉	통과 (1.14ms, 52.9MB)
테스트 20 〉	통과 (1.87ms, 52.9MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
*/
import java.util.*;
class Solution {
    static class Task implements Comparable<Task>{
        int start, time;
        Task(int start, int time){
            this.start = start;
            this.time = time;
        }
        public int compareTo(Task t){
            return this.time-t.time;
        }
    }
    public int solution(int[][] jobs) {
        int answer = 0;
        LinkedList<Task> list = new LinkedList<>();
        for(int i = 0; i < jobs.length; i++){
            list.add(new Task(jobs[i][0],jobs[i][1]));
        }

        Collections.sort(list, new Comparator<Task>(){
            public int compare(Task t1, Task t2){
                return t1.start - t2.start;
            }
        });

        PriorityQueue<Task> pq = new PriorityQueue<>();
        int count = 0;
        int time = list.peek().start;
        while(count< jobs.length){
            while(!list.isEmpty() && list.peek().start <= time){
                pq.offer(list.pollFirst());
            }
            if(!pq.isEmpty()){
                Task task = pq.poll();
                time += task.time;
                answer += time - task.start;
                count++;
            }
            else
                time++;
        }
        return answer/count;
    }
}
