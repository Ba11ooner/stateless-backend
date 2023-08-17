FROM  circleci/jdk8:0.1.1
COPY target/stateless-backend-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
CMD ["java","-jar","stateless-backend-0.0.1-SNAPSHOT.jar"]