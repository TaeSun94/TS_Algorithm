package 프로그래머스;

import java.util.*;
/*
answer = 3648
answer = 0
input {'A','C','F','J','M','N','R','T'};
*/

public class 단체사진찍기 {
	static char[] input= { 'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T' };
	static int answer;

	public static void main(String[] args) {
		int n = 2;
		String[] data = {"N~F=0","R~T>2"};
//		String[] data = { "M~C<2", "C~M>1" };
		answer = 0;
		// 조건이 가능한 조건인지 확인

		// 8개를 돌리는 순열을 통하여 조건에 맞는지 확인 후 넘기기(nextpermutaion이 제일 좋아보이긴함)
		perm(0, data);
		System.out.println(answer);
	}

	static void perm(int idx, String[] data) {
		if (idx == input.length) {
			if (checkCondition(data)) {
				answer++;
			}
			return;
		}
		for (int i = idx; i < input.length; i++) {
			swap(idx, i);
			perm(idx + 1, data);
			swap(idx, i);
		}
	}

	private static boolean checkCondition(String[] data) {
		for (int i = 0; i < data.length; i++) {
			char from = data[i].charAt(0);
			char to = data[i].charAt(2);
			char oper = data[i].charAt(3);
			int num = data[i].charAt(4) - '0';
			int from_pos = 0;
			int to_pos = 0;
			for (int j = 0; j < input.length; j++) {
				if (input[j] == from) {
					from_pos = j;
				} else if (input[j] == to) {
					to_pos = j;
				}
			}
			int tmp = Math.abs(from_pos - to_pos)-1;
			if (oper == '<') {
				if (tmp >= num)
					return false;
			} else if (oper == '=') {
				if (tmp != num)
					return false;
			} else if (oper == '>') {
				if (tmp <= num)
					return false;
			}
		}
		return true;
	}

	private static void swap(int idx, int i) {
		// TODO Auto-generated method stub
		char tmp = input[idx];
		input[idx] = input[i];
		input[i] = tmp;
	}
}


/*
로직 : 모든 카카오 프렌즈를 순열을 통하여 줄세우기를 한 뒤에 조건에 맞는 경우 +1 증가하여 결과 도출

아쉬운 점 : 처음 분기로 조건을 검사하여 성립이 되지않은 조건들을 찾아내 결과를 0으로 출력하게 될 경우 시간 단축에 도움이 될꺼라 생각된다. 그리고 순열을 통하여 swap함수를 진행할떼 조건에 맞지 않은 경우 return하여 조금 더 좋은 코드를 만들 수 있을거라 생각된다.
*/
