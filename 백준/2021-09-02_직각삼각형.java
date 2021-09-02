package 쩜문제추천;
import java.util.*;
public class 직각삼각형 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			if(a == 0 && b == 0 && c == 0)
				break;
			long powA = a*a;
			long powB = b*b;
			long powC = c*c;
			if(powA == powB + powC || powB == powA + powC  || powC == powB + powA) {
				System.out.println("right");
				continue;
			}
			System.out.println("wrong");
		}
	}
}
