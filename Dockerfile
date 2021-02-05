#Download node docker image java
#Build app#

# RUN stage
#
FROM openjdk:11-jre-slim
COPY target/*.jar /app/training-service.jar
WORKDIR /app
CMD ["java","-jar","/app/training-service.jar"]
