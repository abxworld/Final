#!/usr/bin/env bash
mvn clean package  -Dmaven.test.skip=true -T 8C  -Dmaven.compile.fork=true -pl "springboot" -am



