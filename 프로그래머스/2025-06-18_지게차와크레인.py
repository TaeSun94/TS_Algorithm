def solution(storage, requests):
    answer = 0
    # 문자열을 문자 리스트로 변환
    storage = [list(row) for row in storage]
    
    items = dict()
    for r in range(len(storage)):
        for c in range(len(storage[r])):
            if storage[r][c] not in items:
                items[storage[r][c]] = list()
            items[storage[r][c]].append((r, c))
    
    for request in requests:
        if len(request) == 1:
            storage = lift(request, items, storage)
        else:
            storage = crain(request, items, storage)
    
    for r in range(len(storage)):
        for c in range(len(storage[r])):
            if storage[r][c] != '-':
                answer += 1
    return answer


def check(storage, r, c):
    queue = [(r, c)]
    visited = set()
    visited.add((r, c))
    
    maxR = len(storage)
    maxC = len(storage[0])
    
    while queue:
        nowR, nowC = queue.pop(0)
        for dr, dc in ((-1, 0), (1, 0), (0, -1), (0, 1)):
            nextR = nowR + dr
            nextC = nowC + dc
            
            if nextR < 0 or nextC < 0 or nextR >= maxR or nextC >= maxC:
                return 1
            
            if (nextR, nextC) not in visited and storage[nextR][nextC] == '-':
                visited.add((nextR, nextC))
                queue.append((nextR, nextC))
    
    return 0


def crain(request, items, storage):
    target = request[0]
    if target in items:
        while items[target]:
            r, c = items[target].pop()
            storage[r][c] = '-'
    return storage


def lift(request, items, storage):
    target = request
    if target in items:
        newItemList = []
        removeItemList = []
        for r, c in items[target]:
            if check(storage, r, c) == 1:
                removeItemList.append((r,c))
                # storage[r][c] = '-'
            else:
                newItemList.append((r, c))
        items[target] = newItemList
        for r, c in removeItemList:
            storage[r][c] = '-'
    return storage
