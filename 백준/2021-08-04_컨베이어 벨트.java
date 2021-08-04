package 쩜문제추천;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class 컨베이어벨트 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] A = new int[N*2];
		st = new StringTokenizer(br.readLine()," ");
		int count = 0;
		for(int i = 0; i < N*2; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		int ans = 0;
		boolean[] robot = new boolean[N];
		while(check(K,A)) {
			//회전
			int tmp = A[A.length-1];
			for(int i = A.length-1; i >0; i--) {
				A[i] = A[i-1];
			}
			A[0] = tmp;
			//로봇이 있다면 이동
			for(int i = robot.length-1; i > 0; i--) {
				robot[i] = robot[i-1];
			}
			robot[0] = false;
			//걸어가기
			robot[N-1] = false;
			for(int i = robot.length-1; i > 0; i--) {
				if(robot[i-1] && !robot[i] && A[i]>0) {
					robot[i] = true;
					robot[i-1] = false;
					A[i]--;
				}
			}
			//해당 첫번째 자리에 로봇 올리기
			if(A[0] > 0) {
				robot[0] = true;
				A[0]--;
			}
			ans++;
		}
		bw.write(ans+"");
		bw.flush();
		bw.close();
	}

	private static boolean check(int k, int[] a) {
		// TODO Auto-generated method stub
		int cnt = 0;
		for(int i = 0; i < a.length;i++) {
			if(a[i] == 0) {
				cnt++;
			}
			if(cnt >= k)
				return false;
		}

		return true;
	}
}
