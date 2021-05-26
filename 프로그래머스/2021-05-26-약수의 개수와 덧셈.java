import java.util.*;
class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i = left; i <= right; i++){
            double num = Math.sqrt(i);
            if(num%1 != 0.0){
                answer += i;
            }
            else{
                answer -= i;
            }
        }
        return answer;
    }
}
