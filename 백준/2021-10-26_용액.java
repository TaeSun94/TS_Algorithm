package 쩜문제추천;
import java.util.*;
import java.io.*;
public class 용액 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		long[] input = new long[N];
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i < N; i++) {
			input[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(input);
		long left = 0;
		long right = 0;
		long max = Integer.MAX_VALUE;
		int Lpos = 0;
		int Rpos = N-1;
		while(Lpos < Rpos) {
			long sum = input[Lpos]+input[Rpos];
			if(Math.abs(sum)<max) {
				left = input[Lpos];
				right = input[Rpos];
				max = Math.abs(sum);
			}
			if(sum > 0) {
				Rpos--;
			}
			else {
				Lpos++;
			}
		}
		bw.write(left+" "+right+"");
		bw.flush();
		bw.close();
	}
}
