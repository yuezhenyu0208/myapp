#!/bin/bash
#echo "Input process name first"
#read input1

cd ../
#生成jar包
./gradlew clean build
cd shell
#传输到服务器
scp ../build/libs/myspp-0.0.1-SNAPSHOT.jar root@52tt.xyz:/opt/javaweb/jar/
#远程执行脚本，启动服务器
ssh root@52tt.xyz "/opt/javaweb/jar/deployapi.sh"
