# Istio Observable 

This directory contains the configuration files for configuring the project Observable with Istio version 1.1x.

## Commands

- Be sure that the project is added to the ServiceMeshMemberRoll

- Create the deployments with the istio-proxy 

```
oc apply -f <(istioctl kube-inject -f hellogw.deployment.yaml)
oc apply -f <(istioctl kube-inject -f hellosrv.deployment.yaml)
oc apply -f <(istioctl kube-inject -f hellosrv-11.deployment.yaml)
```

- Configure the gateway and endpoints for the ingressgateway

`oc apply -f gateway.yaml`

- Add the destination rules for the pods

`oc apply -f destinationrule.yaml`

- Add the default destination rule

`oc apply -f virtual-services-latest.yaml`

At this point you will be able to play with the diferent features that Istio 
offers for networking. See the files with the prefix _virtual-services-*yaml_ 
for more information.

## Resources 

- Istio 1.1.x Docs \
  https://archive.istio.io/v1.1/docs/concepts/what-is-istio/

