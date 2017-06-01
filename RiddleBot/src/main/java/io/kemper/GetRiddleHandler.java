package io.kemper;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.kemper.api.*;
import io.kemper.domain.Riddle;
import io.kemper.service.DynamoRiddleService;
import io.kemper.service.SimpleRiddleService;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.*;

public class GetRiddleHandler implements RequestHandler<LambdaProxyRequest, Response> {

    @Override
    public Response handleRequest(LambdaProxyRequest request, Context context) {
        context.getLogger().log("Input: " + request);
        Map<String, String> requestBody = parseRequestBody(request.body);
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

    public Map<String, String> parseRequestBody(String body) {
        try {
            body = URLDecoder.decode(body, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Map<String, String> requestBody = new HashMap<>();

        String[] keypairs = body.split("&");
        for(String keypair : keypairs) {
            String[] temp = keypair.split("=");
            if(temp.length == 2) {
                requestBody.put(temp[0], temp[1]);
            }
        }

        return requestBody;
    }

    public static String marshall(Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        String body = null;
        try {
            body = mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return body;
    }

}
