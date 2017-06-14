package io.kemper.service;

import io.kemper.api.Action;
import io.kemper.api.Attachment;
import io.kemper.api.ResponseType;
import io.kemper.api.SlackResponse;
import io.kemper.domain.Riddle;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

import static io.kemper.service.JSONService.marshall;

public class SlackService {

    /**
     * Post simple Slack message.
     *
     * @param url Slack url
     * @param text Slack message
     */
    public static void postMessage(String url, String text) {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(url);
        Invocation.Builder invocationBuilder = webTarget.request();

        String body = marshall(new SlackResponse(ResponseType.in_channel, text));

        Response response = invocationBuilder.post(Entity.entity(body, MediaType.APPLICATION_JSON));
        System.out.println("status: " + response.getStatus());
    }


    /**
     * Post riddle message with `get answer` attachment.
     * @param url Slack url
     * @param riddle Riddle question to post
     */
    public static void postRiddle(String url, Riddle riddle) {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(url);
        Invocation.Builder invocationBuilder = webTarget.request();

        List<Attachment> attachments = getRiddleAttachments(riddle.getId().toString());
        String message = "`Question`\n" + riddle.getQuestion();
        String body = marshall(new SlackResponse(ResponseType.in_channel, message, attachments));

        Response response = invocationBuilder.post(Entity.entity(body, MediaType.APPLICATION_JSON));
        System.out.println("status: " + response.getStatus());
    }

    /**
     * Helper to hide complexity of creating attachments.
     * @param riddleId Riddle ID to set as Action value
     * @return List of Attachments
     */
    private static List<Attachment> getRiddleAttachments(String riddleId) {
        Action getAnswerAction = new Action("answer", "Get Answer", "button", riddleId);
        List<Action> actions = new ArrayList<>();
        actions.add(getAnswerAction);

        Attachment getRiddleAttachment = new Attachment(null, "Unable to get answer", "mycallbackid", "#00FF00", "default", actions);
        List<Attachment> attachments = new ArrayList<>();
        attachments.add(getRiddleAttachment);
        return attachments;
    }
}
