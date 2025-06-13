def solution(wallpaper):
    answer = []
    minR = -1
    minC = -1
    maxR = -1
    maxC = -1
    flag = 0
    
    for i in range(len(wallpaper)):
        for j in range(len(wallpaper[i])):
            if wallpaper[i][j] == '#':
                if flag == 0:
                    minR = i
                    minC = j
                    maxR = i
                    maxC = j
                    flag = 1
                else:
                    minR = min(i, minR)
                    minC = min(j, minC)
                    maxR = max(i, maxR)
                    maxC = max(j, maxC)
                    
    answer.append(minR)
    answer.append(minC)
    answer.append(maxR + 1)
    answer.append(maxC + 1)
    return answer
