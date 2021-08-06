package 쩜문제추천;
import java.io.*;
import java.util.*;
public class 톱니바퀴 {
	static ArrayList<int[]> wheel;
	static class Rotate{
		int number, dir;

		public Rotate(int number, int dir) {
			super();
			this.number = number;
			this.dir = dir;
		}

	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		wheel = new ArrayList<>();
		for(int i = 0; i < 4; i++) {
			String str = br.readLine();
			int[] arr = new int[str.length()];
			for(int j = 0; j < str.length(); j++) {
				arr[j] = str.charAt(j)-'0';
			}
			wheel.add(arr);
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int number = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			//회전
			bfs(number, dir);

		}
		//결과 출력
		int answer = 0;
		int idx = 0;
		for(int[] wheelNum: wheel) {
			if(wheelNum[0]==1) {
				answer += Math.pow(2, idx);
			}
			idx++;
		}
		bw.write(answer+"");
		bw.flush();
		bw.close();
	}
	static int[] dc = {-1,1};
	private static void bfs(int number, int dir) {
		// TODO Auto-generated method stub
		boolean[] check = new boolean[wheel.size()];
		Queue<Rotate> que = new LinkedList<>();
		check[number-1] = true;
		int[] directions = new int[4];
		directions[number-1] = dir;
		que.add(new Rotate(number-1,dir));
		while(!que.isEmpty()) {
			Rotate r = que.poll();
			for(int d = 0; d < dc.length; d++) {
				int num = r.number + dc[d];
				if(num < 0 || num >= check.length || check[num])
					continue;
				if(r.number > num) {
					if(wheel.get(r.number)[6] != wheel.get(num)[2]) {
						directions[num] = directions[r.number]*(-1);
					}
					check[num] = true;
					que.add(new Rotate(num,directions[num]));
				}
				else {
					if(wheel.get(r.number)[2] != wheel.get(num)[6]) {
						directions[num] = directions[r.number]*(-1);
					}
					check[num] = true;
					que.add(new Rotate(num,directions[num]));
				}
			}
		}
		for(int i = 0; i < directions.length; i++) {
			if(directions[i] == 0)
				continue;
			rotate(i,directions[i]);
		}
		return;
	}
	private static void rotate(int num, int dir) {
		// TODO Auto-generated method stub
		int[] arr = wheel.get(num);
		if(dir > 0) {
			int tmp = arr[arr.length-1];
			for(int i = arr.length-1; i > 0; i--) {
				arr[i] = arr[i-1];
			}
			arr[0] = tmp;
		}
		else {
			int tmp = arr[0];
			for(int i = 0; i < arr.length-1; i++) {
				arr[i] = arr[i+1];
			}
			arr[arr.length-1] = tmp;

		}
	}
}
