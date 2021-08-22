/*
정확성  테스트
테스트 1 〉	통과 (1.80ms, 53.6MB)
테스트 2 〉	통과 (28.11ms, 52.9MB)
테스트 3 〉	통과 (13.36ms, 53.7MB)
테스트 4 〉	통과 (2.03ms, 51.7MB)
테스트 5 〉	통과 (2.29ms, 51.9MB)
테스트 6 〉	통과 (1.81ms, 52.9MB)
테스트 7 〉	통과 (2.84ms, 52.5MB)
테스트 8 〉	통과 (1.62ms, 53MB)
테스트 9 〉	통과 (15.71ms, 52.2MB)
테스트 10 〉	통과 (2.68ms, 52.7MB)
테스트 11 〉	통과 (3.37ms, 53MB)
테스트 12 〉	통과 (10.97ms, 52.7MB)
테스트 13 〉	통과 (13.46ms, 53.5MB)
테스트 14 〉	통과 (1.91ms, 52.5MB)
테스트 15 〉	통과 (1.24ms, 53.3MB)
테스트 16 〉	통과 (2.07ms, 53MB)
테스트 17 〉	통과 (5.01ms, 51.9MB)
테스트 18 〉	통과 (3.59ms, 53.3MB)
테스트 19 〉	통과 (4.18ms, 53.1MB)
테스트 20 〉	통과 (2.31ms, 53.1MB)
테스트 21 〉	통과 (2.52ms, 52.4MB)
테스트 22 〉	통과 (24.21ms, 53.5MB)
테스트 23 〉	통과 (15.71ms, 53.3MB)
테스트 24 〉	통과 (5.58ms, 54.3MB)
테스트 25 〉	통과 (2.30ms, 52.4MB)
테스트 26 〉	통과 (2.27ms, 53MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
*/
import java.util.*;
class Solution {
    public String solution(String new_id) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
		//1단계
		new_id = new_id.toLowerCase();
		//2,3,4단계
		for(int i = 0; i < new_id.length(); i++) {
			if((new_id.charAt(i)>='a'&&new_id.charAt(i)<='z')||(new_id.charAt(i)-'0'>=0 && new_id.charAt(i)-'0'<=9)||new_id.charAt(i)=='-'||new_id.charAt(i)=='_') {
				stack.add(new_id.charAt(i));
			}
			else if(new_id.charAt(i)=='.') {
				if(!stack.isEmpty())
					if(stack.peek() != '.')
						stack.add(new_id.charAt(i));
			}
		}
		//5단계와 끝 문자열 . 제거
		if(stack.isEmpty()) {
			answer += "a";
		}
		else {
			while (true) {
				if (stack.peek() != '.')
					break;
				else
					stack.pop();
			}
		}
		while(!stack.isEmpty()) {
			answer = stack.pop()+answer;
		}
		//6,7단계
		if(answer.length()>=16) {
			answer = answer.substring(0, 15);
		}
		else if(answer.length() <=2) {
			while(true) {
				if(answer.length()==3)
					break;
				answer += answer.charAt(answer.length()-1);
			}
		}
		while(true) {
			if(answer.charAt(answer.length()-1)=='.') {
				answer = answer.substring(0,answer.length()-1);
			}
			else
				break;
		}
        return answer;
    }
}
