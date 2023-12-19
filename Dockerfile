FROM openjdk:20
LABEL com.oconnellj2.image.authors="jdoconnell@pm.me"
LABEL version="1.0.0"
LABEL description="Spring Boot API providing RESTful services for employee's"

ENV APP_HOME=/usr/src/java/com/oconnellj2/employeeAPI
WORKDIR $APP_HOME
COPY ./build/libs/employeeAPI-1.0.0.jar ./employeeAPI-1.0.0.jar
EXPOSE 8080
CMD ["java","-jar","employeeAPI-1.0.0.jar"]