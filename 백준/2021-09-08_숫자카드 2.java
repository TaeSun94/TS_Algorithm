package 쩜문제추천;
import java.util.*;
import java.io.*;
public class 숫자카드2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		HashMap<Integer, Integer> map = new HashMap<>();
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(map.containsKey(num)) {
				map.replace(num, map.get(num)+1);
			}
			else {
				map.put(num,1);
			}
		}
		st = new StringTokenizer(br.readLine()," ");
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i < M; i++) {
			int key = Integer.parseInt(st.nextToken());
			if(map.containsKey(key)) {
				bw.write(map.get(key)+" ");
			}
			else {
				bw.write(0+" ");
			}
		}
		bw.flush();
		bw.close();
	}
}
