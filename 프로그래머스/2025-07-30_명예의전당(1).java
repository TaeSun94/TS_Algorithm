import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        // K까진 넣기 -> 우선순위 Que로 낮은거부터 올리기
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < score.length; i++) {
            if (pq.size() == k) {
                if (pq.peek() < score[i]) {
                    pq.poll();
                    pq.add(score[i]);
                }
            } else {
                pq.add(score[i]);   
            }
            answer[i] = pq.peek();
        }

        return answer;
    }
}
