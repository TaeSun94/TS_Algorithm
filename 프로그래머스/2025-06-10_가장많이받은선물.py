def solution(friends, gifts):
    answer = 0
    giftMap = dict()
    giftPoint = dict()
    nextGifts = dict()
    
    for friend in friends:
        giftMap[friend] = dict()
        giftPoint[friend] = 0
        nextGifts[friend] = 0
        for member in friends:
            if member != friend:
                giftMap[friend][member] = 0
    
    for gift in gifts:
        giftSplit = gift.split(" ")
        receiveGift = giftMap[giftSplit[0]]
        receiveGift[giftSplit[1]] += 1
    
    for friend in friends:
        for giver in giftMap[friend]:
            giftPoint[friend] += giftMap[friend][giver]
            giftPoint[giver] -= giftMap[friend][giver]
    
    for friend in friends:
        for giver in giftMap[friend]:
            if giftMap[friend][giver] > giftMap[giver][friend]:
                nextGifts[friend] += 1
            elif giftMap[friend][giver] == giftMap[giver][friend]:
                if giftPoint[friend] > giftPoint[giver]:
                    nextGifts[friend] += 1
    
    for counts in nextGifts.values():
        if answer < counts:
            answer = counts
    
    return answer
