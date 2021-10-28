package 쩜문제추천;

import java.util.*;
import java.io.*;

public class 세용액 {
	static long[] pick;
	static long max = Long.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		pick = new long[3];
		long[] input = new long[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			input[i] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(input);
		for(int i=0; i<N-2; i++)
            solution(input, i);

        Arrays.sort(pick);

        for(int i=0; i<3; i++)
            System.out.print(pick[i] + " ");
    }

    static void solution(long[] arr, int index) {
        int left = index+1;
        int right = arr.length-1;

        while(left < right) {

            long sum = arr[left] + arr[right] + arr[index];
            long absSum = Math.abs(sum);

            // 두 용액 갱신
            if(absSum < max) {
                pick[0] = arr[left];
                pick[1] = arr[right];
                pick[2] = arr[index];
                max = absSum;
            }

            if(sum > 0)
                right--;
            else
                left++;
        }
    }
}
