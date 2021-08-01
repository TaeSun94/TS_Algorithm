package 백준;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class 강의실배정 {
	static class Class implements Comparable<Class>{
		int start,end;

		public Class(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Class o) {
			// TODO Auto-generated method stub
			return this.end-o.end;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		ArrayList<Class> list = new ArrayList<>();
		PriorityQueue<Class> pq = new PriorityQueue<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			list.add(new Class(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		Collections.sort(list, new Comparator<Class>() {

			@Override
			public int compare(Class o1, Class o2) {
				// TODO Auto-generated method stub
				if(o1.start==o2.start) {
					return o1.end-o2.end;
				}
				return o1.start-o2.start;
			}
		});
		pq.add(list.get(0));
		for(int i = 1; i < list.size(); i++) {
			if(pq.peek().end <= list.get(i).start) {
				pq.poll();
			}
			pq.add(list.get(i));
		}
		bw.write(pq.size()+"");
		bw.flush();
		bw.close();
	}
}
