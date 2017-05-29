package io.kemper;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.kemper.api.*;
import io.kemper.domain.Riddle;
import io.kemper.service.RiddleService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GetRiddleHandler implements RequestHandler<Map<String, Object>, Response> {

    @Override
    public Response handleRequest(Map<String, Object> input, Context context) {
        context.getLogger().log("Input: " + input);

        //TODO: get riddle
        Riddle riddle = new RiddleService().getRandomRiddle();

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
