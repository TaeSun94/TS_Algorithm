package 쩜문제추천;
import java.util.*;
import java.io.*;
public class 구간합구하기4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] memory = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		memory[0] = Integer.parseInt(st.nextToken());
		for(int index = 1; index< N; index++) {
			memory[index] = Integer.parseInt(st.nextToken())+memory[index-1];
		}
		for(int index = 0; index < M; index++) {
			st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			if(start > 0) {
				bw.write(memory[end]-memory[start-1]+"\n");
			}
			else {
				bw.write(memory[end]+"\n");
			}
		}
		bw.flush();
		bw.close();
	}
}
