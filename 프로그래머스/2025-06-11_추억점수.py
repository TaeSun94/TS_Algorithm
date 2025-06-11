def solution(name, yearning, photo):
    answer = []
    scoreMap = dict()
    for i in range(len(name)):
        scoreMap[name[i]] = yearning[i]
    
    for i in range(len(photo)):
        score = 0
        for j in range(len(photo[i])):
            if photo[i][j] in scoreMap:
                score += scoreMap[photo[i][j]]
        answer.append(score)
    
    return answer
