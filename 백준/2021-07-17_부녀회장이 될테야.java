/*
DP를 이용한 풀이로 2차원 배열의 메모이제이션을 통한 풀이
구하려는 층과 호수가 a,b라고 가정한다면
(a-1)층의 (b-1)호수까지의 합은 (a, b-1)이고 (a-1,b)를 더해준다면 정답값을 도출할 수 있다.

1 - 3
0-1 + 0-2 + 0-3 => 1-3
1+2+3 = > 6
3명있어야하고
2-3
[1,1,1,1]

1, 1+1+2, 1+1+2+1+2+3
1, 1+2, 1+2+3, 1+2+3+4
1 2 3 4 5 6 7 ... 14
*/
import java.util.Arrays;
import java.util.Scanner;

public class 부녀회장이될테야 {
	static int[][] mem;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 0; tc < T; tc++) {
			int k = sc.nextInt();
			int n = sc.nextInt()-1;
			mem = new int[15][14];
			System.out.println(go(k,n));
		}
	}
	private static int go(int k, int n) {
		// TODO Auto-generated method stub
		if(n == 0) {
			mem[k][n] = 1;
			return 1;
		}
		if(k == 0) {
			mem[k][n] = n+1;
			return n+1;
		}
		mem[k][n] = go(k-1,n)+go(k,n-1);
		return mem[k][n];
	}
}
