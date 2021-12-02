import java.util.*;
import java.io.*;
public class 메시지 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int groupNum = 1;
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			if(N==0) {
				break;
			}
			if(groupNum > 1) {
				bw.write("\n");
			}
			ArrayList<String> group = new ArrayList<String>();
			HashMap<String, ArrayList<Integer>> map = new LinkedHashMap<String, ArrayList<Integer>>();

			boolean flag = false;
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				String key = st.nextToken();
				group.add(key);
				map.put(key, new ArrayList<>());
				for(int j = 0; j < N-1; j++) {
					if(st.nextToken().equals("N")) {
						flag = true;
						map.get(key).add(j+1);
					}
				}
			}
			bw.write("Group "+groupNum+++"\n");
			if(flag) {
				for(String key: map.keySet()) {
					int index = group.indexOf(key);
					for(int idx: map.get(key)) {
						if(index - idx < 0) {
							bw.write(group.get(index-idx+N)+" was nasty about "+key+"\n");
						}
						else {
							bw.write(group.get(index-idx)+" was nasty about "+key+"\n");
						}
					}
				}
			}
			else {
				bw.write("Nobody was nasty\n");
			}
		}
		bw.flush();
		bw.close();
	}
}
