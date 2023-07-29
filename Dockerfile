FROM openjdk:11
MAINTAINER JDiaz
COPY microservicio/build/libs/opra-1.jar opradesign.jar
ENTRYPOINT ["java","-jar","/opradesign.jar"]
