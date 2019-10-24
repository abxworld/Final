#!/usr/bin/env bash

source ~/.bash_profile

mvn clean package  -Dmaven.test.skip=true -T 8C  -Dmaven.compile.fork=true -pl "springboot" -am

remote_host=`grep 'remote_host' remote.secret | awk -F '=' '{print $2}' | head -1`
remote_port=`grep 'remote_port' remote.secret | awk -F '=' '{print $2}' | head -1`
remote_path=`grep 'remote_path' remote.secret | awk -F '=' '{print $2}' | head -1`
remote_user_name=`grep "remote_user_name" remote.secret | awk -F '=' '{print $2}' | head -1`
remote_pass_word=`grep 'remote_pass_word' remote.secret | awk -F '=' '{print $2}' | head -1`

local_clazz_path=/Users/apple/IdeaProjects/Final/springboot/target/springboot-0.0.1-SNAPSHOT.war

echo "local_clazz_path: $local_clazz_path"

if [ ! -f "$local_clazz_path" ]; then
    echo "maven failed"
    exit 1
fi
echo "rsync start"

sshpass -p$remote_pass_word rsync -e "ssh -p $remote_port" $local_clazz_path $remote_user_name@$remote_host:/home/work/

echo "rsync end"
