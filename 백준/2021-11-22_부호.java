import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
public class 부호 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc = 1; tc <= 3; tc++) {
			int N = Integer.parseInt(br.readLine());
			BigInteger S = new BigInteger("0");
			for(int i = 0; i < N; i++) {
				BigInteger num = new BigInteger(br.readLine());
				S = S.add(num);
			}

			if(S.compareTo(new BigInteger("0"))==0) {
				System.out.println(0);
			}
			else if(S.compareTo(new BigInteger("0"))==1) {
				System.out.println("+");
			}
			else {
				System.out.println("-");
			}
		}
	}
}
