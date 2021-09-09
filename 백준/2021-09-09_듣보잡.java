package 쩜문제추천;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class 듣보잡 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashSet<String> list = new HashSet<>();
		for(int i = 0; i < N; i++) {
			list.add(br.readLine());
		}
		PriorityQueue<String> pq = new PriorityQueue<String>();
		for(int i = 0; i < M; i++) {
			String str = br.readLine();
			if(list.contains(str)) {
				pq.add(str);
			}
		}
		bw.write(pq.size()+"\n");
		while(!pq.isEmpty()) {
			bw.write(pq.poll()+"\n");
		}
		bw.flush();
		bw.close();
	}
}
