#!/bin/bash
PATH=/root/apache-maven-3.5.4/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/usr/local/zookeeper/bin:/root/bin
export PATH
mvn clean
mvn install
#case "$1" in
start)
    echo "--------springcloud-server 开始启动--------------"
    nohup java -jar springcloud-server/target/springcloud-server-1.0-SNAPSHOT.jar >/dev/null 2>&1 &
    SERVER_pid=`lsof -i:8766|grep "LISTEN"|awk '{print $2}'`
    until [ -n "$SERVER_pid" ]
        do
          SERVER_pid=`lsof -i:8766|grep "LISTEN"|awk '{print $2}'`
        done
    echo "springcloud-server pid is $SERVER_pid"
    echo "--------springcloud-server 启动成功--------------"

    echo "--------springcloud-uaa 开始启动--------------"
    nohup java -jar springcloud-uaa/target/springcloud-uaa-1.0-SNAPSHOT.jar >/dev/null 2>&1 &
    UUA_pid=`lsof -i:8766|grep "LISTEN"|awk '{print $2}'`
    until [ -n "$UUA_pid" ]
        do
          UUA_pid=`lsof -i:8766|grep "LISTEN"|awk '{print $2}'`
        done
    echo "springcloud-uaa pid is $UUA_pid"
    echo "--------springcloud-uaa 启动成功--------------"

    echo "--------springcloud-userservice 开始启动--------------"
    nohup java -jar springcloud-userservice/target/springcloud-userservice-1.0-SNAPSHOT.jar >/dev/null 2>&1 &
    USERSERVICE_pid=`lsof -i:8766|grep "LISTEN"|awk '{print $2}'`
    until [ -n "$USERSERVICE_pid" ]
        do
          USERSERVICE_pid=`lsof -i:8766|grep "LISTEN"|awk '{print $2}'`
        done
    echo "springcloud-userservice pid is $USERSERVICE_pid"
    echo "--------springcloud-userservice 启动成功--------------"
stop)