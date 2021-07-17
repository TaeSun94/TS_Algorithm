package 코딩테스트문제;
//크루스칼 문제 - disjoin 알면 쉬운 문제
/*
모든 점으로 부터 확인하는 dfs작성 check 배열 만들고
false일때만 dfs들어가게 설정
 */
/*
int n = 3;
int[][] computers = {{1,1,0},{1,1,0},{0,0,1}};

int n = 3;
int[][] computers = {{1,1,0},{1,1,1},{0,1,1}};
 */
public class BFSDFS네트워크 {
	static boolean[][] check;
	public static void main(String[] args) {
		int n = 3;
		int[][] computers = {{1,1,0},{1,1,1},{0,1,1}};
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
		System.out.println(answer);
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
