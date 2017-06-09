package io.kemper;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SNSEvent;
import io.kemper.api.LambdaProxyRequest;
import io.kemper.api.Response;

import java.util.Map;

import static io.kemper.service.JSONService.unmarshall;
import static io.kemper.service.SlackService.postMessage;

public class AsyncHandler implements RequestHandler<SNSEvent, Response> {

    private static final String HELP_MESSAGE = "Type `/riddle` to get a random riddle.";

    @Override
    public Response handleRequest(SNSEvent request, Context context) {
        context.getLogger().log("Input: " + request);
        System.out.println("MESSAGE: " + request.getRecords().get(0).getSNS().getMessage());

        String requestMessage = request.getRecords().get(0).getSNS().getMessage();
        LambdaProxyRequest lambdaProxyRequest = (LambdaProxyRequest) unmarshall(requestMessage, LambdaProxyRequest.class);

        Map<String, String> body = lambdaProxyRequest.parseRequestBody();
        String responseUrl = body.get("response_url");

        if("help".equals(body.get("text"))) {
            postMessage(responseUrl, HELP_MESSAGE);
            return null;
        }

        //TODO: determine if we should POST riddle or answer
        postMessage(responseUrl, "asynchronous post");

        return null;
    }

}
