package io.kemper;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import io.kemper.api.*;
import io.kemper.domain.Riddle;
import io.kemper.service.DynamoRiddleService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.kemper.service.JSONService.marshall;

public class GetRiddleHandler implements RequestHandler<LambdaProxyRequest, Response> {

    @Override
    public Response handleRequest(LambdaProxyRequest request, Context context) {
        context.getLogger().log("Input: " + request);
        Map<String, String> requestBody = request.parseRequestBody();
        System.out.println(requestBody);

        if("help".equals(requestBody.get("text"))) {
            return getHelp();
        }

        return getRiddle(requestBody.get("text"));

    }

    private Response getRiddle(String category) {
        Riddle riddle = DynamoRiddleService.getInstance().getRandomRiddle();

        Action getAnswerAction = new Action("answer", "Get Answer", "button", riddle.getId().toString());
        List<Action> actions = new ArrayList<>();
        actions.add(getAnswerAction);

        Attachment getRiddleAttachment = new Attachment("...", "Unable to get answer", "mycallbackid", "#00FF00", "default", actions);
        List<Attachment> attachments = new ArrayList<>();
        attachments.add(getRiddleAttachment);
        SlackResponse slackResponse = new SlackResponse(ResponseType.in_channel, riddle.getQuestion(), attachments);

        String body = marshall(slackResponse);

        Response response = new Response(body, 200);
        System.out.println(response);
        return response;
    }

    private Response getHelp() {
        SlackResponse slackResponse = new SlackResponse(ResponseType.ephemeral, "Type `/riddle` to get a random riddle.", null);
        String body = marshall(slackResponse);
        Response response = new Response(body, 200);
        return response;
    }





}
