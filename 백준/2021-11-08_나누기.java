import java.util.*;
public class 나누기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int F = sc.nextInt();
		String ans = "";
		int tmp = 0;
		N /= 100;
		N *= 100;
		for (; tmp < 100; N++, tmp++) {
			if (N % F == 0)
				break;
		}
		if (tmp <= 9)
			ans += "0";
		ans += tmp;
		System.out.println(ans);
	}
}
