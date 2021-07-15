/*
정확성  테스트
테스트 1 〉	통과 (2.92ms, 53.6MB)
테스트 2 〉	통과 (4.29ms, 54.2MB)
테스트 3 〉	통과 (4.26ms, 54.1MB)
테스트 4 〉	통과 (3.24ms, 54.5MB)
테스트 5 〉	통과 (1.18ms, 53.2MB)
테스트 6 〉	통과 (2.85ms, 53.2MB)
테스트 7 〉	통과 (0.88ms, 53MB)
테스트 8 〉	통과 (0.83ms, 53.3MB)
테스트 9 〉	통과 (2.79ms, 56.3MB)
테스트 10 〉	통과 (3.61ms, 53.2MB)
테스트 11 〉	통과 (3.32ms, 53.4MB)
테스트 12 〉	통과 (3.35ms, 53.2MB)
테스트 13 〉	통과 (4.47ms, 54.7MB)
테스트 14 〉	통과 (0.04ms, 53MB)
효율성  테스트
테스트 1 〉	실패 (시간 초과)
테스트 2 〉	실패 (시간 초과)
테스트 3 〉	실패 (시간 초과)
테스트 4 〉	실패 (시간 초과)
테스트 5 〉	실패 (시간 초과)
테스트 6 〉	통과 (0.04ms, 52MB)
채점 결과
정확성: 70.0
효율성: 5.0
합계: 75.0 / 100.0
*/
import java.util.*;
class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];

        ArrayList<Integer> list = new ArrayList<>();
        int num = n;
        for(int i = 0; i < n; i++){
            if(i == n-1){
                list.add(s);
                continue;
            }
            if(s/num <= 0){
                return new int[]{-1};
            }
            list.add(s/num);
            s -= s/num;
            num-=1;
        }
        Collections.sort(list);
        int idx = 0;
        for(int number: list){
            answer[idx++] = number;
        }
        return answer;
    }
}
