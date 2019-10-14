#!/usr/bin/env bash
#testFile="abx.txt"
#while read line
#do
#$line | awk 'printf $1'
#done < ${testFile}

ps -ef | grep 'a' | awk '{print $1}'