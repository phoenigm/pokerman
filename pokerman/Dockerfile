FROM adoptopenjdk/openjdk11:alpine-jre

COPY ./build/libs/pokerman.jar pokerman.jar
CMD ["java", "-Xmx128m", "-jar", "pokerman.jar"]
