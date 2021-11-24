import java.math.BigInteger;
import java.util.*;
public class 엄청난부자2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger m = new BigInteger(sc.next());
		BigInteger n = new BigInteger(sc.next());

		System.out.println(m.divideAndRemainder(n)[0]);
		System.out.println(m.divideAndRemainder(n)[1]);
	}
}
