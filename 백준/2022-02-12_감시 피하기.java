import java.util.*;
import java.io.*;
public class 감시피하기 {
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static boolean isHide = false;
	static char[][] map;
	static boolean[][] visited;
	static class Teacher{
		int r,c;

		public Teacher(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}
	static ArrayList<Teacher> teachers = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());

		//init map
		visited = new boolean[N][N];
		map = new char[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < N; j++) {
				map[i][j] = st.nextToken().charAt(0);
				if(map[i][j] == 'T') {
					teachers.add(new Teacher(i,j));
				}
			}
		}

		dfs(0,0,0);

		if(isHide) {
			bw.write("YES");
		}
		else {
			bw.write("NO");
		}
		bw.flush();
		bw.close();
	}
	private static void dfs(int r, int c, int cnt) {
		// TODO Auto-generated method stub
		if(cnt == 3) {
			check();
			return;
		}
		for(int i = r; i < map.length; i++) {
			for(int j = c; j < map.length; j++) {
				if(map[i][j]=='X') {
					map[i][j]='O';
					dfs(i,j+1,cnt+1);
					map[i][j] = 'X';
				}
			}
			c = 0;
		}
	}
	private static void check() {
		// TODO Auto-generated method stub
		boolean check = true;
		for(int index = 0; index < teachers.size(); index++) {
			Teacher t = teachers.get(index);
			for(int d = 0; d < 4; d++) {
				int nr = t.r;
				int nc = t.c;
				while(true) {
					nr += dr[d];
					nc += dc[d];
					if(nr < 0 || nc < 0 || nr >= map.length || nc >= map.length) {
						break;
					}
					if(map[nr][nc]=='O')
						break;
					if(map[nr][nc] == 'S') {
						return;
					}
				}
			}
		}
		if(check) {
			isHide = true;
		}
		return;
	}
}
