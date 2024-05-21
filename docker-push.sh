docker build -t adoption-service:$1 .
docker tag adoption-service:latest piffek1/adoption-service:$1
docker push piffek1/adoption-service:$1
