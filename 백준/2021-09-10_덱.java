package 쩜문제추천;

import java.util.*;
import java.io.*;

/*
push_front X: 정수 X를 덱의 앞에 넣는다.
push_back X: 정수 X를 덱의 뒤에 넣는다.
pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 덱에 들어있는 정수의 개수를 출력한다.
empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 */
public class 덱 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		Deque<Integer> deq = new LinkedList<Integer>();
		for (int i = 0; i < N; i++) {
			String[] order = br.readLine().split(" ");
			if (order.length > 1) {
				if (order[0].contains("front")) {
					deq.addFirst(Integer.parseInt(order[1]));
				} else {
					deq.addLast(Integer.parseInt(order[1]));
				}
			} else {
				if (order[0].equals("size")) {
					bw.write(deq.size()+"\n");
				} else if (order[0].equals("empty")) {
					if(deq.isEmpty()) {
						bw.write(1+"\n");
					}
					else {
						bw.write(0+"\n");
					}
				} else if (order[0].equals("front")) {
					if(deq.isEmpty()) {
						bw.write(-1+"\n");
						continue;
					}
					bw.write(deq.getFirst()+"\n");
				} else if (order[0].equals("back")) {
					if(deq.isEmpty()) {
						bw.write(-1+"\n");
						continue;
					}
					bw.write(deq.getLast()+"\n");
				}
				else {
					if(order[0].contains("front")) {
						if(deq.isEmpty()) {
							bw.write(-1+"\n");
							continue;
						}
						bw.write(deq.pollFirst()+"\n");
					}
					else {
						if(deq.isEmpty()) {
							bw.write(-1+"\n");
							continue;
						}
						bw.write(deq.pollLast()+"\n");
					}
				}
			}
		}
		bw.flush();
		bw.close();
	}
}
