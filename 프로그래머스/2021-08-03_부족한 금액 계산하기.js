/*
정확성  테스트
테스트 1 〉	통과 (0.05ms, 30.7MB)
테스트 2 〉	통과 (0.06ms, 30.3MB)
테스트 3 〉	통과 (0.05ms, 30.1MB)
테스트 4 〉	통과 (0.05ms, 30.3MB)
테스트 5 〉	통과 (0.05ms, 30.2MB)
테스트 6 〉	통과 (0.05ms, 30.1MB)
테스트 7 〉	통과 (0.05ms, 30.2MB)
테스트 8 〉	통과 (0.03ms, 30.2MB)
테스트 9 〉	통과 (0.05ms, 30.2MB)
테스트 10 〉	통과 (0.05ms, 30.1MB)
테스트 11 〉	통과 (0.06ms, 30.1MB)
테스트 12 〉	통과 (0.05ms, 30.1MB)
테스트 13 〉	통과 (0.05ms, 30.4MB)
테스트 14 〉	통과 (0.05ms, 30.2MB)
테스트 15 〉	통과 (0.06ms, 30.3MB)
테스트 16 〉	통과 (0.04ms, 30.1MB)
테스트 17 〉	통과 (0.05ms, 30.5MB)
테스트 18 〉	통과 (0.05ms, 30MB)
테스트 19 〉	통과 (0.05ms, 30.3MB)
테스트 20 〉	통과 (0.05ms, 30.2MB)
테스트 21 〉	통과 (0.05ms, 30.1MB)
테스트 22 〉	통과 (0.06ms, 30.1MB)
테스트 23 〉	통과 (0.04ms, 30.2MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
*/
function solution(price, money, count) {
    var answer = -1;
    var sum = price*count*(count+1)/2;
    return sum-money >= 0 ? sum-money:0;
}
