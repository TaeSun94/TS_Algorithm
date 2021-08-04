package 쩜문제추천;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class 로봇청소기 {
	static int[][] map;
	static class Robot{
		int r,c,cnt,dir;
		public Robot(int r, int c, int dir, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.cnt = cnt;
		}
	}
	static Robot robot;
	static boolean[][] visited;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		st = new StringTokenizer(br.readLine()," ");
		robot = new Robot(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),0);
		for(int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs();
		bw.write(robot.cnt+"");
		bw.flush();
		bw.close();
	}
	private static void dfs() {
		if(!visited[robot.r][robot.c]) {
			visited[robot.r][robot.c] = true;
			robot.cnt++;
		}
		boolean check = false;
		for(int dir_cnt = 0; dir_cnt < 4; dir_cnt++) {
			//왼쪽으로 회전
			if(robot.dir==0) {
				robot.dir = 4;
			}
			robot.dir -= 1;
			int nr = robot.r + dr[robot.dir];
			int nc = robot.c + dc[robot.dir];
			if(nr>= map.length || nc>=map[nr].length || nr<0 ||nc <0) {
				continue;
			}
			if(map[nr][nc]==1||visited[nr][nc]) {
				continue;
			}
			check = true;
			robot.r = nr;
			robot.c = nc;
			dfs();
		}
		if(!check) {
			int ddir = robot.dir + 2;
			if(ddir >=4) {
				ddir -= 4;
			}
			int nr = robot.r + dr[ddir];
			int nc = robot.c + dc[ddir];
			if(map[nr][nc] == 1) {
				return;
			}
			robot.r = nr;
			robot.c = nc;
			dfs();
		}
	}
}
