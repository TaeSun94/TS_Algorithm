package 쩜문제추천;
import java.util.*;
import java.io.*;
public class 평범한배낭 {
	static int[][] mem;
	static int[] W;
	static int[] V;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		mem = new int[N][K+1];
		W = new int[N];
		V = new int[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			W[i] = Integer.parseInt(st.nextToken());
			V[i] = Integer.parseInt(st.nextToken());
		}
		bw.write(knapsack(N-1,K)+"");
		bw.flush();
		bw.close();
	}
	private static int knapsack(int i, int k) {
		// TODO Auto-generated method stub
		if(i < 0) {
			return 0;
		}
		if(mem[i][k] > 0)
			return mem[i][k];
		if(W[i] > k) {
			mem[i][k] = knapsack(i-1,k);
		}
		else {
			mem[i][k] = Math.max(knapsack(i-1,k), knapsack(i-1,k-W[i])+V[i]);
		}
		return mem[i][k];
	}
}
