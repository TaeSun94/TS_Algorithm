import java.util.*;
public class 꼬리를무는숫자나열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt()-1;
		int end = sc.nextInt()-1;

		System.out.println(Math.abs(start/4-end/4)+Math.abs(start%4-end%4));
	}
}
