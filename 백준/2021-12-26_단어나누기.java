import java.util.*;
public class 단어나누기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		ArrayList<String> list = new ArrayList<String>();
		String[] inputs = new String[3];
		for(int i = 1; i < input.length()-1; ++i) {
			for(int j = i+1; j < input.length(); ++j) {
				inputs[0] = input.substring(0,i);
				inputs[1] = input.substring(i,j);
				inputs[2] = input.substring(j,input.length());
				StringBuilder sb = new StringBuilder();
				for(int l = 0; l < inputs.length; l++) {
					for(int k = inputs[l].length()-1; k >=0; k--) {
						sb.append(inputs[l].charAt(k));
					}
				}
				list.add(sb.toString());
			}
		}
		Collections.sort(list);
		System.out.println(list.get(0));
	}
}
