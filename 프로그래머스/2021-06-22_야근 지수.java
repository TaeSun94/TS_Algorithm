/*
정확성  테스트
테스트 1 〉	통과 (0.67ms, 52.8MB)
테스트 2 〉	통과 (0.61ms, 52.4MB)
테스트 3 〉	통과 (0.38ms, 52.4MB)
테스트 4 〉	통과 (0.65ms, 51.8MB)
테스트 5 〉	통과 (0.57ms, 52.9MB)
테스트 6 〉	통과 (0.60ms, 55MB)
테스트 7 〉	통과 (0.65ms, 52MB)
테스트 8 〉	통과 (3.02ms, 52.4MB)
테스트 9 〉	통과 (5.80ms, 52.8MB)
테스트 10 〉	통과 (0.61ms, 52.4MB)
테스트 11 〉	통과 (0.55ms, 52.7MB)
테스트 12 〉	통과 (0.74ms, 53.3MB)
테스트 13 〉	통과 (0.52ms, 53MB)
효율성  테스트
테스트 1 〉	통과 (133.62ms, 68MB)
테스트 2 〉	통과 (118.63ms, 68.5MB)
채점 결과
정확성: 86.7
효율성: 13.3
합계: 100.0 / 100.0
*/
import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int work: works){
            pq.add(work);
        }
        for(int i = 0; i < n ; i++){
            if(pq.isEmpty())
                break;
            int num = pq.poll();
            num-=1;
            if(num < 1)
                continue;
            pq.add(num);
        }
        while(!pq.isEmpty()){
            answer += Math.pow(pq.poll(),2);
        }
        return answer;
    }
}
