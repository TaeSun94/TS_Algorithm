import java.util.*;
import java.io.*;
public class 가장긴바이토닉부분수열 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] split = br.readLine().split(" ");
		int[] mem = new int[N];
		for(int i = 0; i < N; i++) {
			mem[i] = Integer.parseInt(split[i]);
		}

		int[] left = new int[N];
		int[] right = new int[N];
		for(int i = 0; i < N; i++) {
			for(int j = i; j >= 0; j--) {
				if(mem[i] > mem[j]) {
					left[i] = Math.max(left[i], left[j]+1);
				}
			}
		}
		for(int i = N-1; i >=0; i--) {
			for(int j = i; j < N; j++) {
				if(mem[i]>mem[j]) {
					right[i] = Math.max(right[i], right[j]+1);
				}
			}
		}

		int ans = 0;
		for(int i = 0; i < N; i++) {
			ans = Math.max(left[i]+right[i],ans);
		}
		System.out.println(ans+1);
	}
}
