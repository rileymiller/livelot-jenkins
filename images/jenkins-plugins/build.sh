#!/bin/bash -el
# images/jenkins-plugins/build.sh

# Define our image name
image_name=livelot-jenkins/jenkins-plugins:latest

# Accept any args passed and add them to the command
docker image build ${@} -t $image_name $(dirname -- "$0")

# If we add PUSH=true to the command, it will push to the hub
if [ "$PUSH" = true ] ; then
  docker image push $image_name
fi
