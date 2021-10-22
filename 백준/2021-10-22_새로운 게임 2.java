package 쩜문제추천;
import java.util.*;
import java.io.*;
public class 새로운게임2 {
	static class Horse{
		int num,r,c,dir;

		public Horse(int num, int r, int c, int dir) {
			super();
			this.num = num;
			this.r = r;
			this.c = c;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "Horse [num=" + num + ", r=" + r + ", c=" + c + ", dir=" + dir + "]";
		}

	}
	static int[][] map;
	static LinkedList<Integer>[][] board;
	static Horse[] list;
	static int[] dr = {0,0,-1,1};
	static int[] dc = {1,-1,0,0};
	static boolean flag = false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		board = new LinkedList[N][N];
		list = new Horse[K];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				board[i][j] = new LinkedList<>();
			}
		}
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int d = Integer.parseInt(st.nextToken())-1;
			board[r][c].add(i);
			list[i] = new Horse(i,r,c,d);
		}
		int cnt = 0;
		while(true) {
			cnt++;
			if(cnt > 1000) {
				cnt = -1;
				break;
			}
			for(int h = 0; h < list.length; h++) {
//				System.out.println(Arrays.toString(list));
//				for(int i = 0; i < board.length; i++) {
//					for(int j = 0; j < board.length; j++) {
//						System.out.print(board[i][j].size()+" ");
//					}
//					System.out.println();
//				}
				solve(list[h]);
				if(flag)
					break;
			}
			if(flag)
				break;

		}
		bw.write(cnt+"");
		bw.flush();
		bw.close();
	}
	private static void solve(Horse horse) {
		// TODO Auto-generated method stub
		int nr = horse.r + dr[horse.dir];
		int nc = horse.c + dc[horse.dir];
		if(nr < 0 || nc < 0 || nr >= map.length || nc >= map[nr].length || map[nr][nc] == 2) {
			horse.dir++;
			if(horse.dir == 2 || horse.dir == 4) {
				horse.dir -= 2;
			}
		}
		nr = horse.r + dr[horse.dir];
		nc = horse.c + dc[horse.dir];
		if(nr < 0 || nc < 0 || nr >= map.length || nc >= map[nr].length || map[nr][nc] == 2) {
			list[horse.num] = new Horse(horse.num,horse.r,horse.c,horse.dir);
			return;
		}
		if(map[nr][nc] == 0) {
			Stack<Integer> stk = new Stack<>();
			while(true) {
				int num = board[horse.r][horse.c].pollLast();
				stk.push(num);
				if(num == horse.num) {
					break;
				}
			}
			while(!stk.isEmpty()) {
				int num = stk.pop();
				board[nr][nc].add(num);
				list[num].r = nr;
				list[num].c = nc;
			}
		}
		else {
			Queue<Integer> que = new LinkedList<>();
			while(true) {
				int num = board[horse.r][horse.c].pollLast();
				que.add(num);
				if(num == horse.num) {
					break;
				}
			}
			while(!que.isEmpty()) {
				int num = que.poll();
				board[nr][nc].add(num);
				list[num].r = nr;
				list[num].c = nc;
			}
		}
		if(board[nr][nc].size()>= 4)
			flag = true;

		return;
	}
}
