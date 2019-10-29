FROM java:8
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
VOLUME /tmp
VOLUME /data
ADD ./target/service-e.jar /service-e.jar
RUN bash -c 'touch /service-e.jar'
EXPOSE 10100
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/service-e.jar"]