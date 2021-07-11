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
