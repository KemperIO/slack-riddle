package io.kemper.service;

import io.kemper.api.ResponseType;
import io.kemper.api.SlackResponse;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static io.kemper.service.JSONService.marshall;

public class SlackService {

    public static void postMessage(String url, String text) {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(url);
        Invocation.Builder invocationBuilder = webTarget.request();
        String body = marshall(new SlackResponse(ResponseType.in_channel, text));
        Response response = invocationBuilder.post(Entity.entity(body, MediaType.APPLICATION_JSON));
        System.out.println("status: " + response.getStatus());
    }
}
