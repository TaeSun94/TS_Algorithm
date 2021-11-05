package 홍익대;
import java.util.*;
import java.io.*;
public class A {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		ArrayList<Integer> list = new ArrayList<Integer>();
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine()," ");
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		Collections.sort(list);
		bw.write(N*X/100+" ");
		int cnt = 0;
		for(int i = list.size()-1; i >=0; i--) {
			if(list.get(i)>=Y) {
				cnt++;
			}
		}
		bw.write(cnt+"");
		bw.flush();
		bw.close();
	}
}
