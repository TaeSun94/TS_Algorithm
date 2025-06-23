def solution(diffs, times, limit):
    low = 1
    high = max(diffs)
    
    while high >= low:
        mid = (high + low) // 2
        res = check(mid, diffs, times, limit)
        if res:
            high = mid - 1
        else:
            low = mid + 1

    return low


# Check 함수를 작성하여 Algorithm에 부합하는지 확인하는 로직을 작성
def check(level, diffs, times, limit):
    counts = 0
    for index in range(len(diffs)):
        if level < diffs[index]:
            counts += (diffs[index] - level) * (times[index] + times[index-1])
        
        counts += times[index]
        if limit < counts:
            return False
    return True
