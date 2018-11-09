##Level  10

#! /usr/bin/env python 

# question url:http://www.pythonchallenge.com/pc/return/bull.html

# look and say sequence Reference url:http://en.wikipedia.org/wiki/Look-and-say_sequence

#没有发现规律，直接Google答案，囧rz

# a = [1, 11, 21, 1211, 111221, ...
# 规律
# 1 1个1 →  11
# 11 2个1 → 21
# 21 1个2 1个1 → 1211
# 1211 1个1 1个2 2个1 → 111221
# ...

import re
 
def gen_next(s):
    # via finditer() rather than findall(),
    # we can access capture-goup cleanly
    return "".join([str(len(match.group(0))) + match.group(1) \
        for match in re.finditer(r"(\d)\1*", s)])
           
s = "1"
for dummy in range(30):
    s = gen_next(s)
    
print len(s)


# The running result：5808
