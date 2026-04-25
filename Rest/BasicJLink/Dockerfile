FROM alpine:3.14
LABEL authors="GedMarc"

COPY target/maven-jlink/default /opt

ENTRYPOINT ["/opt/bin/example"]