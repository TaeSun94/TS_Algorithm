/*
정확성  테스트
테스트 1 〉	통과 (3.21ms, 52.6MB)
테스트 2 〉	통과 (1.83ms, 53.8MB)
테스트 3 〉	통과 (1.17ms, 52.5MB)
테스트 4 〉	통과 (1.76ms, 52.1MB)
테스트 5 〉	통과 (0.94ms, 53.9MB)
테스트 6 〉	통과 (0.82ms, 52MB)
테스트 7 〉	통과 (2.48ms, 52MB)
테스트 8 〉	통과 (3.19ms, 52.6MB)
테스트 9 〉	통과 (2.56ms, 52.9MB)
테스트 10 〉	통과 (0.82ms, 51.8MB)
테스트 11 〉	통과 (2.57ms, 64.5MB)
테스트 12 〉	통과 (1.17ms, 53MB)
테스트 13 〉	통과 (0.83ms, 52MB)
테스트 14 〉	통과 (2.01ms, 52.3MB)
효율성  테스트
테스트 1 〉	통과 (16.87ms, 52.5MB)
테스트 2 〉	통과 (18.97ms, 52.9MB)
테스트 3 〉	통과 (15.15ms, 53.2MB)
테스트 4 〉	통과 (18.84ms, 54MB)
테스트 5 〉	통과 (26.20ms, 53.4MB)
테스트 6 〉	통과 (19.67ms, 53.3MB)
채점 결과
정확성: 70.0
효율성: 30.0
합계: 100.0 / 100.0
*/
import java.util.*;
class Solution {
    public int solution(int n, int[] money) {
        int answer = 0;
        int[] mem = new int[n+1];
        for(int i = 0; i < money.length; i++){
            mem[money[i]] += 1;
            for(int j = 1; j <= n; j++){
                if(j - money[i]>0){
                    mem[j] += mem[j-money[i]]%1000000007;
                }
            }
        }
        return mem[n];
    }
}
