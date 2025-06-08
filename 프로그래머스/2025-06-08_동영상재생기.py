def solution(video_len, pos, op_start, op_end, commands):
    for command in commands:
        pos = skipOpening(pos, op_start, op_end)
        if command == 'next':
            pos = nextCommand(pos, video_len)
        elif command == 'prev':
            pos = prevCommand(pos)
    pos = skipOpening(pos, op_start, op_end)
    return pos

def intToTime(t):
    tSplit = t.split(':')
    return int(tSplit[0])*60 + int(tSplit[1])

def skipOpening(pos, op_start, op_end):
    # opening구간일 경우 op_end 리턴
    # 아닐 경우 pos그대로 리턴
    posTime = intToTime(pos)
    opStartTime = intToTime(op_start)
    opEndTime = intToTime(op_end)
    
    if opStartTime <= posTime < opEndTime:
        return op_end
    else:
        return pos

def nextCommand(pos, video_len):
    posSplit = pos.split(':')
    videoSplit = video_len.split(':')
    hour = int(posSplit[0])
    minute = int(posSplit[1]) + 10
    
    if minute >= 60:
        hour += 1
        minute -= 60
    
    if hour >= int(videoSplit[0]) and minute >= int(videoSplit[1]):
        return video_len
    else:
        return f"{hour:02d}:{minute:02d}"

def prevCommand(pos):
    posSplit = pos.split(':')
    hour = int(posSplit[0])
    minute = int(posSplit[1]) - 10
    
    if minute < 0:
        hour -= 1
        minute += 60
    
    if hour < 0:
        return "00:00"
    else:
        return f"{hour:02d}:{minute:02d}"
