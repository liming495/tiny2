FROM java:8
VOLUME /tmp
ADD ./target/d1-service.jar /d1-service.jar
RUN bash -c 'touch /d1-service.jar'
EXPOSE 10010
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/d1-service.jar"]