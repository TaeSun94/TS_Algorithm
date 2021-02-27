import java.util.*;
class Solution {
    static class Pic{
		int r, c;

		public Pic(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	static boolean[][] check;
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        check = new boolean[m][n];
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(picture[i][j] != 0 && !check[i][j]) {
					numberOfArea++;
					check[i][j] = true;
					int area = bfs(i,j,picture);
					if(maxSizeOfOneArea < area)
						maxSizeOfOneArea = area;
				}
			}
		}
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
	static int[] dr = {0,0,1,-1};
	static int[] dc = {-1,1,0,0};
	private static int bfs(int i, int j, int[][] picture) {
		boolean[][] visited = new boolean[picture.length][picture[0].length];
		visited[i][j] = true;
		Queue<Pic> que = new LinkedList<>();
		que.add(new Pic(i,j));
		while(!que.isEmpty()) {
			Pic p = que.poll();
			for(int d = 0; d < 4; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				if(nr<0||nc<0||nr>=picture.length||nc>=picture[0].length)
					continue;
				if(check[nr][nc] || picture[nr][nc] != picture[i][j])
					continue;
				check[nr][nc] = true;
				visited[nr][nc] = true;
				que.add(new Pic(nr,nc));
			}
		}
		int ans = 0;
		for(int r = 0; r < visited.length; r++) {
			for(int c = 0; c < visited[r].length; c++) {
				if(visited[r][c])
					ans++;
			}
		}
		return ans;
	}
}
