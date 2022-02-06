import java.util.*;
import java.io.*;
public class 여왕벌 {
	static int[][] map;
	static int[] dr = {0,-1,-1};
	static int[] dc = {-1,-1,0};
	static int[][] mem;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		map = new int[M][M];
		for(int i = 0; i < M; i++) {
			Arrays.fill(map[i], 1);
		}
		mem = new int[M][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			for(int j = M-1; j >= 0 ; j--) {
				if(a > 0) {
					a--;
				}
				else if(b > 0) {
					mem[j][0]++;
					b--;
				}
				else if(c > 0) {
					mem[j][0] += 2;
					c--;
				}
			}
			for(int j = 1; j < M ; j++) {
				if(a > 0) {
					a--;
				}
				else if(b > 0) {
					mem[0][j]++;
					b--;
				}
				else if(c > 0) {
					mem[0][j] += 2;
					c--;
				}
			}
		}

		for(int i = 0; i < M; i++) {
			for(int j = 0; j < M; j++) {
				if(i == 0 || j == 0) {
					map[i][j] += mem[i][j];
					bw.write(map[i][j]+" ");
					continue;
				}
				int max = 0;
				for(int d = 0; d < 3; d++) {
					max = Math.max(max, mem[i+dr[d]][j+dc[d]]);
				}
				mem[i][j] = max;
				map[i][j] += max;
				bw.write(map[i][j]+" ");
			}
			bw.write("\n");
		}

		bw.flush();
		bw.close();
	}
}
