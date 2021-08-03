FROM adoptopenjdk/openjdk11:alpine-jre

COPY ./build/libs/poker-chpoker.jar poker-chpoker.jar
CMD ["java", "-Xmx128m", "-jar", "poker-chpoker.jar"]
