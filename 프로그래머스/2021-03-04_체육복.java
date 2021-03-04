package 프로그래머스;

import java.util.Arrays;

public class 체육복 {
	static int max;

	public static void main(String[] args) {
		int n = 3;
		int[] lost = { 2 };
		int[] reserve = { 3 };
		int answer = 0;
		max = 0;
		boolean[] check = new boolean[n + 1];
		for (int i = 0; i < lost.length; i++) {
			check[lost[i]] = true;
		}

		dfs(0, n, reserve, check);
		System.out.println(max);
	}

	private static void dfs(int pos, int n, int[] reserve, boolean[] check) {
		if (pos == reserve.length) {
			int cnt = 0;
			for (int i = 1; i < check.length; i++) {
				if (check[i])
					cnt += 1;
			}
			if (n - cnt > max)
				max = n - cnt;
			return;
		}
		if(check[reserve[pos]]) {
			check[reserve[pos]] = false;
			dfs(pos+1,n,reserve,check);
		}
		else {
			if(reserve[pos]==1) {
				if(check[reserve[pos]+1]) {
					check[reserve[pos]+1] = false;
				}
				dfs(pos+1, n, reserve,check);
			}
			else if(reserve[pos]== check.length-1) {
				if(check[reserve[pos]-1]) {
					check[reserve[pos]-1] = false;
				}
				dfs(pos+1, n, reserve,check);
			}
			else {
				boolean flag = false;
				if(check[reserve[pos]-1]) {
					check[reserve[pos]-1] = false;
					dfs(pos+1, n, reserve,check);
					flag = true;
				}
				if(check[reserve[pos]+1]) {
					if(flag) {
						check[reserve[pos]-1] = true;
					}
					check[reserve[pos]+1] = false;
					dfs(pos+1,n,reserve,check);
				}
			}
		}
	}
}
