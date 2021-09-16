/*
정확성  테스트
테스트 1 〉	통과 (0.04ms, 70.6MB)
테스트 2 〉	통과 (0.04ms, 60.6MB)
테스트 3 〉	통과 (0.05ms, 60.4MB)
테스트 4 〉	통과 (0.07ms, 74.9MB)
테스트 5 〉	통과 (0.05ms, 73.3MB)
테스트 6 〉	통과 (0.05ms, 61.2MB)
테스트 7 〉	통과 (0.07ms, 71.5MB)
테스트 8 〉	통과 (0.08ms, 60.2MB)
테스트 9 〉	통과 (0.06ms, 70.4MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
*/
import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < 10; i++){
            set.add(i);
        }
        for(int i = 0; i < numbers.length; i++){
            set.remove(numbers[i]);
        }
        for(int num : set){
            answer += num;
        }
        return answer;
    }
}
