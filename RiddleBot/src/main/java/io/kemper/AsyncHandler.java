package io.kemper;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SNSEvent;
import io.kemper.api.LambdaProxyRequest;
import io.kemper.api.MessageActionRequest;
import io.kemper.domain.Riddle;
import io.kemper.service.DynamoRiddleService;

import java.util.Map;

import static io.kemper.service.JSONService.unmarshall;
import static io.kemper.service.SlackService.postMessage;
import static io.kemper.service.SlackService.postRiddle;

public class AsyncHandler implements RequestHandler<SNSEvent, Void> {

    private static final String HELP_MESSAGE = "Type `/riddle` to get a random riddle.";

    @Override
    public Void handleRequest(SNSEvent request, Context context) {
        context.getLogger().log("Input: " + request);
        System.out.println("MESSAGE: " + request.getRecords().get(0).getSNS().getMessage());

        String requestMessage = request.getRecords().get(0).getSNS().getMessage();
        LambdaProxyRequest lambdaProxyRequest = unmarshall(requestMessage, LambdaProxyRequest.class);

        Map<String, String> body = lambdaProxyRequest.parseBody();

        if(body.get("command") != null) {
            handleSlashCommand(body);
        } else {
            handleMessageButton(body);
        }

        return null;
    }

    private void handleSlashCommand(Map<String, String> body) {
        String responseUrl = body.get("response_url");

        String text = body.get("text");
        if("help".equals(text)) {
            postMessage(responseUrl, HELP_MESSAGE);
            return;
        }

        //TODO: get riddle by category (`text`)
        Riddle riddle = DynamoRiddleService.getInstance().getRandomRiddle();
        postRiddle(responseUrl, riddle);
    }

    private void handleMessageButton(Map<String, String> body) {
        MessageActionRequest messageActionRequest = unmarshall(body.get("payload"), MessageActionRequest.class);

        int id = Integer.parseInt(messageActionRequest.getActions().get(0).getValue());
        Riddle riddle = DynamoRiddleService.getInstance().getRiddle(id);


        String message = "`Question`\n" + riddle.getQuestion() + "\n\n\n\n`Answer`\n" + riddle.getAnswer();
        postMessage(messageActionRequest.getResponseUrl(), message);
    }

}
