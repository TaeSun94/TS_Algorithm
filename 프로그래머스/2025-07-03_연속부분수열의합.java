import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        // 부분 수열의 합을 구할 수 있음 -> elements의 길이만큼
        Set<Integer> set = new HashSet<>();
        
        // 배열을 생성해서 Linear하게 데이터를 더하는 과정
        int[][] dp = new int[elements.length][elements.length];
        
        /*
        1       2       3       4       5       6
        1+2     2+3     3+4     4+5     5+6     6+1
        1+2+3   2+3+4
        */
        for (int i = 0; i < elements.length; i++) {
            dp[0][i] = elements[i];
        }
        
        for (int i = 1; i < elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                int n = i + j;
                if (n >= elements.length) {
                    n -= elements.length;
                }
                dp[i][j] = dp[i-1][j] + dp[0][n];
            }
        }
        
        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                if(set.contains(dp[i][j]))
                    continue;
                set.add(dp[i][j]);
            }
        }
        
        return set.size();
    }
}
