##Level  8
#! /usr/bin/env python

# question url: http://www.pythonchallenge.com/pc/def/integrity.html 

#导入bz编码库进行解码
import bz2

un="BZh91AY&SYA\xaf\x82\r\x00\x00\x01\x01\x80\x02\xc0\x02\x00 \x00!\x9ah3M\x07<]\xc9\x14\xe1BA\x06\xbe\x084"
pw="BZh91AY&SY\x94$|\x0e\x00\x00\x00\x81\x00\x03$ \x00!\x9ah3M\x13<]\xc9\x14\xe1BBP\x91\xf08"

print "User name:",bz2.decompress(un)
print "Password:",bz2.decompress(pw)

# The running result
# huge
# file
# answer rul:http://www.pythonchallenge.com/pcc/return/good.html:huge:file 
