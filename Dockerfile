FROM ubuntu:18.04

RUN apt-get update \
    && apt-get -y install openjdk-8-jdk

RUN apt-get -y install curl \
    && apt-get -y install gnupg \
    && echo "deb https://dl.bintray.com/sbt/debian /" | tee -a /etc/apt/sources.list.d/sbt.list \
    && curl -sL "https://keyserver.ubuntu.com/pks/lookup?op=get&search=0x2EE0EA64E40A89B84B2DF73499E82A75642AC823" | apt-key add \
    && apt-get update \
    && apt-get -y install sbt

RUN mkdir scala
WORKDIR /scala

CMD ["/bin/bash"]
