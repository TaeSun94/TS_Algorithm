import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int[] weapons = new int [number];
        
        for (int i = 0; i < number; i++) {
            weapons[i] = calc(i+1);
            if (weapons[i] > limit) {
                answer += power;
            } else {
                answer += weapons[i];
            }
        }
        
        return answer;
    }

  // 약수 갯수 찾기
    public int calc(int num) {
        int count = 0;
        for (int i = 1; i * i <= num; i++) {
            if (i * i == num) count++;
            else if (num % i == 0) count += 2;
        }
        
        return count;
    }
}
