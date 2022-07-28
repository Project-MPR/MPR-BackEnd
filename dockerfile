FROM ubuntu:22.04

RUN mkdir /tmp/certs
WORKDIR /tmp/certs

# 사전 upgrade
RUN apt -y update && apt -y upgrade &&\
    apt -y install  wget &&\
    apt-get -y install openjdk-11-jdk &&\
    apt-get -y install curl &&\
    wget https://s3.amazonaws.com/rds-downloads/rds-combined-ca-bundle.pem

COPY script/makejks.sh makejks.sh
RUN chmod 777 makejks.sh && ./makejks.sh

WORKDIR /tmp
COPY build/libs/*.jar app.jar

EXPOSE 8080
ENTRYPOINT java -jar app.jar