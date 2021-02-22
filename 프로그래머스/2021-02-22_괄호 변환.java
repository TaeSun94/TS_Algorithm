package 프로그래머스;

import java.util.*;

public class 괄호변환 {

	public static void main(String[] args) {
		String p = "()))((()";
//		String answer = "";
		String answer = balanceString(p);
		System.out.println(answer);
	}

	private static String balanceString(String str) {
		//빈 문자열의 경우 빈 문자열 반환
		if(str.length()==0)
			return "";

		//문자열 w를 두 균형잡힌 괄호 문자열 u,v로 분리
		int cnt = 0;
		boolean flag = false;
		String u = "";
		String v = "";
		for(int i = 0; i < str.length(); i++) {
			if(!flag) {
				if(str.charAt(i)== '(')
					cnt += 1;
				else
					cnt -= 1;
				u += str.charAt(i);
				if(cnt == 0) {
					flag = true;
				}
				continue;
			}
			v += str.charAt(i);
		}
		if(!isCorrect(u)) {
			String tmp = "(";
			tmp += balanceString(v);
			tmp += ')';
			if(u.length()==2) {
				u = "";
			}
			else {
				u = u.substring(1, u.length()-1);
			}
			String reverse_u = "";
			for(int i = 0; i < u.length(); i++) {
				if(u.charAt(i)=='(') {
					reverse_u += ')';
				}
				else {
					reverse_u += '(';
				}
			}
			return tmp+reverse_u;
		}
		else {
			return u + balanceString(v);
		}
	}

	private static boolean isCorrect(String u) {
		int open = 0;
		int close = 0;
		for(int i = 0; i < u.length(); i++) {
			if(open < close)
				return false;
			if(u.charAt(i)=='(') {
				open++;
			}
			else
				close++;
		}
		return true;
	}
}
