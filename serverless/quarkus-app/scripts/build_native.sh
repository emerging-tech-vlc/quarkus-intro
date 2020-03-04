mvn package -Dnative -Dquarkus.native.container-build=true
docker build -t quay.io/famargon/quarkus-app-reverse-words-native -f src/main/docker/Dockerfile.native .
docker push quay.io/famargon/quarkus-app-reverse-words-native