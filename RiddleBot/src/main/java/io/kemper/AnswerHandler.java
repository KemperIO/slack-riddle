package io.kemper;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.kemper.api.Response;
import io.kemper.db.DBHandler;
import io.kemper.db.SimpleDBHandler;

import java.io.*;
import java.util.Map;


public class AnswerHandler implements RequestStreamHandler {
    DBHandler dbHandler;

    public AnswerHandler() {
        this.dbHandler = new SimpleDBHandler();
    }

    @Override
    public void handleRequest(InputStream input, OutputStream output, Context context) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        OutputStreamWriter writer = new OutputStreamWriter(output, "UTF-8");
        ObjectMapper mapper = new ObjectMapper();
        JsonNode event = mapper.readTree(reader);
        JsonNode qsp = event.get("queryStringParameters");


        //TODO there must be a more elegant way of doing this
        
        Map<String, Object> map = mapper.readValue(qsp.toString(), new TypeReference<Map<String,Object>>(){});
        Object idObject = map.get("id");
        int id = 0;
        if (idObject instanceof Integer) {
            id = (int) idObject;
        } else {
            String idString = (String) idObject;
            idString = idString.replace("\"", "");
            id = Integer.parseInt(idString);
        }
        String answer = dbHandler.getRiddleByID(id).getAnswer();
        Response response = new Response(answer, 200);
        writer.write(marshall(response));
        writer.close();
    }

    public String marshall(Response r) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        return om.writeValueAsString(r);
    }
}
