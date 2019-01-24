#!/bin/bash
PATH=/root/apache-maven-3.5.4/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/usr/local/zookeeper/bin:/root/bin
export PATH
git pull
mvn clean
mvn install
cd springcloud-server/
nohup java -jar springcloud-server-1.0-SNAPSHOT.jar &
cd ..
cd springcloud-uaa/
nohub java -jar springcloud-uaa-1.0-SNAPSHOT.jar &
cd ..
cd springcloud-userservice/
nohub java -jar springcloud-userservice-1.0-SNAPSHOT.jar &