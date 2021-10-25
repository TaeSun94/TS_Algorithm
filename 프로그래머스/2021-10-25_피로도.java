/*
정확성  테스트
테스트 1 〉	통과 (0.03ms, 84.6MB)
테스트 2 〉	통과 (0.03ms, 73.4MB)
테스트 3 〉	통과 (0.03ms, 84.4MB)
테스트 4 〉	통과 (0.09ms, 75.6MB)
테스트 5 〉	통과 (0.36ms, 73.5MB)
테스트 6 〉	통과 (0.90ms, 76.8MB)
테스트 7 〉	통과 (1.63ms, 76.1MB)
테스트 8 〉	통과 (2.95ms, 77.3MB)
테스트 9 〉	통과 (0.03ms, 76.1MB)
테스트 10 〉	통과 (0.34ms, 75.8MB)
테스트 11 〉	통과 (0.03ms, 77MB)
테스트 12 〉	통과 (0.61ms, 75.6MB)
테스트 13 〉	통과 (0.13ms, 76.2MB)
테스트 14 〉	통과 (0.06ms, 77.3MB)
테스트 15 〉	통과 (0.07ms, 78.2MB)
테스트 16 〉	통과 (0.04ms, 76.4MB)
테스트 17 〉	통과 (0.06ms, 76.1MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
*/
import java.util.*;
class Solution {
    static int max = 0;
    static boolean[] check;
    public int solution(int k, int[][] dungeons) {
        check = new boolean[dungeons.length];
        dfs(0,k,dungeons);

        return max;
    }
    public void dfs(int cnt,int k, int[][] dungeons){
        if(dungeons.length == cnt){
            max = Math.max(cnt, max);
            return;
        }
        for(int i = 0; i < check.length; i++){
            if(!check[i]&& dungeons[i][0] <= k){
                check[i] = true;
                dfs(cnt+1, k-dungeons[i][1], dungeons);
                check[i] = false;
            }
        }
        max = Math.max(cnt,max);
    }
}
