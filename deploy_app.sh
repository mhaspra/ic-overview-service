./mvnw clean package
docker build -t ic-overview-service:1.0 .
kubectl delete -f kubernetes_app.yaml -n insurance-kafka
kubectl apply -f kubernetes_app.yaml -n insurance-kafka

