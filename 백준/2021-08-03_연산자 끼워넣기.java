package 쩜문제추천;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 연산자끼워넣기 {
	static char[] oper;
	static int[] numbers;
	static int max,min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		numbers = new int[N];
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		ArrayList<Character> operations = new ArrayList<Character>();
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i < 4; i++) {
			int count = Integer.parseInt(st.nextToken());
			switch(i) {
				case 0:
					for(int j = 0; j < count; j++) {
						operations.add('+');
					}
					break;
				case 1:
					for(int j = 0; j < count; j++) {
						operations.add('-');
					}
					break;
				case 2:
					for(int j = 0; j < count; j++) {
						operations.add('*');
					}
					break;
				case 3:
					for(int j = 0; j < count; j++) {
						operations.add('/');
					}
					break;
			}
		}

		oper = new char[operations.size()];
		int idx = 0;
		for(char c:operations) {
			oper[idx++] = c;
		}
		perm(0);
		bw.write(max+"\n");
		bw.write(min+"\n");
		bw.flush();
		bw.close();
	}
	private static void perm(int idx) {
		// TODO Auto-generated method stub
		if(idx == oper.length) {
			int calc = numbers[0];
			for(int i = 0; i < oper.length; i++) {
				switch(oper[i]) {
					case '+':
						calc += numbers[i+1];
						break;
					case '-':
						calc -= numbers[i+1];
						break;
					case '*':
						calc *= numbers[i+1];
						break;
					case '/':
						calc /= numbers[i+1];
						break;
				}
			}
			max = Math.max(max, calc);
			min = Math.min(min, calc);
			return;
		}
		for(int i = idx; i < oper.length; i++) {
			swap(idx,i);
			perm(idx+1);
			swap(idx,i);
		}
	}
	private static void swap(int idx, int i) {
		// TODO Auto-generated method stub
		char tmp = oper[idx];
		oper[idx] = oper[i];
		oper[i] = tmp;
		return;
	}
}
