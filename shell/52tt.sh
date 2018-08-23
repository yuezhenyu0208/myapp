ps -ef | grep myspp-0.0.1-SNAPSHOT.jar | grep -v grep | awk '{print $2}' | xargs kill -9
rm -rf /opt/javaweb/jar/myspp/*
mv /opt/javaweb/jar/myspp-0.0.1-SNAPSHOT.jar /opt/javaweb/jar/myspp/
nohup /opt/jdk1.8.0_171/bin/java -jar /opt/javaweb/jar/myspp/myspp-0.0.1-SNAPSHOT.jar >>/opt/javaweb/jar/myspp/nohup.out &