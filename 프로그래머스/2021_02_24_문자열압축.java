import java.util.*;
class Solution {
    public int solution(String s) {
        if(s.length()==1) {
			return 1;
		}
        int answer = Integer.MAX_VALUE;
        for(int i = 1; i <= s.length()/2; i++) {
			int res = go(i,s);
			if(res < answer) {
				answer = res;
			}
		}
        return answer;
    }
    private static int go(int i, String s) {
		Stack<String> stk = new Stack<>();
		int cnt = 0;
		String ans_str = "";
		String str = "";
		for(int j = 0; j < s.length(); j++) {
			cnt++;
			str+=s.charAt(j);
//			System.out.println(cnt+" "+str);
			if(cnt == i) {
				cnt = 0;
				if(!stk.isEmpty()) {
					if(stk.peek().equals(str)) {
						stk.push(str);
					}
					else {
						int stk_cnt = 0;
						String stk_string = stk.peek();
						while(!stk.isEmpty()) {
							stk.pop();
							stk_cnt++;
						}
						stk.push(str);
//						System.out.println(stk_string);
						if(stk_cnt == 1) {
							ans_str += stk_string;
						}
						else {
							ans_str += stk_cnt+stk_string;
						}
					}
				}
				else {
					stk.push(str);
				}
				str ="";
			}
		}
		if(!str.equals("")) {
			if(!stk.isEmpty()) {
				if(stk.peek().equals(str)) {
					stk.push(str);
				}
				else {
					int stk_cnt = 0;
					String stk_string = stk.peek();
					while(!stk.isEmpty()) {
						stk.pop();
						stk_cnt++;
					}
					stk.push(str);
//					System.out.println(stk_string);
					if(stk_cnt == 1) {
						ans_str += stk_string;
					}
					else {
						ans_str += stk_cnt+stk_string;
					}
				}
			}
			else {
				stk.push(str);
			}
		}
		int stk_cnt = 0;
		if(!stk.isEmpty()) {
			String stk_string = stk.peek();
			while(!stk.isEmpty()) {

				stk_cnt++;
				stk.pop();
			}
			if(stk_cnt == 1) {
				ans_str += stk_string;
			}
			else {
				ans_str += stk_cnt+stk_string;
			}
		}
//		System.out.println(ans_str);
		return ans_str.length();
	}
}
