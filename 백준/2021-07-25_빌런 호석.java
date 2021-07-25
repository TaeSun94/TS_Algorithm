import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class Main {
	static ArrayList<ArrayList<Integer>> digital;
	static int[][] mem;
	static HashSet<String> stk;
	static int N,K,P;
	static String X;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		MakeList();
		mem = new int[10][10];
		for(int i = 0; i < digital.size()-1; i++) {
			for(int j = i+1; j < digital.size(); j++) {
				mem[i][j] = LEDCnt(digital.get(i),digital.get(j));
				mem[j][i] = mem[i][j];
			}
		}
		stk = new HashSet<>();
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		X = st.nextToken();
		int len = X.length();
		while(len < K) {
			X = "0"+X;
			len++;
		}
		dfs(0,"",0);
		bw.write(stk.size()+"\n");
		bw.flush();
		bw.close();
	}
	private static void dfs(int idx, String string, int cnt) {
		// TODO Auto-generated method stub
		if(idx == X.length()) {
			if(string.equals(X))
				return;
			if(Integer.parseInt(string)<= N && Integer.parseInt(string)>0)
				stk.add(string);
			return;
		}
		if(cnt == P) {
			if(string.length()< X.length()) {
				for(int i = string.length(); i < X.length(); i++) {
					string += X.charAt(i);
				}
			}
			if(string.equals(X))
				return;
			if(Integer.parseInt(string)<= N && Integer.parseInt(string)>0)
				stk.add(string);
			return;
		}
		for(int i = 0; i < mem.length; i++) {
			if(mem[X.charAt(idx)-'0'][i]+cnt <= P) {
				dfs(idx+1,string+i,cnt+mem[X.charAt(idx)-'0'][i]);
			}
		}
	}
	private static int LEDCnt(ArrayList<Integer> arrayList, ArrayList<Integer> arrayList2) {
		int cnt = 0;
		for(int i = 0; i < arrayList.size(); i++) {
			if(!arrayList2.contains(arrayList.get(i)))
				cnt++;
		}
		for(int i = 0; i < arrayList2.size(); i++) {
			if(!arrayList.contains(arrayList2.get(i)))
				cnt++;
		}

		return cnt;
	}
	private static void MakeList() {
		digital = new ArrayList<>();
		digital.add(new ArrayList<>(Arrays.asList(1,2,3,5,6,7)));
		digital.add(new ArrayList<>(Arrays.asList(3,6)));
		digital.add(new ArrayList<>(Arrays.asList(1,3,4,5,7)));
		digital.add(new ArrayList<>(Arrays.asList(1,3,4,6,7)));
		digital.add(new ArrayList<>(Arrays.asList(2,3,4,6)));
		digital.add(new ArrayList<>(Arrays.asList(1,2,4,6,7)));
		digital.add(new ArrayList<>(Arrays.asList(1,2,4,5,6,7)));
		digital.add(new ArrayList<>(Arrays.asList(1,3,6)));
		digital.add(new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7)));
		digital.add(new ArrayList<>(Arrays.asList(1,2,3,4,6,7)));
		return;
	}
}
