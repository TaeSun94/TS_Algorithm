/*
정확성  테스트
테스트 1 〉	통과 (0.21ms, 53MB)
테스트 2 〉	통과 (0.26ms, 52.2MB)
테스트 3 〉	통과 (0.24ms, 52.4MB)
테스트 4 〉	통과 (0.29ms, 53.6MB)
테스트 5 〉	통과 (0.36ms, 52.6MB)
테스트 6 〉	통과 (0.49ms, 52.8MB)
테스트 7 〉	통과 (0.85ms, 52.8MB)
테스트 8 〉	통과 (1.19ms, 53.6MB)
테스트 9 〉	통과 (6.11ms, 55.9MB)
테스트 10 〉	통과 (3.92ms, 55.3MB)
테스트 11 〉	통과 (4.29ms, 58.5MB)
테스트 12 〉	통과 (12.67ms, 66.8MB)
테스트 13 〉	통과 (9.63ms, 79.1MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
*/
import java.util.*;
class Solution {
    static class Move{
        int before, after;
        Move(int before, int after){
            this.before = before;
            this.after = after;
        }
    }
    static ArrayList<Move> al;
    public int[][] solution(int n) {
        al = new ArrayList<>();
        Hanoi(n,1,2,3);
        int[][] answer = new int[al.size()][2];
        int idx = 0;
        for(Move m : al){
            answer[idx][0] = m.before;
            answer[idx][1] = m.after;
            idx++;
        }
        return answer;
    }
    public void Hanoi(int n, int first, int second, int third){
        if(n == 1){
            al.add(new Move(first,third));
            return;
        }
        Hanoi(n-1,first,third, second);
        al.add(new Move(first,third));
        Hanoi(n-1, second, first, third);
    }
}
