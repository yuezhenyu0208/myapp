#!/bin/bash
#echo "Input process name first"
#read input1

cd ../
#生成jar包
./gradlew clean build
cd shell
#传输到服务器
scp -l 8192 ../build/libs/myspp-0.0.1-SNAPSHOT.jar root@202.182.116.51:/opt/javaweb/jar/
#远程执行脚本，启动服务器
ssh root@202.182.116.51 "/opt/javaweb/jar/deployapi.sh"
