/*
정확성  테스트
테스트 1 〉	통과 (14.21ms, 52.9MB)
테스트 2 〉	통과 (13.41ms, 53.7MB)
테스트 3 〉	통과 (15.93ms, 54.5MB)
테스트 4 〉	실패 (13.30ms, 54.9MB)
테스트 5 〉	실패 (15.86ms, 53.8MB)
테스트 6 〉	실패 (13.88ms, 53.1MB)
테스트 7 〉	실패 (20.82ms, 53.6MB)
테스트 8 〉	실패 (14.06ms, 53.2MB)
테스트 9 〉	실패 (15.92ms, 52.7MB)
테스트 10 〉	통과 (14.90ms, 53.4MB)
테스트 11 〉	실패 (22.99ms, 54.1MB)
테스트 12 〉	실패 (19.61ms, 53.6MB)
테스트 13 〉	실패 (17.82ms, 53.6MB)
테스트 14 〉	실패 (16.50ms, 52.7MB)
테스트 15 〉	실패 (19.13ms, 54.2MB)
테스트 16 〉	실패 (16.12ms, 53.7MB)
테스트 17 〉	실패 (22.61ms, 54.1MB)
테스트 18 〉	실패 (28.50ms, 54.8MB)
테스트 19 〉	실패 (30.25ms, 53.8MB)
테스트 20 〉	실패 (22.74ms, 54.4MB)
테스트 21 〉	실패 (22.67ms, 53.9MB)
테스트 22 〉	실패 (26.30ms, 54.6MB)
테스트 23 〉	실패 (17.16ms, 53.3MB)
테스트 24 〉	실패 (12.58ms, 53.4MB)
테스트 25 〉	통과 (13.24ms, 52.8MB)
테스트 26 〉	통과 (13.04ms, 52.6MB)
테스트 27 〉	실패 (14.66ms, 53.4MB)
테스트 28 〉	실패 (16.00ms, 53.7MB)
테스트 29 〉	실패 (14.45ms, 53.1MB)
테스트 30 〉	실패 (13.85ms, 53.7MB)
효율성  테스트
테스트 1 〉	실패 (시간 초과)
테스트 2 〉	실패 (시간 초과)
테스트 3 〉	실패 (시간 초과)
테스트 4 〉	실패 (시간 초과)
테스트 5 〉	실패 (시간 초과)
테스트 6 〉	실패 (시간 초과)
테스트 7 〉	실패 (시간 초과)
테스트 8 〉	실패 (시간 초과)
테스트 9 〉	실패 (시간 초과)
테스트 10 〉	실패 (시간 초과)
채점 결과
정확성: 6.0
효율성: 0.0
합계: 6.0 / 100.0
*/
import java.util.*;
class Solution {
    static class Node{
        int data;
        int num;
        Node(int data){
            this.data =data;
        }
    }
    // static Queue
    public String solution(int n, int k, String[] cmd) {
        String answer = "";
        LinkedList<Node> list = new LinkedList<>();
        for(int i = 0; i < n; i++){
            list.add(new Node(i));
        }
        Stack<Node> del = new Stack<>();

        //for문을 돌며 명령어 처리
        for(int i = 0; i < cmd.length; i++){
            if(cmd[i].length() > 1){
                if(cmd[i].charAt(0)=='D'){
                    k += cmd[i].charAt(cmd[i].length()-1)-'0';
                    if(k >= list.size()){
                        k = list.size()-1;
                    }
                }
                else{
                    k -= cmd[i].charAt(cmd[i].length()-1)-'0';
                    if(k < 0){
                        k = 0;
                    }
                }
            }
            else{
                if(k >= list.size()){
                    k = list.size()-1;
                }
                if(cmd[i].equals("C")){
                    Node node = list.get(k);
                    node.num = k;
                    list.remove(k);
                    del.push(node);

                }
                else{
                    Node node = del.pop();
                    list.add(node.num, node);
                }
            }
        }
        char[] arr = new char[n];
        Arrays.fill(arr,'X');
        for(Node tmp: list){
            arr[tmp.data] = 'O';
        }
        for(char c : arr){
            answer+= c;
        }
        return answer;
    }
}

/*
정확성  테스트
테스트 1 〉	통과 (13.03ms, 53.3MB)
테스트 2 〉	통과 (13.67ms, 52.8MB)
테스트 3 〉	통과 (13.12ms, 53.6MB)
테스트 4 〉	통과 (14.67ms, 54.4MB)
테스트 5 〉	통과 (19.40ms, 52.5MB)
테스트 6 〉	통과 (13.71ms, 53.3MB)
테스트 7 〉	통과 (14.97ms, 54.3MB)
테스트 8 〉	통과 (20.16ms, 52.9MB)
테스트 9 〉	통과 (17.80ms, 53.6MB)
테스트 10 〉	통과 (15.51ms, 53.7MB)
테스트 11 〉	통과 (17.50ms, 54.4MB)
테스트 12 〉	통과 (19.32ms, 54MB)
테스트 13 〉	통과 (18.91ms, 53.3MB)
테스트 14 〉	통과 (17.97ms, 53.4MB)
테스트 15 〉	통과 (21.63ms, 53.9MB)
테스트 16 〉	통과 (18.13ms, 53.9MB)
테스트 17 〉	통과 (24.51ms, 53.9MB)
테스트 18 〉	통과 (25.45ms, 55MB)
테스트 19 〉	통과 (25.23ms, 54.5MB)
테스트 20 〉	통과 (28.43ms, 54.3MB)
테스트 21 〉	통과 (24.87ms, 54.4MB)
테스트 22 〉	통과 (31.32ms, 54MB)
테스트 23 〉	통과 (22.79ms, 54.1MB)
테스트 24 〉	통과 (13.15ms, 53.1MB)
테스트 25 〉	통과 (13.23ms, 54.6MB)
테스트 26 〉	통과 (13.69ms, 52.6MB)
테스트 27 〉	통과 (14.99ms, 54.1MB)
테스트 28 〉	통과 (13.42ms, 53.8MB)
테스트 29 〉	통과 (19.89ms, 53.4MB)
테스트 30 〉	통과 (13.53ms, 53.9MB)
효율성  테스트
테스트 1 〉	실패 (시간 초과)
테스트 2 〉	실패 (시간 초과)
테스트 3 〉	실패 (시간 초과)
테스트 4 〉	실패 (시간 초과)
테스트 5 〉	실패 (시간 초과)
테스트 6 〉	실패 (시간 초과)
테스트 7 〉	실패 (시간 초과)
테스트 8 〉	실패 (시간 초과)
테스트 9 〉	실패 (시간 초과)
테스트 10 〉	실패 (시간 초과)
채점 결과
정확성: 30.0
효율성: 0.0
합계: 30.0 / 100.0
채점 결과
정확성: 30.0
효율성: 0.0
합계: 30.0 / 100.0
*/
import java.util.*;
class Solution {
    static class Node{
        int data;
        int del_pos;
        Node(int data){
            this.data = data;
        }
        public String toString(){
            return "Data: "+this.data;
        }
    }
    static LinkedList<Node> list;
    static Stack<Node> stack;
    static char[] ans;
    static int pos;
    static ArrayList<
    public String solution(int n, int k, String[] cmd) {
        String answer = "";
        pos = k;
        ans = new char[n];
        Arrays.fill(ans,'O');
        list = new LinkedList<>();
        stack = new Stack<>();
        for(int i = 0; i < n; i++){
            list.add(new Node(i));
        }

        for(int i = 0; i < cmd.length; i++){
            // System.out.println(cmd[i]);
            // System.out.println(i+"번째 실행 전 "+Arrays.toString(ans)+"   위치 "+pos+"   표: "+list.toString());
            execCommand(cmd[i]);
            // System.out.println(i+"번째 실행 후 "+Arrays.toString(ans)+"   위치 "+pos+"   표: "+list.toString());
        }
        answer = result();
        return answer;
    }
    public String result(){
        String answer = "";
        for(char c: ans){
            answer+=c;
        }
        return answer;
    }
    public void execCommand(String cmd){
        if(cmd.length()>1){
            String[] splitCmd = cmd.split(" ");
            switch(splitCmd[0]){
                case "U":
                    pos -= Integer.parseInt(splitCmd[1]);
                    if(pos < 0)
                        pos = 0;
                    break;
                case "D":
                    pos += Integer.parseInt(splitCmd[1]);
                    if(pos >= list.size())
                        pos = list.size()-1;
                    break;
            }
        }
        else{
            switch(cmd){
                case "C":
                    Node n = list.get(pos);
                    ans[n.data] = 'X';
                    n.del_pos = pos;
                    stack.push(n);
                    list.remove(pos);
                    if(pos >= list.size()){
                        pos = list.size()-1;
                    }
                    break;
                case "Z":
                    if(!stack.isEmpty()){
                        Node node = stack.pop();
                        ans[node.data] = 'O';
                        if(list.get(pos).data > node.data){
                            pos++;
                        }
                        list.add(node.del_pos, node);
                    }
                    break;
            }
        }
        return;
    }
}
/*
정확성  테스트
테스트 1 〉	통과 (0.34ms, 52.9MB)
테스트 2 〉	통과 (0.32ms, 52.7MB)
테스트 3 〉	통과 (0.30ms, 51.8MB)
테스트 4 〉	통과 (0.29ms, 52.7MB)
테스트 5 〉	통과 (0.53ms, 52.4MB)
테스트 6 〉	통과 (0.61ms, 52.2MB)
테스트 7 〉	통과 (0.52ms, 52.7MB)
테스트 8 〉	통과 (0.56ms, 52.8MB)
테스트 9 〉	통과 (0.55ms, 53.1MB)
테스트 10 〉	통과 (0.51ms, 52.8MB)
테스트 11 〉	통과 (3.92ms, 52.5MB)
테스트 12 〉	통과 (4.51ms, 53.3MB)
테스트 13 〉	통과 (1.90ms, 52.7MB)
테스트 14 〉	통과 (1.85ms, 53.1MB)
테스트 15 〉	통과 (1.72ms, 52.8MB)
테스트 16 〉	통과 (2.07ms, 53.8MB)
테스트 17 〉	통과 (4.01ms, 53MB)
테스트 18 〉	통과 (3.95ms, 53.5MB)
테스트 19 〉	통과 (4.34ms, 52.9MB)
테스트 20 〉	통과 (2.75ms, 53.7MB)
테스트 21 〉	통과 (2.42ms, 58.5MB)
테스트 22 〉	통과 (2.55ms, 53.7MB)
테스트 23 〉	통과 (0.25ms, 52.1MB)
테스트 24 〉	통과 (0.26ms, 52.7MB)
테스트 25 〉	통과 (0.26ms, 52.4MB)
테스트 26 〉	통과 (0.31ms, 52.8MB)
테스트 27 〉	통과 (0.30ms, 52.9MB)
테스트 28 〉	통과 (0.27ms, 53.1MB)
테스트 29 〉	통과 (0.36ms, 52.3MB)
테스트 30 〉	통과 (0.33ms, 52.5MB)
효율성  테스트
테스트 1 〉	통과 (442.20ms, 101MB)
테스트 2 〉	통과 (318.58ms, 102MB)
테스트 3 〉	통과 (169.08ms, 101MB)
테스트 4 〉	통과 (199.37ms, 109MB)
테스트 5 〉	통과 (163.81ms, 108MB)
테스트 6 〉	통과 (879.03ms, 107MB)
테스트 7 〉	통과 (208.99ms, 94.7MB)
테스트 8 〉	통과 (352.66ms, 96.5MB)
테스트 9 〉	통과 (1118.63ms, 111MB)
테스트 10 〉	통과 (1109.41ms, 108MB)
채점 결과
정확성: 30.0
효율성: 70.0
합계: 100.0 / 100.0
*/
import java.util.*;
class Solution {
    public String solution(int n, int k, String[] cmd) {
        String answer = "";
        Stack<Integer> stack = new Stack<>();
        int size = n;
        for(int i = 0; i < cmd.length; i++){
            if(cmd[i].length()>1){
                String[] split = cmd[i].split(" ");
                if(split[0].equals("U")){
                    k -= Integer.parseInt(split[1]);
                    if(k < 0){
                        k = 0;
                    }
                }
                else{
                    k += Integer.parseInt(split[1]);
                    if(k >= size){
                        k = size-1;
                    }
                }
            }
            else{
                if(cmd[i].equals("C")){
                    stack.push(k);
                    size--;
                    if(k == size) k -= 1;
                }
                else {
                    int r = stack.pop();
                    if(k >= r) k += 1;
                    size += 1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i++)
            sb.append("O");
        while(!stack.isEmpty()){
            sb.insert(stack.pop().intValue(),'X');
        }
        answer = sb.toString();
        return answer;
    }
}
