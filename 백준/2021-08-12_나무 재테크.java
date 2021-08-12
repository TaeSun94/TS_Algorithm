package 쩜문제추천;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class 나무제테크 {
	static class Tree implements Comparable<Tree>{
		int r,c,age;
		boolean live;
		public Tree(int r, int c, int age, boolean live) {
			super();
			this.r = r;
			this.c = c;
			this.age = age;
			this.live = live;
		}
		@Override
		public int compareTo(Tree o) {
			// TODO Auto-generated method stub
			return this.age - o.age;
		}
		@Override
		public String toString() {
			return "Tree [r=" + r + ", c=" + c + ", age=" + age + ", live=" + live + "]";
		}

	}
	static LinkedList<Tree>[][] pq;
	static int[][] map;
	static int[][] AC;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		AC = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < N; j++) {
				AC[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = 5;
			}
		}
		pq = new LinkedList[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				pq[i][j] = new LinkedList<>();
			}
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int age = Integer.parseInt(st.nextToken());
			pq[r][c].add(new Tree(r,c,age,true));
		}
		for(int year = 0; year < K; year++) {
//			for(int i = 0; i < N; i++)
//				System.out.println(Arrays.toString(map[i]));
//			System.out.println("새로운 해 시작 전");
			Spring();
//			for(int i = 0; i < N; i++)
//				System.out.println(Arrays.toString(map[i]));
//			System.out.println("양분 섭취 후");
			Summer();
//			for(int i = 0; i < N; i++)
//				System.out.println(Arrays.toString(map[i]));
//			System.out.println("양분으로 돌린 후");
			April();
			Winter();
		}
		int answer = countTree();
		bw.write(answer+"");
		bw.flush();
		bw.close();
	}
	private static int countTree() {
		// TODO Auto-generated method stub
		int cnt = 0;
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				if(pq[i][j].size() > 0) {
					cnt += pq[i][j].size();
				}
			}
		}
		return cnt;
	}
	private static void Winter() {
		// TODO Auto-generated method stub
		//양분 추가
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				map[i][j] += AC[i][j];
			}
		}
		return;
	}
	//번식 8방향
	static int[] dr = {-1,-1,-1,0,1,1,1,0};
	static int[] dc = {-1,0,1,1,1,0,-1,-1};
	private static void April() {
		// TODO Auto-generated method stub
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				if(pq[i][j].size()>=1) {
					for(Tree tree : pq[i][j]) {
						if(tree.age%5 == 0) {
							for(int d = 0; d < 8; d++) {
								int nr = tree.r + dr[d];
								int nc = tree.c + dc[d];
								if(nr < 0 || nc < 0 || nr >= map.length || nc >= map[nr].length)
									continue;
								pq[nr][nc].add(new Tree(nr,nc,1,true));
							}
						}
					}
				}
			}
		}
	}
	//죽은 나무 양분으로 변신
	private static void Summer() {
		// TODO Auto-generated method stub
		LinkedList<Tree>[][] tmp = new LinkedList[map.length][map.length];
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map.length; j++) {
				tmp[i][j] = new LinkedList<>();
			}
		}
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				if(pq[i][j].size()>=1) {
					for(Tree tree: pq[i][j]) {
//						if(!tree.live) {
//							map[i][j] += tree.age/2;
//						}
						if(tree.live) {
							tmp[i][j].add(new Tree(i,j,tree.age,tree.live));
						}
						else {
							map[i][j] += tree.age/2;
						}
					}
				}
			}
		}
		pq = tmp;
	}
	//양분 먹기
	private static void Spring() {
		// TODO Auto-generated method stub
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				if(pq[i][j].size()>=1) {
					Collections.sort(pq[i][j]);
					for(Tree tree: pq[i][j]) {
						if(map[i][j] >= tree.age) {
							map[i][j] -= tree.age;
							tree.age++;
						}
						else {
							tree.live = !tree.live;
						}
					}
				}
			}
		}
	}
}
