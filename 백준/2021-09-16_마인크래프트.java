package 쩜문제추천;
import java.util.*;
import java.io.*;
public class 마인크래프트 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int min = Integer.MAX_VALUE;
		int max = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				min = Math.min(min, map[i][j]);
				max = Math.max(max, map[i][j]);
			}
		}
		int height = -1;
		int time = Integer.MAX_VALUE;
		for(int h = min; h <=max; h++) {
			int inven = B;
			int t = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] < h) {
						inven -= h-map[i][j];
						t += (h-map[i][j]);
					}
					else{
						inven += map[i][j]-h;
						t += (map[i][j]-h)*2;
					}
				}
			}
			if(inven >= 0) {
				if(t < time) {
					time = t;
					height = h;
				}
				else if(t == time) {
					height = h;
				}
			}
		}
		bw.write(time+" "+height+"\n");
		bw.flush();
		bw.close();
	}
}
