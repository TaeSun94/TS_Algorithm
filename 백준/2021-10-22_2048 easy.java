package 쩜문제추천;
import java.util.*;
import java.io.*;
public class 이공사팔 {
	static int answer = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int[][] board = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,board);
		bw.write(answer+"");
		bw.flush();
		bw.close();
	}
	private static void dfs(int count, int[][] board) {
		// TODO Auto-generated method stub
		if(count == 5) {
			findMax(board);
			return;
		}

		up(count, board);
		down(count, board);
		left(count, board);
		right(count, board);

	}
	static class Num{
		int num;
		boolean check;
		public Num(int num, boolean check) {
			super();
			this.num = num;
			this.check = check;
		}
	}
	private static void right(int count, int[][] board) {
		// TODO Auto-generated method stub
		int[][] ret = new int[board.length][board.length];
		Stack<Num> stack = new Stack<>();
		for(int i = 0; i < board.length; i++) {
			for(int j = board.length-1; j >= 0; j--) {
				if(board[i][j] != 0) {
					if(!stack.isEmpty()) {
						if(stack.peek().num == board[i][j] && !stack.peek().check) {
							stack.pop();
							stack.push(new Num(board[i][j]*2,true));
						}
						else {
							stack.push(new Num(board[i][j],false));
						}
					}else {
						stack.push(new Num(board[i][j],false));
					}
				}
			}
			if(!stack.isEmpty()) {
				int pos = stack.size()-1;
				for(int p = pos; p >= 0; p--) {
					ret[i][board.length-1-p] = stack.pop().num;
				}
			}
		}
		dfs(count+1, ret);
		return;
	}
	private static void left(int count, int[][] board) {
		// TODO Auto-generated method stub
		int[][] ret = new int[board.length][board.length];
		Stack<Num> stack = new Stack<>();
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board.length; j++) {
				if(board[i][j] != 0) {
					if(!stack.isEmpty()) {
						if(stack.peek().num == board[i][j] && !stack.peek().check) {
							stack.pop();
							stack.push(new Num(board[i][j]*2,true));
						}
						else {
							stack.push(new Num(board[i][j],false));
						}
					}else {
						stack.push(new Num(board[i][j],false));
					}
				}
			}
			if(!stack.isEmpty()) {
				int pos = stack.size()-1;
				for(int p = pos; p >= 0; p--) {
					ret[i][p] = stack.pop().num;
				}
			}
		}
		dfs(count+1, ret);
		return;
	}
	private static void down(int count, int[][] board) {
		// TODO Auto-generated method stub
		int[][] ret = new int[board.length][board.length];
		Stack<Num> stack = new Stack<>();
		for(int i = 0; i < board.length; i++) {
			for(int j = board.length-1; j >= 0; j--) {
				if(board[j][i] != 0) {
					if(!stack.isEmpty()) {
						if(stack.peek().num == board[j][i] && !stack.peek().check) {
							stack.pop();
							stack.push(new Num(board[j][i]*2,true));
						}
						else {
							stack.push(new Num(board[j][i],false));
						}
					}else {
						stack.push(new Num(board[j][i],false));
					}
				}
			}
			if(!stack.isEmpty()) {
				int pos = stack.size()-1;
				for(int p = pos; p >= 0; p--) {
					ret[board.length-1-p][i] = stack.pop().num;
				}
			}
		}
		dfs(count+1, ret);
		return;
	}
	private static void up(int count, int[][] board) {
		// TODO Auto-generated method stub
		int[][] ret = new int[board.length][board.length];
		Stack<Num> stack = new Stack<>();
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board.length; j++) {
				if(board[j][i] != 0) {
					if(!stack.isEmpty()) {
						if(stack.peek().num == board[j][i] && !stack.peek().check) {
							stack.pop();
							stack.push(new Num(board[j][i]*2,true));
						}
						else {
							stack.push(new Num(board[j][i],false));
						}
					}else {
						stack.push(new Num(board[j][i],false));
					}
				}
			}
			if(!stack.isEmpty()) {
				int pos = stack.size()-1;
				for(int p = pos; p >= 0; p--) {
					ret[p][i] = stack.pop().num;
				}
			}
		}
		dfs(count+1, ret);
		return;
	}
	private static void findMax(int[][] board) {
		// TODO Auto-generated method stub
		int ans = 0;
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				ans = Math.max(ans, board[i][j]);
			}
		}
		answer = Math.max(answer,ans);
	}
}
