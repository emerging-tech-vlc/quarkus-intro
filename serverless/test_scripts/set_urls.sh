export QUARKUS_NATIVE=$(oc get ksvc quarkus-app-native -o json | jq -r .status.url)
export QUARKUS_JVM=$(oc get ksvc quarkus-app -o json | jq -r .status.url)
export SPRING=$(oc get ksvc spring-app -o json | jq -r .status.url)