.PHONY: initial
initial: updateInitial testInitial

.PHONY: async
async: updateAsync testAsync

# update
.PHONY: updateInitial
updateInitial: build
	aws lambda update-function-code --function-name RiddleInitialHandler --zip-file fileb://target/RiddleBot-0.0.1-SNAPSHOT.jar --profile tj

.PHONY: updateAsync
updateAsync: build
	aws lambda update-function-code --function-name RiddleAsyncHandler --zip-file fileb://target/RiddleBot-0.0.1-SNAPSHOT.jar --profile tj

# build
.PHONY: build
build:
	mvn clean package

# test
.PHONY: testInitial
testInitial: ;

.PHONY: testAsync
testAsync:
	aws sns publish --topic-arn arn:aws:sns:us-east-1:660085092387:riddle --message "test" --profile tj

# update database
.PHONY: db
db:
	aws dynamodb batch-write-item --request-items file://db/data.json --profile tj



# todo: delete
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

.PHONY: curlRiddle
curlRiddle: ;

.PHONY: curlAnswer
curlAnswer:
	./scripts/getAnswer.sh
