/*
정확성  테스트
테스트 1 〉	통과 (0.05ms, 52.2MB)
테스트 2 〉	통과 (0.06ms, 53.1MB)
테스트 3 〉	통과 (0.08ms, 52.4MB)
테스트 4 〉	통과 (0.48ms, 53MB)
테스트 5 〉	통과 (1.03ms, 52.8MB)
테스트 6 〉	통과 (2.55ms, 52.6MB)
테스트 7 〉	통과 (7.05ms, 52.9MB)
테스트 8 〉	통과 (15.15ms, 57.2MB)
테스트 9 〉	통과 (15.38ms, 55.4MB)
테스트 10 〉	통과 (17.33ms, 57.7MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
*/
import java.util.*;
class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] graph = new int[n+1][n+1];
        for(int[] arr: graph){
            Arrays.fill(arr,Integer.MAX_VALUE);
        }
        for(int i =0; i < results.length; i++){
            graph[results[i][0]][results[i][1]] = 1;
            graph[results[i][1]][results[i][0]] = -1;
        }
        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    if(graph[i][j] == Integer.MAX_VALUE){
                        if(graph[i][k] == 1 && graph[k][j] == 1)
                            graph[i][j] = 1;
                        if(graph[i][k] == -1 && graph[k][j] == -1)
                            graph[i][j] = -1;
                    }
                }
            }
        }
        for(int i = 1; i <= n; i++){
            boolean flag = false;
            for(int j = 1; j <= n; j++){
                if(i!=j && graph[i][j] == Integer.MAX_VALUE){
                    flag = true;
                    break;
                }
            }
            if(!flag)
              answer++;
        }
        return answer;
    }
}
