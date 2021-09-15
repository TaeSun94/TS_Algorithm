package 쩜문제추천;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 투에모스 {
	static long[] arr= new long[64];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long k = Long.parseLong(br.readLine());
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (long)Math.pow(2,i);
		}
		System.out.println(solv(k));
	}

	private static long solv(long k) {
		// TODO Auto-generated method stub
		if(k == 1)
			return 0;
		long n = 0;
		for(int i = 0; i < arr.length; i++) {
			if(k>arr[i]) n = arr[i];
			else break;
		}
		return 1-solv(k-n);
	}
}
