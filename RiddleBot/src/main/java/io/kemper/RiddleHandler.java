package io.kemper;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.kemper.api.Response;
import io.kemper.domain.Riddle;

import java.util.Map;

public class RiddleHandler implements RequestHandler<Map<String, Object>, Response> {

    @Override
    public Response handleRequest(Map<String, Object> input, Context context) {
        context.getLogger().log("Input: " + input);

        //TODO: get riddle
        Riddle riddle = new Riddle("what is aws lambda?");

        String body = marshall(riddle);

        Response response = new Response(body, 200);
        return response;
    }


    public static String marshall(Riddle riddle) {
        ObjectMapper mapper = new ObjectMapper();
        String body = null;
        try {
            body = mapper.writeValueAsString(riddle);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return body;
    }

}
