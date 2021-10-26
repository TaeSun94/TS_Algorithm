package 쩜문제추천;
import java.util.*;
public class 다각형의면적 {
	static class Point{
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Point> list = new ArrayList<>();
		int N = sc.nextInt();
		long[] x = new long[N+1];
		long[] y = new long[N+1];
		for(int i = 0; i < N; i++) {
			x[i] = sc.nextLong();
			y[i] = sc.nextLong();
		}
		long x_sum = 0;
		long y_sum = 0;
		x[N] = x[0];
		y[N] = y[0];
		for(int i = 0; i < N; i++) {
			x_sum += x[i]*y[i+1];
			y_sum += y[i]*x[i+1];
		}
		System.out.format("%.1f", (Math.abs(x_sum-y_sum)/2.0));
	}
}
