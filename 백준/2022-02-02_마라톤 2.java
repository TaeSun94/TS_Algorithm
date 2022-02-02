import java.util.*;
import java.io.*;
public class 마라톤2 {
	static int[][] mem;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		mem = new int[N+1][K+1];
		arr = new int[N+1][N+1];
		int[][] input = new int[N+1][2];

		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
		}
		for(int i = 1; i < N; i++) {
			for(int j = i+1; j <= N; j++) {
				arr[i][j] = Math.abs(input[i][0]-input[j][0])+Math.abs(input[i][1]-input[j][1]);
			}
		}
		System.out.println(go(N,K));
	}
	private static int go(int n, int k) {
		// TODO Auto-generated method stub
		if(mem[n][k] != 0)
			return mem[n][k];
		if(n==1)
			return 0;
		mem[n][k] = Integer.MAX_VALUE;
		for(int i = 0; i <= k; i++) {
			if(n-i-1 > 0) {
				mem[n][k] = Math.min(go(n-i-1,k-i)+arr[n-i-1][n], mem[n][k]);
			}
		}
		return mem[n][k];
	}
}
