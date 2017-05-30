.PHONY: riddle
riddle: updateRiddle curlRiddle	

.PHONY: answer
answer: updateAnswer curlAnswer

.PHONY: updateRiddle
updateRiddle: build
	aws lambda update-function-code --function-name getRiddle --zip-file fileb://target/RiddleBot-0.0.1-SNAPSHOT.jar --profile tj 

.PHONY: updateAnswer
updateAnswer: build
	aws lambda update-function-code --function-name getAnswer --zip-file fileb://target/RiddleBot-0.0.1-SNAPSHOT.jar --profile tj 

.PHONY: build
build:
	mvn clean package

.PHONY: curlRiddle
curlRiddle: ;

.PHONY: curlAnswer
curlAnswer:
	./scripts/getAnswer.sh

.PHONY: db
db:
	aws dynamodb batch-write-item --request-items file://db/data.json --profile tj
