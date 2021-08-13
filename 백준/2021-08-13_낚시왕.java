package 쩜문제추천;
import java.io.*;
import java.util.*;
public class 낚시왕 {
	static class Shark implements Comparable<Shark>{
		int r,c,s,d,z;

		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}

		@Override
		public int compareTo(Shark o) {
			// TODO Auto-generated method stub
			return this.z-o.z;
		}

		@Override
		public String toString() {
			return "Shark [r=" + r + ", c=" + c + ", s=" + s + ", d=" + d + ", z=" + z + "]";
		}

	}
	static Queue<Shark> catchs;
	static PriorityQueue<Shark>[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new PriorityQueue[R][C];
		for(int i = 0 ; i < R; i++) {
			for(int j = 0; j < C; j++) {
				map[i][j] = new PriorityQueue<>();
			}
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken())-1;
			int z = Integer.parseInt(st.nextToken());
			map[r][c].add(new Shark(r,c,s,d,z));
		}
		catchs = new LinkedList<>();
		//사람이동
		for(int i = 0; i < C; i++) {
			//상어 잡기
			catchShark(i);
			//상어 이동
			moveShark();
//			for(int k = 0; k < map.length; k++) {
//				for(int j = 0; j < map[k].length; j++) {
//					if(map[k][j].size()>0)
//						System.out.print(map[k][j].peek().toString()+" ");
//					else
//						System.out.print(0+" ");
//				}
//				System.out.println();
//			}
//			System.out.println();
		}
		int answer = sumWeight();
		bw.write(answer+"");
		bw.flush();
		bw.close();
	}
	private static int sumWeight() {
		// TODO Auto-generated method stub
		int sum = 0;
		while(!catchs.isEmpty()) {
			Shark s = catchs.poll();
			sum += s.z;
		}
		return sum;
	}
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,1,-1};
	private static void moveShark() {
		// TODO Auto-generated method stub
		PriorityQueue<Shark>[][] tmp = new PriorityQueue[map.length][map[0].length];
		//임시 배열 선언
		for(int i = 0; i < tmp.length; i++) {
			for(int j = 0; j < tmp[i].length; j++)
				tmp[i][j] = new PriorityQueue<>();
		}
		//이동
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				if(map[i][j].size()>0) {
					Shark shark = map[i][j].poll();
					int nr = shark.r;
					int nc = shark.c;
					int dist = shark.s;
					if(shark.d < 2) {
						dist = dist %((map.length-1)*2);
					}
					else {
						dist = dist %((map[0].length-1)*2);
					}
					for(int d = 0; d < dist; d++) {
						nr += dr[shark.d];
						nc += dc[shark.d];
						if(nr < 0 || nc < 0 || nr >= map.length || nc >= map[nr].length) {
							nr -= dr[shark.d];
							nc -= dc[shark.d];
							shark.d++;
							if(shark.d > 2) {
								if(shark.d==4)
									shark.d -=2;
							}
							else {
								if(shark.d == 2)
									shark.d -=2;
							}
							d--;
						}
					}
					if(tmp[nr][nc].size()>=1) {
						if(tmp[nr][nc].peek().z > shark.z)
							continue;
						else {
							tmp[nr][nc].poll();
						}
					}
					tmp[nr][nc].add(new Shark(nr,nc,shark.s,shark.d,shark.z));
				}
			}
		}
		map = tmp;
		//여러개 상어일 경우 제일 큰거 제외한 뒤 나머지 삭제
//		for(int i = 0; i < map.length; i++) {
//			for(int j = 0; j < map[i].length; j++) {
//				if(map[i][j].size()>1) {
//					Shark s = map[i][j].poll();
//					while(!map[i][j].isEmpty()) {
//						map[i][j].poll();
//					}
//					map[i][j].add(s);
//				}
//			}
//		}
	}
	private static void catchShark(int idx) {
		// TODO Auto-generated method stub
		for(int i = 0; i < map.length; i++) {
			if(map[i][idx].size()>0) {
				catchs.add(map[i][idx].poll());
				break;
			}
		}
		return;
	}
}
