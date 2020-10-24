
# How to Run

## 1 - Build the APP

```mvn clean compile install```


## 2 - Dockerize RabbitMQ

```docker pull rabbitmq:3-management```


## 3 - Build the APP docker image

```docker build -f Dockerfile -t application-example:1.0 .```


## 4 - Run the docker-compose.yml

```docker-compose up```


## 5 - Executing the application

```@see Postman Collection (SpringBootRabbitMQDockerCollection.postman_collection.json)```


## 6 - Opening the RabbitMQ
```http://localhost:15672/```

```user:guest | password:guest```


# Docker
The configuration for Docker can be seen in:

```Dockerfile```

```docker-compose.yml```


# RabbitMQ
There is an observation regarding the RabbitMQ + Docker. When combining both, the property
```spring.rabbitmq.host``` must be changed from ```localhost``` to ```<ip-address>```

The configuration for RabbitMQ can be seen in:

```src > main > resources > application.properties```

```docker-compose.yml```
