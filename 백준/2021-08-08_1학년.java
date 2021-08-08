package 쩜문제추천;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class 일학년 {
	static long[] calc = new long[21];
	static int[] numbers;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		numbers = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		calc[numbers[0]] = 1;
		cal(0);
		bw.write(calc[numbers[numbers.length-1]]+"\n");
		bw.flush();
		bw.close();
	}
	private static void cal(int idx) {
		// TODO Auto-generated method stub
		if(idx == numbers.length-2)
			return;
		long[] tmp = new long[21];
		for(int i = 0; i < calc.length; i++) {
			if(calc[i] != 0) {
				if(i-numbers[idx+1] >= 0) {
					tmp[i-numbers[idx+1]]+= calc[i];
				}
				if(i+numbers[idx+1]<=20) {
					tmp[i+numbers[idx+1]]+= calc[i];
				}
			}
		}
		calc = tmp.clone();
		cal(idx+1);
		return;
	}
}
