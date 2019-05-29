FROM java:8
VOLUME /tmp
ADD ./target/b-service.jar /b-service.jar
RUN bash -c 'touch /b-service.jar'
EXPOSE 8070
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/b-service.jar"]