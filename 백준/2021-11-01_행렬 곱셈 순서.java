package 쩜문제추천;
import java.util.*;
public class 행렬곱셈순서 {
	static int[][] input, dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		input = new int[N][2];
		dp = new int[N][N];
		for(int i = 0; i < N; i++) {
			input[i][0] = sc.nextInt();
			input[i][1] = sc.nextInt();
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		System.out.println(go(0,N-1));
	}
	private static int go(int s, int e) {
		// TODO Auto-generated method stub
		if(s == e) return 0;
		if(dp[s][e] != Integer.MAX_VALUE)
			return dp[s][e];
		for(int i = s; i < e; i++) {
			int cost = go(s,i)+go(i+1,e)+input[s][0]*input[i][1]*input[e][1];
			dp[s][e] = Math.min(dp[s][e], cost);
		}
		return dp[s][e];
	}
}
