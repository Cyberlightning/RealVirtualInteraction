FROM ubuntu:14.04.3
MAINTAINER Juha Hyvärinen <juha.hyvarinen@cyberlightning.com>

# LABEL Description="Fiware Real Virtual Interaction"

RUN apt-get update && apt-get -y install \
    openjdk-7-jre-headless \
    wget

ENV JAVA_HOME /usr/lib/jvm/java-7-openjdk-amd64

# Download server and install it
RUN cd /usr/bin/ && \
    mkdir RvI_server && \
    cd RvI_server/ && \
    wget --no-check-certificate https://forge.fiware.org/frs/download.php/1690/RealVirtualInteraction_backend-4.4.3.jar

EXPOSE 61616/udp
EXPOSE 61617/udp
EXPOSE 44445/tcp
EXPOSE 44446/tcp

CMD ["java", "-jar", "/usr/bin/RvI_server/RealVirtualInteraction_backend-4.4.3.jar" ]
