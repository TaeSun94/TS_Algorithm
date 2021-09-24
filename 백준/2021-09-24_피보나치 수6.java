package 쩜문제추천;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치수6 {
	final static long MOD = 1000000007;
	public static long[][] first = {{1,1},{1,0}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long[][] A = {{1,1},{1,0}};
		long N = Long.parseLong(br.readLine());
		System.out.println(pow(A,N-1)[0][0]);
	}
	private static long[][] pow(long[][] A, long exp) {
		// TODO Auto-generated method stub
		if(exp==1 || exp==0) {
			return A;
		}
		long[][] ret = pow(A,exp/2);
		ret = multi(ret,ret);
		if(exp % 2 == 1) {
			ret = multi(ret,first);
		}
		return ret;
	}
	private static long[][] multi(long[][] o1, long[][] o2) {
		// TODO Auto-generated method stub
		long[][] ret = new long[2][2];
		ret[0][0] = ((o1[0][0] * o2[0][0]) + (o1[0][1] * o2[1][0])) % MOD;
		ret[0][1] = ((o1[0][0] * o2[0][1]) + (o1[0][1] * o2[1][1])) % MOD;
		ret[1][0] = ((o1[1][0] * o2[0][0]) + (o1[1][1] * o2[1][0])) % MOD;
		ret[1][1] = ((o1[1][0] * o2[0][1]) + (o1[1][1] * o2[1][1])) % MOD;
		return ret;
	}
}
