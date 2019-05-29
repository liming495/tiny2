FROM java:8
VOLUME /tmp
ADD ./target/d3-service.jar /d3-service.jar
RUN bash -c 'touch /d3-service.jar'
EXPOSE 10012
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/d3-service.jar"]