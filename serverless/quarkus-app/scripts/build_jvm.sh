mvn package
docker build -t quay.io/famargon/quarkus-app-reverse-words -f src/main/docker/Dockerfile.jvm .
docker push quay.io/famargon/quarkus-app-reverse-words