import java.util.*;
public class 어린왕자 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int n = sc.nextInt();
			int cnt = 0;
			for(int i = 0; i < n; i++) {
				int cx = sc.nextInt();
				int cy = sc.nextInt();
				int r = sc.nextInt();
				if(calc(cx,cy,x1,y1)<r*r && calc(cx,cy,x2,y2)<r*r) {
					continue;
				}
				else if(calc(cx,cy,x1,y1)<r*r || calc(cx,cy,x2,y2)<r*r)
					cnt++;
			}
			System.out.println(cnt);
		}
	}

	private static int calc(int cx, int cy, int x, int y) {
		// TODO Auto-generated method stub
		return (cx-x)*(cx-x)+(cy-y)*(cy-y);
	}
}
