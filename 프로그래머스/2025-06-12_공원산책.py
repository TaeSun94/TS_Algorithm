def solution(park, routes):
    answer = []
    r = -1
    c = -1
    
    for i in range(len(park)):
        for j in range(len(park[i])):
            if park[i][j] == 'S':
                r = i
                c = j
    def east(row, col):
        nr = row
        nc = col + 1
        if nc >= len(park[0]) or park[nr][nc] == 'X':
            return 0
        
        return 1
    
    def west(row, col):
        nr = row
        nc = col - 1
        if nc < 0 or park[nr][nc] == 'X':
            return 0
        
        return 1
    
    def north(row, col):
        nr = row - 1
        nc = col
        if nr < 0 or park[nr][nc] == 'X':
            return 0
        
        return 1
    
    def south(row, col):
        nr = row + 1
        nc = col
        if nr >= len(park) or park[nr][nc] == 'X':
            return 0
        
        return 1

    for route in routes:
        routeSplit = route.split(" ")
        flag = 1
        if routeSplit[0] == 'E':
            for i in range(int(routeSplit[1])):
                if flag == 0:
                    break
                flag = east(r, c + i)
            if flag:
                c += int(routeSplit[1])
        elif routeSplit[0] == 'W':
            for i in range(int(routeSplit[1])):
                if flag == 0:
                    break
                flag = west(r, c - i)
            if flag:
                c -= int(routeSplit[1])
        elif routeSplit[0] == 'N':
            for i in range(int(routeSplit[1])):
                if flag == 0:
                    break
                flag = north(r - i, c)
            if flag:
                r -= int(routeSplit[1])
        else:
            for i in range(int(routeSplit[1])):
                if flag == 0:
                    break
                flag = south(r + i, c)
            if flag:
                r += int(routeSplit[1])

    answer.append(r)
    answer.append(c)
    return answer
