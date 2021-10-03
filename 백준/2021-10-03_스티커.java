package 쩜문제추천;
import java.util.*;
import java.io.*;
public class 스티커 {
	static int[][] stickers;
	static int[][] mem;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());
			mem = new int[2][n+1];
			stickers = new int[2][n+1];
			answer = 0;
			for(int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j = 1; j <= n; j++) {
					stickers[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			mem[0][1] = stickers[0][1];
			mem[1][1] = stickers[1][1];
			for(int i = 2; i <= n; i++) {
				mem[0][i] = Math.max( mem[1][i-1], mem[1][i-2])+stickers[0][i];
				mem[1][i] = Math.max(mem[0][i-1],mem[0][i-2])+stickers[1][i];
			}
			int ans = Math.max(mem[0][n],mem[1][n]);
			bw.write(ans+"\n");
		}
		bw.flush();
		bw.close();
	}
}
