package io.kemper;

import io.kemper.api.Response;
import io.kemper.db.DBHandler;
import io.kemper.db.SimpleDBHandler;
import org.junit.Test;
import com.amazonaws.services.lambda.runtime.Context;


import java.io.*;

import static org.junit.Assert.assertTrue;

public class AnswerHandlerTest {

    DBHandler dbHandler = new SimpleDBHandler();

    static String inString = "{" +
            "    \"resource\": \"Resource path\"," +
            "    \"path\": \"Path parameter\"," +
            "    \"httpMethod\": \"Incoming request's method name\"," +
            "    \"headers\": \"aktest\"," +
            "    \"queryStringParameters\": {\"id\": 1}," +
            "    \"pathParameters\":  \"aktest\"," +
            "    \"stageVariables\": \"aktest\"," +
            "    \"requestContext\": \"aktest\"," +
            "    \"body\": \"A JSON string of the request payload.\"," +
            "    \"isBase64Encoded\": \"A boolean flag to indicate if the applicable request payload is Base64-encode\"" +
            "}";

    @Test
    public void testAnswerHandler() throws IOException {
        InputStream is = new ByteArrayInputStream( inString.getBytes() );
        OutputStream os = new ByteArrayOutputStream();
        Context context = new TestContext();
        AnswerHandler ah = new AnswerHandler();
        ah.handleRequest(is, os, context);
        assertTrue(os.toString().contains(dbHandler.getRiddleByID(1).getAnswer()));
    }
}
