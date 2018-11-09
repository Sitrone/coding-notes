#!/bin/bash

# word frequency
cat word.txt | xargs | sed 's/ /\n/g' | sort | uniq -c | sort -k1,1nr | awk '{print $2,$1}


tr -c -s '[:alpha:]' '[\n*]' < {fileName} | \
sort | \
uniq -c | \
sort -n -r -k 1,1 | \
sed 20q

# find support regex research
find . -regex ".*\.tar"   -print | xargs ls -l
