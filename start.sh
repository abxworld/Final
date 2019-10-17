#!/usr/bin/env bash
#mvn clean package  -Dmaven.test.skip=true -T 8C  -Dmaven.compile.fork=true -pl "springboot" -am

remote_host=`grep 'remote_host' remote.secret | awk -F '=' '{print $2}' | head -1`
remote_port=`grep 'remote_port' remote.secret | awk -F '=' '{print $2}' | head -1`
remote_path=`grep 'remote_path' remote.secret | awk -F '=' '{print $2}' | head -1`
remote_user_name=`grep "remote_user_name" remote.secret | awk -F '=' '{print $2}' | head -1`
remote_pass_word=`grep 'remote_pass_word' remote.secret | awk -F '=' '{print $2}' | head -1`

local_clazz_path=/Users/apple/IdeaProjects/Final/springboot/target/springboot-0.0.1-SNAPSHOT.war

if [ ! -f "$local_clazz_path" ]; then
    exit 1
fi

sshpass  -p "$remote_pass_word" scp -P$remote_port $local_clazz_path $remote_user_name@$remote_host:$remote_path
