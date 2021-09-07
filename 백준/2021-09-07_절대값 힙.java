package 쩜문제추천;
import java.util.*;
import java.io.*;
public class 절대값힙 {
	static class Num implements Comparable<Num>{
		int number;
		int absNumber;
		public Num(int number, int absNumber) {
			super();
			this.number = number;
			this.absNumber = absNumber;
		}
		@Override
		public int compareTo(Num o) {
			// TODO Auto-generated method stub
			if(this.absNumber == o.absNumber) {
				return this.number-o.number;
			}
			return this.absNumber-o.absNumber;
		}

	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		PriorityQueue<Num> numbers = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());
		for(int index = 0; index < N; index++) {
			int order = Integer.parseInt(br.readLine());
			if(order == 0) {
				if(numbers.isEmpty()) {
					bw.write(0+"\n");
				}
				else {
					bw.write(numbers.poll().number+"\n");
				}
				continue;
			}
			numbers.add(new Num(order, Math.abs(order)));
		}
		bw.flush();
		bw.close();
	}
}
