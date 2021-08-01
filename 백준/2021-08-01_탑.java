package 백준;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class 탑 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		int[] top = new int[N];
		//초기화
		for(int i = 0; i < N; i++) {
			top[i] = Integer.parseInt(st.nextToken());
		}

		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < N; i++) {
			if(stack.isEmpty()) {
				sb.append(0+" ");
				stack.push(i);
			}
			else {
				while(true) {
					if(stack.isEmpty()) {
						sb.append(0+" ");
						stack.push(i);
						break;
					}
					if(top[stack.peek()] < top[i]) {
						stack.pop();
					}
					else {
						sb.append((stack.peek()+1)+" ");
						stack.push(i);
						break;
					}
				}
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
