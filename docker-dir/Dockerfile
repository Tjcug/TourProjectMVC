FROM tomcat:9.0
COPY TourProject.war /usr/local/tomcat/webapps
ENV JAVA_OPTS -Djava.security.egd=file:/dev/./urandom
USER root
EXPOSE 8080
CMD ["catalina.sh", "run"]
