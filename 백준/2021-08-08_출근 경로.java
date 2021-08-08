package 쩜문제추천;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class 출근경로 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		long[][][] mem = new long[w+1][h+1][4];
		for(int i = 1; i <= w; i++) {
			mem[i][1][0] = 1;
		}
		for(int i = 1; i <= h; i++) {
			mem[1][i][2] = 1;
		}
		for(int i = 2; i <= w; i++) {
			for(int j = 2; j <= h; j++) {
				mem[i][j][0] = (mem[i-1][j][1]+mem[i-1][j][0])%100000;
				mem[i][j][1] = mem[i-1][j][2];

				mem[i][j][2] = (mem[i][j-1][3]+mem[i][j-1][2])%100000;
				mem[i][j][3] = mem[i][j-1][0];
			}
		}
		int answer = 0;
		for(int i = 0; i < 4; i++) {
			answer += mem[w][h][i];
		}
		bw.write((answer%100000)+"");
		bw.flush();
		bw.close();
	}
}
