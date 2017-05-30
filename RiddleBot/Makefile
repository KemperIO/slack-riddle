all:
	mvn clean && mvn package && \
	aws lambda update-function-code --function-name getAnswer --zip-file fileb://target/RiddleBot-0.0.1-SNAPSHOT.jar --profile tj && \
	./hitApi.sh

getRiddle:
	mvn clean && mvn package && \
	aws lambda update-function-code --function-name getRiddle --zip-file fileb://target/RiddleBot-0.0.1-SNAPSHOT.jar --profile tj && \
	./hitApi.sh

