package 쩜문제추천;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 나는야포켓몬마스터이다솜 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String,String> map = new HashMap<>();
		for(int i = 1; i <= N; i++) {
			String str = br.readLine();
			map.put(i+"",str);
			map.put(str,i+"");
		}
		for(int i = 0; i < M; i++) {
			System.out.println(map.get(br.readLine()));
		}
	}
}
