package 쩜문제추천;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 퇴사 {
	static int[][] days;
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		days = new int[N][2];
		max = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			days[i][0] = Integer.parseInt(st.nextToken());
			days[i][1] = Integer.parseInt(st.nextToken());
		}
		dfs(0,0);
		bw.write(max+"");
		bw.flush();
		bw.close();
	}
	private static void dfs(int T, int P) {
		// TODO Auto-generated method stub
		if(T == days.length) {
			max = Math.max(max, P);
			return;
		}
		for(int i = T; i < days.length; i++) {
			if(i+days[i][0] <= days.length) {
				dfs(i+days[i][0], P+days[i][1]);
			}
			else {
				max = Math.max(max, P);
			}
		}
	}
}
