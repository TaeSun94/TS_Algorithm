package 쩜문제추천;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class 큐 {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		Deque<Integer> que = new LinkedList<Integer>();
		for(int tc = 1; tc <= N; tc++) {
			String order = br.readLine();
			String[] split = order.split(" ");
			if(split.length> 1) {
				que.add(Integer.parseInt(split[1]));
			}
			else {
				if(split[0].equals("front")) {
					if(que.isEmpty()) {
						System.out.println(-1);
						continue;
					}
					System.out.println(que.getFirst());
				}
				else if(split[0].equals("back")) {
					if(que.isEmpty()) {
						System.out.println(-1);
						continue;
					}
					System.out.println(que.getLast());
				}
				else if(split[0].equals("size")) {
					System.out.println(que.size());
				}
				else if(split[0].equals("empty")) {
					if(que.isEmpty()) {
						System.out.println(1);
					}
					else {
						System.out.println(0);
					}
				}
				else if(split[0].equals("pop")){
					if(que.isEmpty()) {
						System.out.println(-1);
						continue;
					}
					System.out.println(que.pop());
				}
			}
		}
	}
}
