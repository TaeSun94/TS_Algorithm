package 쩜문제추천;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 스타트와링크 {
	static int[][] stats;
	static int[] result;
	static int[] input;
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		stats = new int[N][N];
		min = Integer.MAX_VALUE;
		//스탯 2차원 배열
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < N; j++) {
				stats[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		input = new int[N];
		for(int i = 0; i < N; i++)
			input[i] = i;
		result = new int[N/2];
		comb(0,0);
		bw.write(min+"");
		bw.flush();
		bw.close();
	}
	private static void comb(int idx, int s_idx) {
		// TODO Auto-generated method stub
		if(s_idx == result.length) {
			boolean[] check = new boolean[input.length];
			for(int i = 0; i < result.length; i++) {
				check[result[i]] = true;
			}
			int teamA = calc(check, true);
			int teamB = calc(check, false);
			min = Math.min(min, Math.abs(teamA-teamB));
			return;
		}
		if(idx == input.length)
			return;
		result[s_idx] = input[idx];
		comb(idx+1, s_idx+1);
		comb(idx+1, s_idx);
	}
	private static int calc(boolean[] check, boolean b) {
		// TODO Auto-generated method stub
		ArrayList<Integer> teams = new ArrayList<>();
		for(int i = 0; i < check.length; i++) {
			if(check[i]==b)
				teams.add(i);
		}
		int sum = 0;
		for(int i = 0; i < teams.size(); i++) {
			for(int j = 0; j < teams.size(); j++) {
				sum += stats[teams.get(i)][teams.get(j)];
			}
		}

		return sum;
	}
}
