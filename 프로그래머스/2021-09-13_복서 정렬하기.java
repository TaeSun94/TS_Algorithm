/*
정확성  테스트
테스트 1 〉	통과 (0.53ms, 58.3MB)
테스트 2 〉	통과 (0.48ms, 59.9MB)
테스트 3 〉	통과 (0.55ms, 69.4MB)
테스트 4 〉	통과 (0.50ms, 71.2MB)
테스트 5 〉	통과 (0.51ms, 69.6MB)
테스트 6 〉	통과 (18.00ms, 79.5MB)
테스트 7 〉	통과 (20.86ms, 76.4MB)
테스트 8 〉	통과 (21.73ms, 62.5MB)
테스트 9 〉	통과 (12.75ms, 72.7MB)
테스트 10 〉	통과 (12.34ms, 74.9MB)
테스트 11 〉	통과 (20.15ms, 78.4MB)
테스트 12 〉	통과 (13.04ms, 74.8MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
*/
import java.util.*;
class Solution {
    static class Player implements Comparable<Player>{
        int number, winCnt, weight;
        double rate;
        Player(int number, int winCnt, int weight, double rate){
            this.number =number;
            this.winCnt = winCnt;
            this.weight = weight;
            this.rate = rate;
        }
        public int compareTo(Player p){
            if(this.rate*100 == p.rate*100){
                if(this.winCnt == p.winCnt){
                    if(this.weight == p.weight){
                        return this.number-p.number;
                    }
                    return -(this.weight-p.weight);
                }
                return -(this.winCnt-p.winCnt);
            }
            return (this.rate*100>p.rate*100) ? -1:1;
        }
    }
    public int[] solution(int[] weights, String[] head2head) {
        int[] answer = new int[weights.length];
        PriorityQueue<Player> pq = new PriorityQueue<>();
        for(int i = 0; i < head2head.length; i++){
            int weight = weights[i];
            double total_win = 0;
            int overWeight = 0;
            double cnt = 0;
            for(int j = 0; j < head2head[i].length(); j++){
                if(i==j)
                    continue;
                if(head2head[i].charAt(j)=='N')
                    continue;
                cnt++;
                if(head2head[i].charAt(j)=='W'){
                    total_win++;
                    if(weight < weights[j]){
                        overWeight++;
                    }
                }
            }
            if(cnt == 0){
                pq.add(new Player(i+1,overWeight, weight,0));
                continue;
            }
            pq.add(new Player(i+1,overWeight, weight,(double)(total_win*100/cnt)));
        }
        int idx = 0;
        while(!pq.isEmpty()){
            Player p = pq.poll();
            answer[idx++] = p.number;
        }
        return answer;
    }
}
