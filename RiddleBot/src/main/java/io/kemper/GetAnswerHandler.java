package io.kemper;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.kemper.api.MessageActionRequest;
import io.kemper.api.Response;
import io.kemper.service.RiddleService;

public class GetAnswerHandler  implements RequestHandler<MessageActionRequest, Response> {

    @Override
    public Response handleRequest(MessageActionRequest request, Context context) {

        System.out.println(request);
        //System.out.println("Id: " +  request.getActions().get(0).getValue());

        String answer = new RiddleService().getAnswer(0);

        Response response = new Response(answer, 200);
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
