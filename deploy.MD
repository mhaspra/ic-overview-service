#Build the jar
mvn clean package

#Build the docker images
docker build -t ic-overview-service:1.0 .

#Deploy
kubectl apply -f kubernetes.yaml

#Delete
kubectl delete -f kubernetes.yaml