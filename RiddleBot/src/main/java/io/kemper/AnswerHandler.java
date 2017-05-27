package io.kemper;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.kemper.api.Response;
import io.kemper.db.DBHandler;
import io.kemper.db.SimpleDBHandler;

import java.io.*;


public class AnswerHandler implements RequestStreamHandler {
    DBHandler dbHandler;

    public AnswerHandler() {
        this.dbHandler = new SimpleDBHandler();
    }

    @Override
    public void handleRequest(InputStream input, OutputStream output, Context context) throws IOException {
        LambdaLogger logger = context.getLogger();
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        OutputStreamWriter writer = new OutputStreamWriter(output, "UTF-8");
        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(reader);
        String idString = actualObj.get("queryStringParameters").get("id").toString();
        logger.log("---------ID STRING: " + idString + "--------------");
        try {
            int id = Integer.parseInt(idString);
            String answer = dbHandler.getRiddleByID(id).getAnswer();
            Response response = new Response(answer, 200);
            writer.write(marshall(response));
        } catch (Exception e) {
            String answer = "idString is " + idString;
            Response response = new Response(answer, 200);
            writer.write(marshall(response));
        } finally {
            writer.close();
        }
    }

    public String marshall(Response r) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        return om.writeValueAsString(r);
    }
}
