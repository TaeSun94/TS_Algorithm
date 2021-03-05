class Solution {
    static int[][] dist;
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[m][n];
		for(int i = 0; i < puddles.length; i++) {
			map[puddles[i][0]-1][puddles[i][1]-1] = -1;
		}
		dist = new int[m][n];
        for(int i = 0; i < m; i++) {
			if(map[i][0]== -1)
				break;
			dist[i][0] = 1;
		}
		for(int i = 0; i < n; i++) {
			if(map[0][i] == -1)
				break;
			dist[0][i] = 1;
		}
		int answer = go(m-1,n-1,map);
        return answer;
    }
	private static int go(int i, int j, int[][] map) {
		// TODO Auto-generated method stub
        if(i < 0 || j < 0)
			return 0;
		if(map[i][j] == -1)
			return 0;
		if(dist[i][j] > 0)
			return dist[i][j];

		dist[i][j] = (go(i-1,j,map)+go(i,j-1,map))%1000000007;
		return dist[i][j];
	}
}
