# rest-reactive-services

## How to Run application

### Start Client 
```shell
./gradlew :client:bootrun
```

### Start Server

```shell
./gradlew :server:bootrun
```

### Run Tst
```shell
curl http://localhost:8080/user?id=1,2,3

[{"userId":"1","firstName":"Larue","lastName":"Crona","email":"rafael.dicki@gmail.com"},{"userId":"2","firstName":"Jake","lastName":"Collier","email":"cleotilde.bernier@gmail.com"},{"userId":"3","firstName":"Renea","lastName":"Wisozk","email":"ardell.conn@hotmail.com"}]
```
