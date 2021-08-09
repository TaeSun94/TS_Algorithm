/*
정확성  테스트
테스트 1 〉	통과 (9.20ms, 74.2MB)
테스트 2 〉	통과 (9.71ms, 70.6MB)
테스트 3 〉	통과 (13.16ms, 57.5MB)
테스트 4 〉	통과 (16.70ms, 69.2MB)
테스트 5 〉	통과 (13.51ms, 65.3MB)
테스트 6 〉	통과 (9.20ms, 66.5MB)
테스트 7 〉	통과 (54.25ms, 73.4MB)
테스트 8 〉	통과 (12.98ms, 68.3MB)
테스트 9 〉	통과 (17.08ms, 58.5MB)
테스트 10 〉	통과 (8.75ms, 58.8MB)
테스트 11 〉	통과 (12.63ms, 59.5MB)
테스트 12 〉	통과 (12.09ms, 57.9MB)
테스트 13 〉	통과 (9.00ms, 73.3MB)
테스트 14 〉	통과 (11.92ms, 57.1MB)
테스트 15 〉	통과 (9.21ms, 58.1MB)
테스트 16 〉	통과 (12.67ms, 72.3MB)
테스트 17 〉	통과 (13.12ms, 58.2MB)
테스트 18 〉	통과 (13.77ms, 73.6MB)
테스트 19 〉	통과 (13.54ms, 57.9MB)
테스트 20 〉	통과 (8.87ms, 57.4MB)
테스트 21 〉	통과 (10.93ms, 58.8MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
*/
import java.util.*;
class Solution {
    public String solution(int[][] scores) {
        String answer = "";
        for(int j = 0; j < scores.length; j++){
            int sum = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            int max = 0;
            int len = scores.length;
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < scores.length; i++){
                sum += scores[i][j];
                if(map.containsKey(scores[i][j])){
                    map.replace(scores[i][j], map.get(scores[i][j])+1);
                }
                else{
                    map.put(scores[i][j],1);
                }
                max = Math.max(max, scores[i][j]);
                min = Math.min(min, scores[i][j]);
            }
            if(max == scores[j][j]){
                if(map.get(scores[j][j])==1){
                    sum -= scores[j][j];
                    len--;
                }
            }
            if(min == scores[j][j]){
                if(map.get(scores[j][j])==1){
                    sum -= scores[j][j];
                    len--;
                }
            }
            answer += check(sum/len);
        }
        return answer;
    }
    public char check(double avg){
        char ans = ' ';
        if(avg >= 90){
            ans = 'A';
        }
        else if(avg >= 80 && avg < 90){
            ans = 'B';
        }
        else if(avg >= 70 && avg < 80){
            ans = 'C';
        }
        else if(avg >=50 && avg < 70){
            ans = 'D';
        }
        else
            ans = 'F';

        return ans;
    }
}
