package 쩜문제추천;
import java.util.*;
import java.io.*;
public class 패션왕신해빈 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine()," ");
			int n = Integer.parseInt(st.nextToken());
			HashMap<String, Integer> map = new HashMap<>();
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine()," ");
				String item = st.nextToken();
				String category = st.nextToken();
				if(map.containsKey(category)) {
					map.replace(category,map.get(category)+1);
				}
				else {
					map.put(category, 1);
				}
			}
			int ans = 1;
			for(int val: map.values()) {
				ans *= (val+1);
			}
			bw.write(ans-1+"\n");
		}
		bw.flush();
		bw.close();
	}
}
