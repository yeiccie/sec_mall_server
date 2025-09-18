#指定jdk版本
FROM openjdk:8
#作者
MAINTAINER CHEN BEI
#将jar包添加到容器中并更名为sims.jar
ADD target/server_code-0.0.1-SNAPSHOT.jar server.jar
# 容器暴露的端口
EXPOSE 8080
# 容器启动之后执行的命令
ENTRYPOINT ["java","-jar","server.jar"]

# 生成容器并启动
# sudo docker run -d --name server  -p 8080:8080 server --link mysql:mysql
