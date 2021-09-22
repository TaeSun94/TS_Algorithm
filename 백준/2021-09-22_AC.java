package 쩜문제추천;
import java.util.*;
import java.io.*;
public class AC {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int T = Integer.parseInt(st.nextToken());
		for(int tc = 1; tc <= T; tc++) {
			String command = br.readLine();
			int N = Integer.parseInt(br.readLine());
			Deque<Integer> dq = new LinkedList<>();
			st = new StringTokenizer(br.readLine(), "[|,|]");
			while(st.hasMoreTokens())
				dq.add(Integer.parseInt(st.nextToken()));
			boolean flag = false;
			boolean check = false;
			for(int i = 0; i < command.length(); i++) {
				if(command.charAt(i)=='R') {
					flag = !flag;
				}
				else {
					if(dq.isEmpty()) {
						System.out.println("error");
						check = true;
						break;
					}
					if(flag) {
						dq.pollLast();
					}
					else {
						dq.pollFirst();
					}
				}
			}
			if(check)
				continue;
			int[] arr = new int[dq.size()];
			int idx = 0;
			while(!dq.isEmpty()) {
				if(flag) {
					arr[idx++] = dq.pollLast();
				}
				else {
					arr[idx++] = dq.pollFirst();
				}
			}
			if(arr.length==0) {
				System.out.println("[]");
			}
			else {
				StringBuilder sb = new StringBuilder();
				sb.append("[");
				for(int i = 0; i < arr.length; i++) {
					sb.append(arr[i]+",");
				}
				sb.replace(sb.length()-1, sb.length(), "]");
				System.out.println(sb.toString());
			}
		}
	}
}
