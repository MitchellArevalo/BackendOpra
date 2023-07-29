FROM openjdk:11
MAINTAINER JDiaz
COPY microservicio/build/libs/opra-0.0.1-SNAPSHOT.jar opradesign.jar
ENTRYPOINT ["java","-jar","/opradesign.jar"]
