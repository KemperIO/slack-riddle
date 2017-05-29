package io.kemper;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.kemper.api.LambdaProxyRequest;
import io.kemper.api.MessageActionRequest;
import io.kemper.api.Response;
import io.kemper.service.RiddleService;

import java.io.IOException;

public class GetAnswerHandler  implements RequestHandler<LambdaProxyRequest, Response> {

    @Override
    public Response handleRequest(LambdaProxyRequest request, Context context) {
        MessageActionRequest messageActionRequest = unmarshall(request.body);
        int id = Integer.parseInt(messageActionRequest.getActions().get(0).getValue());
        String answer = new RiddleService().getAnswer(id);
        Response response = new Response(answer, 200);
        return response;
    }

    public static MessageActionRequest unmarshall(String body) {
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
