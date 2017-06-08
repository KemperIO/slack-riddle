package io.kemper;

import io.kemper.api.SlackResponse;
import org.junit.Test;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class SlackTest {

    @Test
    public void testSlackPost() {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target("https://hooks.slack.com/commands/T3VCJG3QE/194414277651/0LmA4pOZixcmBiUsW62yUrHZ");
        Invocation.Builder invocationBuilder = webTarget.request();
        Response response = invocationBuilder.post(Entity.entity(new SlackResponse("hi from Jersey"), MediaType.APPLICATION_JSON));
        System.out.println("status: " + response.getStatus());
    }
}
