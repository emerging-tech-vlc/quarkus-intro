# Quarkus observable


# Requisites 

- Start jaeger to keep track of the traces.
podman run -e COLLECTOR_ZIPKIN_HTTP_PORT=9411 -p 5775:5775/udp -p 6831:6831/udp -p 6832:6832/udp -p 5778:5778 -p 16686:16686 -p 14268:14268 -p 9411:9411 jaegertracing/all-in-one:latest 


# Container version 

- Hello Gateway
cd hellogw
podman build . -f ./src/main/docker/Dockerfile.jvm -t quarkus-observable-demo:latest

or Java 11 version 
podman build . -f ./src/main/docker/Dockerfile.java11 -t quarkus-observable-demo:11

run locally:
podman run -it --rm -p 8080:8080 quarkus-observable-demo

Java 11
podman run -it --rm -p 8080:8080 quarkus-observable-demo:11

curl http://localhost:8080/hello
hello from fallback.

- Hello Server
cd hellosrv
podman build . -f ./src/main/docker/Dockerfile.jvm -t quarkus-observable-server:latest

Java 11
podman build . -f ./src/main/docker/Dockerfile.java11 -t quarkus-observable-server:11

run locally:
podman run -it --rm -p 8080:8080 quarkus-observable-server

Java 11
podman run -it --rm -p 8080:8080 quarkus-observable-server:11

curl http://localhost:8080/hello
hello from service