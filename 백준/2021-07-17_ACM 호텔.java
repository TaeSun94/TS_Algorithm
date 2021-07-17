import java.util.*;
public class ACM호텔 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 0; tc < T; tc++) {
			int h = sc.nextInt();
			int w = sc.nextInt();
			int n = sc.nextInt();
			//나머지가 존재한다면 나머지로 yy결정 몫으로 xx결정
			if(n%h == 0) {
				System.out.println((h*100)+n/h);
			}
			else {
				System.out.println((n%h*100 + n/h+1));
			}
		}
	}
}
