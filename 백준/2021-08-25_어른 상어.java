import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] di = {0,-1,1,0,0};
	static int[] dj = {0,0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int [][][] arr =new int[N][N][2]; //상어, 냄새
		int [] si = new int[M+1];
		int [] sj = new int[M+1];
		for(int i = 0; i<N;i++) {
			st =new StringTokenizer(br.readLine());
			for(int j = 0; j< N;j++) {
				int a = Integer.parseInt(st.nextToken());
				arr[i][j][0] = a;
				if(a!=0) {
					si[a]= i;
					sj[a] = j;
					arr[i][j][1]=K;
				}
			}
		}
		// 현재 방향
		int[] d = new int[M+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=M;i++) {
			d[i] = Integer.parseInt(st.nextToken());
		}
		// 이제 우선순위 상1,하2,좌3, 우4
		int[][][] order = new int[M+1][5][4];
		for(int i = 1; i<=M;i++) {
			for(int j = 1; j<5;j++) {
				st = new StringTokenizer(br.readLine());
				for(int k = 0; k<4;k++) {
					order[i][j][k] =Integer.parseInt(st.nextToken());
				}
			}
		}
		int m = M; // 남은 상어 수
		int time = 0;
		while(m>1 && time <1001) {

//			System.out.println(Arrays.toString(d));


			// 작은 얘들부터 이동을 시킨다.
			for(int s = M; s>0;s--) {
				if(si[s]<0)continue;
				int i = si[s];
				int j = sj[s];
				boolean flag = false;
				for(int a = 0; a<4;a++) {
					if(i+di[order[s][d[s]][a]]<0 ||  i+di[order[s][d[s]][a]]>N-1 ||j+dj[order[s][d[s]][a]]<0 || j+dj[order[s][d[s]][a]]>N-1 )
						continue;
					if(arr[i+di[order[s][d[s]][a]]][j+dj[order[s][d[s]][a]]][0]==0) {
						d[s] = order[s][d[s]][a];
						si[s]+=di[d[s]];
						sj[s]+=dj[d[s]];
						j = sj[s];
						i = si[s];
						flag = true;
						break;
					}
				}
				if(!flag) {
					for(int a = 0; a<4;a++) {
						if(i+di[order[s][d[s]][a]]<0 ||  i+di[order[s][d[s]][a]]>N-1 ||j+dj[order[s][d[s]][a]]<0 || j+dj[order[s][d[s]][a]]>N-1 )
							continue;
						if(arr[i+di[order[s][d[s]][a]]][j+dj[order[s][d[s]][a]]][0]==s) {
							d[s] = order[s][d[s]][a];
							si[s]+=di[d[s]];
							sj[s]+=dj[d[s]];
							break;
						}
					}
				}
			}// 이동완료
			// 먼저 시간이 지났으니 다 뺀다.
			for(int i = 0; i<N;i++) {
				for(int j = 0; j<N;j++) {
					if(arr[i][j][1]>1) {
						arr[i][j][1]--;
					}else if(arr[i][j][1]==1) {
						arr[i][j][1]=0;
						arr[i][j][0]=0;
					}
				}
			}
			for(int s = M;s>0;s--) { //자리 잡고 냄새 뿌리기
				if(si[s]<0)continue;
				int t;
				for(t = s-1; t>0;t--) {
					if(si[t]==si[s] && sj[t]==sj[s]) {
						si[s] = -s;
						sj[s]=-s;
						d[s] = 0;
						m--;
						break;
					}
				}
				if(t==0) {
					arr[si[s]][sj[s]][0] = s;
					arr[si[s]][sj[s]][1] = K;
				}
			}
//			System.out.println(time);
			time++;
//			for(int i = 0; i<N;i++) {
//				for(int j = 0; j<N;j++) {
//					if(arr[i][j][0]==0) {
//						System.out.print('-');
//						if(arr[i][j][1]==0) {
//							System.out.print("-"+" ");
//						}
//					}else {
//						System.out.print(arr[i][j][0]+""+arr[i][j][1]+" ");
//					}
//
//				}
//				System.out.println();
//			}
		}
		if(m!=1)System.out.println(-1);
		else System.out.println(time==1001?-1:time);
	}
}
