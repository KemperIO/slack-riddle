package io.kemper;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.kemper.api.LambdaProxyRequest;
import io.kemper.api.MessageActionRequest;
import io.kemper.api.Response;
import io.kemper.domain.Riddle;
import io.kemper.service.SimpleRiddleService;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class GetAnswerHandler  implements RequestHandler<LambdaProxyRequest, Response> {

    @Override
    public Response handleRequest(LambdaProxyRequest request, Context context) {
        MessageActionRequest messageActionRequest = unmarshall(request.body);
        int id = Integer.parseInt(messageActionRequest.getActions().get(0).getValue());
        Riddle riddle = new SimpleRiddleService().getRiddle(id);

        Response response = new Response(riddle.getQuestion() + "\n\n" + riddle.getAnswer(), 200);
        return response;
    }

    public static MessageActionRequest unmarshall(String body) {
        try {
            body = URLDecoder.decode(body, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        body = body.replace("payload=", "");
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(body, MessageActionRequest.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
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
