##Level  3
import re

#find directory of data1
file=open('c:\\Python27\\data1.txt')
content=file.read()

data= "".join(re.findall("[^A-Z]+[A-Z]{3}([a-z])[A-Z]{3}[^A-Z]+",content))
temp=''
print data
