FROM java:8
VOLUME /tmp
EXPOSE 8080:8080
ADD investmentservices-1.0.jar investments.jar
RUN bash -c 'touch /investments.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=container","-jar","/investments.jar"]
