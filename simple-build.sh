#!/bin/bash
./gradlew build buildDocker
docker tag kachouh/ecs-sample:latest 002957041265.dkr.ecr.us-west-2.amazonaws.com/kachouh/ecs-sample:1.0
docker push 002957041265.dkr.ecr.us-west-2.amazonaws.com/kachouh/ecs-sample:1.0