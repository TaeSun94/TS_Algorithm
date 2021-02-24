class Solution {
    static boolean[][] check;
    public int solution(int n, int[][] computers) {
        check= new boolean[n][n];
		int answer = 0;

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(check[i][j] || computers[i][j] == 0)
					continue;
				dfs(i,j,computers);
				answer++;
			}
		}
        return answer;
	}

	private static void dfs(int i, int j, int[][] computers) {
		// TODO Auto-generated method stub
		if(check[i][j]) {
			return;
		}
		check[i][j] = true;
		for(int a = 0; a < computers.length; a++) {
			if(computers[j][a]!=0 && !check[j][a]) {
				dfs(j,a,computers);
			}
		}
	}
}
