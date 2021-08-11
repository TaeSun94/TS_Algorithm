package 쩜문제추천;
import java.util.*;
import java.io.*;
public class 마법사상어와비바라기 {
	static class Cloud{
		int r,c,d,s;

		public Cloud(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}
	static int[][] map;
	static Queue<Cloud> clouds;
	static int[] checkdr = {-1,-1,1,1};
	static int[] checkdc = {-1,1,-1,1};
	static int[] dr = {0,-1,-1,-1,0,1,1,1};
	static int[] dc = {-1,-1,0,1,1,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		clouds = new LinkedList<>();
		//init map
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//첫 구름 위치 저장
		clouds.add(new Cloud(N-1,0));
		clouds.add(new Cloud(N-1,1));
		clouds.add(new Cloud(N-2,0));
		clouds.add(new Cloud(N-2,1));
		for(int tc = 0; tc < M; tc++) {
			st = new StringTokenizer(br.readLine()," ");
			int dir = Integer.parseInt(st.nextToken())-1;
			int s = Integer.parseInt(st.nextToken());
			//방향 및 속력
			initCloud(dir,s);
			//이동 및 해당 자리 +1
			move();
		}
		int answer = sumWater();
		bw.write(answer+"");
		bw.flush();
		bw.close();
	}
	private static int sumWater() {
		// TODO Auto-generated method stub
		int sum = 0;
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map.length; j++) {
				sum += map[i][j];
			}
		}
		return sum;
	}
	private static void initCloud(int dir, int s) {
		// TODO Auto-generated method stub
		int len = clouds.size();
		for(int i = 0; i < len; i++) {
			Cloud cloud = clouds.poll();
			cloud.d = dir;
			cloud.s = s;
			clouds.add(cloud);
		}
	}
	private static void move() {
		// TODO Auto-generated method stub
		int len = clouds.size();
		for(int i = 0; i < len; i++) {
			Cloud cloud = clouds.poll();
			int distance = cloud.s%map.length;
			int nr = cloud.r + dr[cloud.d]*distance;
			int nc = cloud.c + dc[cloud.d]*distance;
			if(nr < 0)
				nr += map.length;
			else if(nr >= map.length)
				nr -= map.length;
			if(nc < 0)
				nc += map.length;
			else if(nc >= map.length)
				nc -= map.length;
			map[nr][nc]++;
			clouds.add(new Cloud(nr,nc));
		}
		boolean[][] check = new boolean[map.length][map.length];
		//구름 전부 제거하면서 인접한 곳의 바구니의 유무를 통해 해당 자리 물 복사
		while(!clouds.isEmpty()) {
			Cloud cloud = clouds.poll();
			check[cloud.r][cloud.c] = true;
			map[cloud.r][cloud.c] += copyWater(cloud);
		}
		//map전체를 돌며 구름 생성 2이상인곳 단 구름이 있던 곳은 생기지 않는다.
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map.length; j++) {
				if(map[i][j]>=2 && !check[i][j]) {
					clouds.add(new Cloud(i,j));
					map[i][j] -= 2;
				}
			}
		}
	}
	private static int copyWater(Cloud cloud) {
		// TODO Auto-generated method stub
		int cnt = 0;
		for(int d = 0; d < 4; d++) {
			int nr = cloud.r + checkdr[d];
			int nc = cloud.c + checkdc[d];
			if(nr < 0 || nc < 0 || nr >= map.length || nc >= map.length)
				continue;
			if(map[nr][nc] > 0)
				cnt++;
		}
		return cnt;
	}
}
