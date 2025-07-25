import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        String str = storey + "";
        boolean upper = false;
        
        for (int i = str.length() - 1; i >= 0; i--) {
            int num = str.charAt(i) - '0';
            num = upper ? num + 1 : num;
            if (num < 5) {
                answer += num;
                upper = false;
            } else if (num == 5) {
                answer += num;
                if (i == 0) {
                    upper = false;
                } else {
                    int nextNum = str.charAt(i-1) - '0' + 1;
                    if (nextNum > 5) {
                        upper = true;
                    } else {
                        upper = false;
                    }
                }
            } else {
                answer += 10 - num;
                upper = true;
            }
        }
        
        return upper ? answer + 1 : answer;
    }
}
