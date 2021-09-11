package 쩜문제추천;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class 이중우선순위큐 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			TreeMap<Integer, Integer> treeMap = new TreeMap<>();
			int n = Integer.parseInt(br.readLine());
			for (int d = 0; d < n; d++) {
				st = new StringTokenizer(br.readLine());
				String str = st.nextToken();
				int num = Integer.parseInt(st.nextToken());
				if (str.equals("D")) {
					if(treeMap.isEmpty()) continue;
                    if(num == -1) {
                        int minKey = treeMap.firstKey();
                        if(treeMap.get(minKey) == 1) {
                            treeMap.remove(minKey);
                        }else {
                            treeMap.put(minKey, treeMap.get(minKey) - 1);
                        }
                    }else {
                        int maxKey = treeMap.lastKey();
                        if(treeMap.get(maxKey) == 1) {
                            treeMap.remove(maxKey);
                        }else {
                            treeMap.put(maxKey, treeMap.get(maxKey) - 1);
                        }
                    }
				} else {
					treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
				}
			}

			if (treeMap.isEmpty()) {
				bw.write("EMPTY\n");
			} else {
				bw.write(treeMap.lastKey() + " " + treeMap.firstKey() + "\n");
			}
		}
		bw.flush();
		bw.close();
	}
}
