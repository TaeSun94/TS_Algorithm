package 쩜문제추천;
import java.util.*;
import java.io.*;
public class 게리맨더링2 {
	static int[][] city;
	static int[][] label;
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		city = new int[N][N];
		label = new int[N][N];
		min = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < N; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//모든 좌표를 돌며 d1,d2를 넣어 좌표 확인 후 구역이 나눠질 경우 구역별 사람 수 구하기.
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				for(int d1 = 1; d1 <= j; d1++) {
					for(int d2 = 1; d2 <= N-j; d2++) {
						if(checkLine(i,j,d1,d2)) {
							drawLabel(i,j,d1,d2);
//							for(int[] c: label)
//								System.out.println(Arrays.toString(c));
//							System.out.println();
						}
					}
				}

			}
		}
		bw.write(min+"");
		bw.flush();
		bw.close();
	}
	private static void drawLabel(int x, int y, int d1, int d2) {
		// TODO Auto-generated method stub
		int[][] points = new int[4][2];
		points[0][0] = x;
		points[0][1] = y;
		points[1][0] = x+d1;
		points[1][1] = y-d1;
		points[2][0] = x+d2;
		points[2][1] = y+d2;
		points[3][0] = x+d1+d2;
		points[3][1] = y-d1+d2;
		//모든 점에 5로 라벨링
		for(int i = 0; i < city.length; i++) {
			for(int j = 0; j < city.length; j++)
				label[i][j] = 5;
		}
		//1번 선거구: 1 ≤ r < x+d1, 1 ≤ c ≤ y
		int sub = 0;
		for(int i = 0; i < points[1][0]; i++) {
			if(i>= points[0][0])sub++;
			for(int j = 0; j <= points[0][1]-sub; j++)
				label[i][j] = 1;

		}

		//2번 선거구: 1 ≤ r ≤ x+d2, y < c ≤ N
		sub = 0;
		for(int i = 0; i <= points[2][0]; i++) {
			if(i>points[0][0]) sub++;
			for(int j = points[0][1]+1+sub; j < city.length; j++) {
				label[i][j] = 2;
			}
		}
		sub = 0;
		//3번 선거구: x+d1 ≤ r ≤ N, 1 ≤ c < y-d1+d2
		for(int i = city.length-1; i >= points[1][0]; i--) {
			if(i<points[3][0]) sub++;
			for(int j = 0; j <points[3][1]-sub;j++) {
				label[i][j] = 3;
			}
		}
		//4번 선거구: x+d2 < r ≤ N, y-d1+d2 ≤ c ≤ N
		sub = 0;
		for(int i = city.length-1; i > points[2][0]; i--) {
			if(i<=points[3][0]) sub++;
			for(int j = points[3][1]+sub; j < city.length; j++) {
				label[i][j] = 4;
			}
		}
		calc();
		return;
	}
	private static void calc() {
		// TODO Auto-generated method stub
		int[] sum = new int[6];
		for(int i = 0; i < city.length; i++) {
			for(int j = 0; j < city.length; j++)
				sum[label[i][j]] += city[i][j];
		}
		Arrays.sort(sum);
		min = Math.min(min, sum[5]-sum[1]);
	}
	private static boolean checkLine(int x, int y, int d1, int d2) {
		// TODO Auto-generated method stub
		if(x+d1 >= city.length || y - d1 < 0)return false;
		if(x+d2 >= city.length || y+d2 >=city.length) return false;
		if(x+d1+d2 >= city.length || x-d1+d2 >= city.length) return false;
		if(x+d1+d2 >= city.length|| y+d2-d1 < 0) return false;
		return true;
	}
}
