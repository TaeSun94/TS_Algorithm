import java.util.*;
public class 뒤집힌덧셈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		String X = sc.next();
		String Y = sc.next();
		String revX = sb.append(X).reverse().toString();
		sb = new StringBuilder();
		String revY = sb.append(Y).reverse().toString();
		sb = new StringBuilder();
		String ans = Integer.parseInt(revX)+Integer.parseInt(revY)+"";
		ans = sb.append(ans).reverse().toString();
		System.out.println(Integer.parseInt(ans));
	}
}
