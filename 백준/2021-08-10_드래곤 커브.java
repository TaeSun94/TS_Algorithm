package 쩜문제추천;
import java.io.*;
import java.util.*;
public class 드래곤커브 {
	static boolean[][] map = new boolean[101][101];
	//0,1,2,3
	static int[] dr = {0,-1,0,1};
	static int[] dc = {1,0,-1,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		int N = Integer.parseInt(st.nextToken());
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int c = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			ArrayList<Integer> dirs = new ArrayList<>();
			dirs.add(dir);
			map[r][c] = true;
			r += dr[dir];
			c += dc[dir];
			map[r][c] = true;
			for(int j = 0; j < g; j++) {
				int dirCnt = dirs.size();
				for(int k = dirCnt-1; k >=0 ; k--) {
					int direction = dirs.get(k)+1;
					if(direction==4) {
						direction = 0;
					}
					dirs.add(direction);
					r += dr[direction];
					c += dc[direction];
					map[r][c] = true;
				}
			}
		}
		int answer = countSquare();
		bw.write(answer+"");
		bw.flush();
		bw.close();
	}
	private static int countSquare() {
		// TODO Auto-generated method stub
		int cnt = 0;
		for(int i = 0; i < map.length-1; i++) {
			for(int j = 0; j < map.length-1; j++) {
				if(map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1])
					cnt++;
			}
		}

		return cnt;
	}
}
