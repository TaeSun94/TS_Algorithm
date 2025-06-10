def solution(wallet, bill):
    answer = 0
    
    while 1:
        if check(wallet, bill):
            break
        else:
            if bill[0] >= bill[1]:
                bill[0] //= 2
            else:
                bill[1] //= 2
        answer += 1
        
    return answer

def check(wallet, bill):
    if wallet[0] >= bill[0]:
        if wallet[1] >= bill[1]:
            return 1
    
    if wallet[1] >= bill[0]:
        if wallet[0] >= bill[1]:
            return 1
    
    return 0
