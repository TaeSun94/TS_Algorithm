/*
정확성  테스트
테스트 1 〉	통과 (0.03ms, 71.5MB)
테스트 2 〉	통과 (0.05ms, 73.2MB)
테스트 3 〉	통과 (0.35ms, 69.1MB)
테스트 4 〉	통과 (0.23ms, 58.8MB)
테스트 5 〉	통과 (0.23ms, 68.4MB)
테스트 6 〉	통과 (0.22ms, 71.6MB)
테스트 7 〉	통과 (0.21ms, 72.9MB)
테스트 8 〉	통과 (0.33ms, 72.3MB)
테스트 9 〉	통과 (0.37ms, 60.7MB)
테스트 10 〉	통과 (0.20ms, 72.6MB)
테스트 11 〉	통과 (0.23ms, 71.2MB)
테스트 12 〉	통과 (0.60ms, 58.8MB)
테스트 13 〉	통과 (0.17ms, 72.5MB)
테스트 14 〉	통과 (0.98ms, 58.2MB)
테스트 15 〉	통과 (0.61ms, 71.4MB)
테스트 16 〉	통과 (1.07ms, 71MB)
테스트 17 〉	통과 (0.04ms, 69.9MB)
테스트 18 〉	통과 (0.03ms, 73.3MB)
테스트 19 〉	통과 (0.28ms, 59.7MB)
테스트 20 〉	통과 (0.36ms, 74.7MB)
테스트 21 〉	통과 (0.40ms, 73.1MB)
효율성  테스트
테스트 1 〉	통과 (52.37ms, 87.9MB)
테스트 2 〉	통과 (46.29ms, 87.7MB)
채점 결과
정확성: 69.3
효율성: 30.7
합계: 100.0 / 100.0
*/
import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = 1;
        int len = s.length();
        char[] array = s.toCharArray();
        int[][] mem = new int[len][len];
        for(int i = 0; i<len; i++){
            mem[i][i] = 1;
        }
        for(int i = 0; i < len-1; i++){
            if(array[i] == array[i+1]){
                mem[i][i+1] = 1;
                answer = 2;
            }
        }
        for(int i = 3; i <= len; i++){
            for(int j = 0; j<=len-i; j++){
                if(array[j]==array[i+j-1] && mem[j+1][i+j-2]==1){
                    mem[j][i+j-1] = 1;
                    answer = Math.max(answer,i);
                }
            }
        }
        return answer;
    }
}
