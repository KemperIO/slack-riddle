package io.kemper;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import io.kemper.api.Response;
import io.kemper.api.SlackResponse;

import java.util.Map;

import static io.kemper.service.JSONService.marshall;
import static io.kemper.service.SNSService.publishMessage;

public class InitialHandler implements RequestHandler<Map<String, Object>, Response> {

    @Override
    public Response handleRequest(Map<String, Object> request, Context context) {
        context.getLogger().log("Input: " + request);

        String message = marshall(request);
        publishMessage(message);

        SlackResponse slackResponse = new SlackResponse("Ok, got it.");
        String body = marshall(slackResponse);

        Response response = new Response(body, 200);
        return response;
    }

}
