package io.kemper;

import io.kemper.api.ResponseType;
import io.kemper.api.SlackResponse;
import org.junit.Test;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static io.kemper.service.JSONService.marshall;

public class SlackTest {

    @Test
    public void testSlackPost() {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target("https://hooks.slack.com/commands/T3VCJG3QE/193854695760/Mu2s2ERGJzgSRXsJDwDcRGjN");
        Invocation.Builder invocationBuilder = webTarget.request();
        String text = "hi from da jerseyzzz";
        String body = marshall(new SlackResponse(ResponseType.in_channel, text));
        Response response = invocationBuilder.post(Entity.entity(body, MediaType.APPLICATION_JSON));
        System.out.println("status: " + response.getStatus());
    }
}
