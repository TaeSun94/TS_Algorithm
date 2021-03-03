import java.util.*;
class Solution {
    public String solution(int n) {
        String answer = "";
        Stack<Integer> stack = new Stack<Integer>();
		while(n > 3) {
			int bit = n % 3;
			if(bit == 0) {
				stack.add(4);
				n = n/3 - 1;
			}
			else {
				stack.add(bit);
				n /= 3;
			}
		}
        if(n==3) {
			n = 4;
		}
		stack.add(n);
		while(!stack.isEmpty()) {
			answer += stack.pop();
		}
        return answer;
    }
}
