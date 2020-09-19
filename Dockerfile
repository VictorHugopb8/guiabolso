FROM openjdk:8u121-jre-alpine

COPY . /
RUN apk update

ENV JAVA_HOME=/usr/lib/jvm/java-1.8-openjdk/jre/bin/java

WORKDIR /src/main/
CMD javac TransactionMockApplication.java
CMD java TransactionMockApplication
