package 쩜문제추천;

import java.util.*;
import java.io.*;

public class 행렬제곱 {
	static long[][] board;
	static int MOD = 1000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());

		board = new long[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken()) % MOD;
			}
		}
		// 분할 정복
		long[][] result = pow(board, B);

		for (long[] b : result) {
			for (int i = 0; i < b.length; i++) {
				bw.write(b[i] + " ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}

	private static long[][] pow(long[][] A, long exp) {
		// TODO Auto-generated method stub
		if (exp == 1L) {
			return A;
		}
		long[][] ret = pow(A, exp / 2);
		ret = multiply(ret, ret);
		if (exp % 2 == 1L)
			ret = multiply(ret, board);
		return ret;
	}

	private static long[][] multiply(long[][] A, long[][] B) {
		// TODO Auto-generated method stub
		long[][] tmp = new long[board.length][board.length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				for (int k = 0; k < board.length; k++) {
					tmp[i][j] += A[i][k] * B[k][j];
					tmp[i][j] %= MOD;
				}
			}
		}
		return tmp;
	}
}
