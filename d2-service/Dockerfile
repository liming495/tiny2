FROM java:8
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
VOLUME /tmp
VOLUME /data
ADD ./target/d2-service.jar /d2-service.jar
RUN bash -c 'touch /d2-service.jar'
EXPOSE 10011
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/d2-service.jar"]