FROM java:8
VOLUME /tmp
ADD ./target/d2-service.jar /d2-service.jar
RUN bash -c 'touch /d2-service.jar'
EXPOSE 10011
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/d2-service.jar"]