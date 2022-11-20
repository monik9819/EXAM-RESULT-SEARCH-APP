#Project
this application is use to process student exam result for different use cases.

## Import project
Import the project on either eclipse or intellij as a maven import project

#Build
### Maven
This project is maven project which will be build using maven command.
```BASH
$ mvn clean install
```

# Run
```BASH
$ docker-compose -f docker-compose-rabbitmq-mongo.yml up -d
$ ResultProcessor>mvn spring-boot:run
$ StudentResult>mvn spring-boot:run
```

#TEST
```BASH
$ curl --request POST -sL \
     --url 'localhost:8082/storeresult'\
     --user 'schooladmin1:password124'\
     --header 'Content-Type: application/json'\
     --data-raw '{
"name":"monik", "role":"131121", "schoolName":"CV", "scienceMarks":90, "mathMarks":95, "socialScienceMarks":98,"artMarks":91, "sportMarks":100
}'

$ curl --request PUT -sL \
     --url 'localhost:8082/updateresult/monik'\
     --user 'schooladmin1:password124'\
     --header 'Content-Type: application/json'\
     --data-raw '{
"scienceMarks":100, "mathMarks":100, "socialScienceMarks":100,"artMarks":100, "sportMarks":100
}'


$ curl --request DELETE -sL \
     --url 'localhost:8082/deleteresult?name=kiran'\
     --user 'schooladmin1:password124'

$ curl --request GET -sL \
     --url 'localhost:8081/getresult?name=kiran'\
     --header 'Accept: application/json' \
     --user 'student1:password123'

```

#Show data on browser
http://localhost:15672/

user-name:guest<br>
password:guest

#StopContainer
```BASH   
docker-compose -f docker-compose-rabbitmq-mongo.yml down
```

#Show data
```BASH
docker exec -it examresultsearchapp_mongo_1 bash
mongo
show dbs
use test_db
show examResult
db.examResult.find()
```