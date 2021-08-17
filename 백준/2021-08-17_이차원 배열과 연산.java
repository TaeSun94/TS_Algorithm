package 쩜문제추천;
import java.util.*;
import java.io.*;
public class 이차원배열과연산 {
	static int[][] map = new int[100][100];
	static class Num implements Comparable<Num>{
		int data, count;

		public Num(int data, int count) {
			super();
			this.data = data;
			this.count = count;
		}

		@Override
		public int compareTo(Num o) {
			// TODO Auto-generated method stub
			if(this.count == o.count) {
				return this.data-o.data;
			}
			else
				return this.count-o.count;
		}

	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int r = Integer.parseInt(st.nextToken())-1;
		int c = Integer.parseInt(st.nextToken())-1;
		int k = Integer.parseInt(st.nextToken());
		int answer = 0;
		for(int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int rSize = 3;
		int cSize = 3;
		while(true) {
			if(answer > 100) {
				answer = -1;
				break;
			}
			if(map[r][c]==k)
				break;
			if(rSize >= cSize) {
//				System.out.println("R연산");
				//r연산
				int max = 0;
				for(int i = 0; i < rSize; i++) {
					HashMap<Integer, Integer> hm = new HashMap<>();
					for(int j = 0; j < cSize; j++) {
						if(map[i][j] == 0)
							continue;
						if(hm.containsKey(map[i][j])) {
							hm.replace(map[i][j], hm.get(map[i][j])+1);
						}
						else {
							hm.put(map[i][j], 1);
						}
					}
					PriorityQueue<Num> pq = new PriorityQueue<>();
					for(int key: hm.keySet()) {
						pq.add(new Num(key,hm.get(key)));
					}
					int size = pq.size()*2;
					if(size> 100)
						size = 100;
					max = Math.max(max, size);
					for(int j = 0; j < size; j+=2) {
						Num n = pq.poll();
						map[i][j] = n.data;
						map[i][j+1] = n.count;
					}
					for(int j = size; j < cSize; j++) {
						map[i][j] = 0;
					}
				}
				cSize = max;
			}
			else {
//				System.out.println("C연산");
				//c연산
				int max = 0;
				for(int i = 0; i < cSize; i++) {
					HashMap<Integer, Integer> hm = new HashMap<>();
					for(int j = 0; j < rSize; j++) {
						if(map[j][i] == 0)
							continue;
						if(hm.containsKey(map[j][i])) {
							hm.replace(map[j][i], hm.get(map[j][i])+1);
						}
						else {
							hm.put(map[j][i], 1);
						}
					}
					PriorityQueue<Num> pq = new PriorityQueue<>();
					for(int key: hm.keySet()) {
						pq.add(new Num(key,hm.get(key)));
					}
					int size = pq.size()*2;
					if(size> 100)
						size = 100;
					max = Math.max(max, size);
					for(int j = 0; j < size;) {
						Num n = pq.poll();
						map[j++][i] = n.data;
						map[j++][i] = n.count;
					}
					for(int j = size; j < rSize; j++) {
						map[j][i] = 0;
					}
				}
				rSize = max;
			}
			answer++;
//			for(int i = 0; i < 10; i++) {
//				for(int j = 0; j < 10; j++) {
//					System.out.print(map[i][j]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println(rSize+" "+cSize);
		}
		bw.write(answer+"");
		bw.flush();
		bw.close();
	}
}
