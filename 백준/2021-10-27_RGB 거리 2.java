package 쩜문제추천;

import java.util.*;

public class RGB거리2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] input = new int[N+1][3];

		for(int i = 1; i <= N; i++) {
			input[i][0] = sc.nextInt();
			input[i][1] = sc.nextInt();
			input[i][2] = sc.nextInt();
		}

		int ans = Integer.MAX_VALUE;
		int[][] mem = new int[N+1][3];
		for(int k = 0; k < 3; k++) {
			for(int i = 0; i < 3; i++) {
				if(i==k) mem[1][i] = input[1][i];
				else mem[1][i] = 987654321;
			}
			for(int i = 2; i <= N; i++) {
				mem[i][0] = Math.min(mem[i-1][1], mem[i-1][2])+input[i][0];
				mem[i][1] = Math.min(mem[i-1][0], mem[i-1][2])+input[i][1];
				mem[i][2] = Math.min(mem[i-1][0], mem[i-1][1])+input[i][2];
			}
			for(int i = 0; i < 3; i++) {
				if(i!=k)
					ans = Math.min(mem[N][i],ans);
			}
		}

		System.out.println(ans);
	}
}
