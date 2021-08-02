package 쩜문제추천;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class 시험감독 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		int N = Integer.parseInt(st.nextToken());
		int[] input = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		long answer = 0;
		st = new StringTokenizer(br.readLine()," ");
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		for(int i = 0; i < input.length; i++) {
			answer++;
			if(input[i] <= B)
				continue;
			if((input[i]-B)%C != 0) {
				answer ++;
			}
			answer += (input[i]-B)/C;
		}
		bw.write(answer+"");
		bw.flush();
		bw.close();
	}
}
