answer = -1
visited = set()
def solution(info, n, m):
    steal(0,len(info), n, m, 0, 0, info)
    
    return answer

def steal(index, end, n, m, aCnt, bCnt, info):
    global visited
    
    if aCnt >= n or bCnt >= m:
        return
    if index > end:
        return
    
    if index == end:
        global answer
        if n > aCnt and m > bCnt:
            if answer == -1:
                answer = aCnt
            else:
                answer = min(answer, aCnt)
        return
    
    visited.add((index, aCnt, bCnt))
    
    if (index +1, aCnt, bCnt + info[index][1]) not in visited:
        steal(index+1, end, n, m, aCnt, bCnt +info[index][1], info)
    if (index +1, aCnt + info[index][0], bCnt) not in visited:
        steal(index+1, end, n, m, aCnt + info[index][0], bCnt, info)
