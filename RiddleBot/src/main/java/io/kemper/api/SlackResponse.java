package io.kemper.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * TODO: Format response for Slack bot to consume
 */
public class SlackResponse {

    @JsonProperty("response_type")
    private ResponseType responseType;
    private String text;
    private List<Attachment> attachments;

    public SlackResponse() {}

    public SlackResponse(String text) {
        this.text = text;
    }

    public SlackResponse(String text, List<Attachment> attachments) {
        this.text = text;
        this.attachments = attachments;
    }

    public SlackResponse(ResponseType responseType, String text) {
        this.responseType = responseType;
        this.text = text;
    }

    public SlackResponse(ResponseType responseType, String text, List<Attachment> attachments) {
        this.responseType = responseType;
        this.text = text;
        this.attachments = attachments;
    }

    public ResponseType getResponseType() {
        return responseType;
    }

    public void setResponseType(ResponseType responseType) {
        this.responseType = responseType;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SlackResponse that = (SlackResponse) o;

        if (responseType != null ? !responseType.equals(that.responseType) : that.responseType != null) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;
        return attachments != null ? attachments.equals(that.attachments) : that.attachments == null;
    }

    @Override
    public int hashCode() {
        int result = responseType != null ? responseType.hashCode() : 0;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (attachments != null ? attachments.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SlackResponse{" +
                "responseType='" + responseType + '\'' +
                ", text='" + text + '\'' +
                ", attachments=" + attachments +
                '}';
    }
}
