package 쩜문제추천;
import java.util.*;
public class 직사각형에서탈출 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		int min = Integer.MAX_VALUE;
		min = Math.min(min, Math.abs(x-w));
		min = Math.min(min, Math.abs(0-x));
		min = Math.min(min, Math.abs(y-h));
		min = Math.min(min, Math.abs(0-y));
		System.out.println(min);
	}
}
