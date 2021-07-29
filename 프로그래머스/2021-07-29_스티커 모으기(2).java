/*
Frist Try -> 완전탐색을 이용한 풀이
정확성  테스트
테스트 1 〉	실패 (0.03ms, 52MB)
테스트 2 〉	통과 (0.02ms, 52.4MB)
테스트 3 〉	통과 (0.08ms, 52.7MB)
테스트 4 〉	실패 (0.06ms, 51.7MB)
테스트 5 〉	실패 (0.13ms, 52.1MB)
테스트 6 〉	실패 (0.41ms, 52.1MB)
테스트 7 〉	실패 (시간 초과)
테스트 8 〉	실패 (시간 초과)
테스트 9 〉	실패 (시간 초과)
테스트 10 〉	실패 (시간 초과)
테스트 11 〉	실패 (시간 초과)
테스트 12 〉	실패 (시간 초과)
테스트 13 〉	실패 (시간 초과)
테스트 14 〉	실패 (시간 초과)
테스트 15 〉	실패 (시간 초과)
테스트 16 〉	실패 (시간 초과)
테스트 17 〉	실패 (시간 초과)
테스트 18 〉	실패 (시간 초과)
테스트 19 〉	실패 (시간 초과)
테스트 20 〉	실패 (시간 초과)
테스트 21 〉	실패 (시간 초과)
테스트 22 〉	실패 (시간 초과)
테스트 23 〉	실패 (시간 초과)
테스트 24 〉	실패 (시간 초과)
테스트 25 〉	실패 (시간 초과)
테스트 26 〉	실패 (시간 초과)
테스트 27 〉	실패 (시간 초과)
테스트 28 〉	실패 (시간 초과)
테스트 29 〉	실패 (시간 초과)
테스트 30 〉	실패 (시간 초과)
테스트 31 〉	실패 (시간 초과)
테스트 32 〉	실패 (시간 초과)
테스트 33 〉	실패 (0.03ms, 54MB)
효율성  테스트
테스트 1 〉	실패 (시간 초과)
테스트 2 〉	실패 (시간 초과)
테스트 3 〉	실패 (시간 초과)
테스트 4 〉	실패 (시간 초과)
채점 결과
정확성: 3.0
효율성: 0.0
합계: 3.0 / 100.0
*/
import java.util.*;
class Solution {
    static int max, cnt;
    public int solution(int sticker[]) {
        int answer = 0;
        max = 0;
        cnt = (sticker.length-3)%2==0 ? (sticker.length-3)/2+1 : (sticker.length-3)/2+2;
        dfs(0,0,0, sticker, new int[sticker.length]);
        return max;
    }
    public void dfs(int idx, int count, int sum, int[] sticker, int[] check){
        if(count == cnt){
            max = max < sum ? sum : max;
            return;
        }
        for(int i = idx; i < sticker.length; i++){
            if(check[i]==0){
                check[i]++;
                if(i+1 >= sticker.length){
                    check[0]++;
                }
                else
                    check[i+1]++;
                if(i-1<0){
                    check[sticker.length-1]++;
                }
                else
                    check[i-1]++;
                dfs(i, count+1, sum+sticker[i], sticker, check);
                check[i]--;
                if(i+1 >= sticker.length){
                    check[0]--;
                }
                else
                    check[i+1]--;
                if(i-1<0){
                    check[sticker.length-1]--;
                }
                else
                    check[i-1]--;
            }
        }
    }
}
/*
Second Try -> using DP
정확성  테스트
테스트 1 〉	통과 (0.04ms, 52.9MB)
테스트 2 〉	통과 (0.04ms, 53.2MB)
테스트 3 〉	통과 (0.03ms, 52MB)
테스트 4 〉	통과 (0.04ms, 52.6MB)
테스트 5 〉	통과 (0.04ms, 51.9MB)
테스트 6 〉	통과 (0.05ms, 53.3MB)
테스트 7 〉	통과 (0.16ms, 53MB)
테스트 8 〉	통과 (0.18ms, 53.2MB)
테스트 9 〉	통과 (0.26ms, 52.4MB)
테스트 10 〉	통과 (0.18ms, 53.4MB)
테스트 11 〉	통과 (0.17ms, 53.2MB)
테스트 12 〉	통과 (0.16ms, 52.2MB)
테스트 13 〉	통과 (0.18ms, 52MB)
테스트 14 〉	통과 (0.17ms, 52.4MB)
테스트 15 〉	통과 (0.17ms, 52.1MB)
테스트 16 〉	통과 (0.18ms, 52.8MB)
테스트 17 〉	통과 (0.16ms, 53.2MB)
테스트 18 〉	통과 (0.17ms, 53MB)
테스트 19 〉	통과 (0.18ms, 52.5MB)
테스트 20 〉	통과 (0.16ms, 52.4MB)
테스트 21 〉	통과 (0.15ms, 52.6MB)
테스트 22 〉	통과 (0.18ms, 53.1MB)
테스트 23 〉	통과 (0.20ms, 53.1MB)
테스트 24 〉	통과 (0.16ms, 51.9MB)
테스트 25 〉	통과 (0.17ms, 52.6MB)
테스트 26 〉	통과 (0.16ms, 53.3MB)
테스트 27 〉	통과 (0.17ms, 52.1MB)
테스트 28 〉	통과 (0.16ms, 52.9MB)
테스트 29 〉	통과 (0.18ms, 52.8MB)
테스트 30 〉	통과 (0.17ms, 53.6MB)
테스트 31 〉	통과 (0.17ms, 52.4MB)
테스트 32 〉	통과 (0.18ms, 52.7MB)
테스트 33 〉	통과 (0.02ms, 52.1MB)
효율성  테스트
테스트 1 〉	통과 (6.06ms, 55.8MB)
테스트 2 〉	통과 (5.99ms, 56.9MB)
테스트 3 〉	통과 (5.92ms, 56.7MB)
테스트 4 〉	통과 (6.88ms, 57MB)
채점 결과
정확성: 49.7
효율성: 50.3
합계: 100.0 / 100.0
*/
class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        if(sticker.length == 1){
            return sticker[0];
        }
        int[] mem1 = new int[sticker.length];
        mem1[0] = sticker[0];
        mem1[1] = sticker[0];
        for(int i = 2; i < sticker.length-1; i++){
            mem1[i] = Math.max(mem1[i-1], mem1[i-2]+sticker[i]);
        }
        int[] mem2 = new int[sticker.length];
        mem2[0] = 0;
        mem2[1] = sticker[1];
        for(int i = 2; i < sticker.length; i++){
            mem2[i] = Math.max(mem2[i-1], mem2[i-2]+sticker[i]);
        }
        return Math.max(mem1[sticker.length-2],mem2[sticker.length-1]);
    }
}
