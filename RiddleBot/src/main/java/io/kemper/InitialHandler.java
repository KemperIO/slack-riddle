package io.kemper;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import io.kemper.api.Response;

import java.util.Map;

public class InitialHandler implements RequestHandler<Map<String, Object>, Response> {

    @Override
    public Response handleRequest(Map<String, Object> request, Context context) {
        context.getLogger().log("Input: " + request);

        return null;
    }
}
