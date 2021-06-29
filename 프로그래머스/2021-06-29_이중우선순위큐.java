/*
정확성  테스트
테스트 1 〉	통과 (0.63ms, 51.9MB)
테스트 2 〉	통과 (0.53ms, 53.6MB)
테스트 3 〉	통과 (0.79ms, 52.1MB)
테스트 4 〉	통과 (0.73ms, 51.8MB)
테스트 5 〉	통과 (1.09ms, 52MB)
테스트 6 〉	통과 (0.71ms, 52.7MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
*/
import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());

        for(String oper: operations){
            String[] data = oper.split(" ");
            if(data[0].equals("D")){
                if(!minPQ.isEmpty()){
                    if(Integer.parseInt(data[1])==1){
                        int max = maxPQ.poll();
                        minPQ.remove(max);
                    }
                    else{
                        int min = minPQ.poll();
                        maxPQ.remove(min);
                    }
                }
            }
            else{
                minPQ.add(Integer.parseInt(data[1]));
                maxPQ.add(Integer.parseInt(data[1]));
            }
        }
        if(minPQ.size()>0){
            answer[0] = maxPQ.poll();
            answer[1] = minPQ.poll();
        }
        return answer;
    }
}
