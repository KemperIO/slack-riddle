package io.kemper.api;

import java.util.List;

/**
 * TODO: Format response for Slack bot to consume
 */
public class SlackResponse {
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

        if (text != null ? !text.equals(that.text) : that.text != null) return false;
        return attachments != null ? attachments.equals(that.attachments) : that.attachments == null;
    }

    @Override
    public int hashCode() {
        int result = text != null ? text.hashCode() : 0;
        result = 31 * result + (attachments != null ? attachments.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SlackResponse{" +
                "text='" + text + '\'' +
                ", attachments=" + attachments +
                '}';
    }
}
