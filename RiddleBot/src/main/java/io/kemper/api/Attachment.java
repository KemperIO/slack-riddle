package io.kemper.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * https://api.slack.com/docs/messages/builder?msg=%7B%22text%22%3A%22Would%20you%20like%20to%20play%20a%20game%3F%22%2C%22attachments%22%3A%5B%7B%22text%22%3A%22Choose%20a%20game%20to%20play%22%2C%22fallback%22%3A%22You%20are%20unable%20to%20choose%20a%20game%22%2C%22callback_id%22%3A%22wopr_game%22%2C%22color%22%3A%22%233AA3E3%22%2C%22attachment_type%22%3A%22default%22%2C%22actions%22%3A%5B%7B%22name%22%3A%22game%22%2C%22text%22%3A%22Chess%22%2C%22type%22%3A%22button%22%2C%22value%22%3A%22chess%22%7D%2C%7B%22name%22%3A%22game%22%2C%22text%22%3A%22Falken%27s%20Maze%22%2C%22type%22%3A%22button%22%2C%22value%22%3A%22maze%22%7D%2C%7B%22name%22%3A%22game%22%2C%22text%22%3A%22Thermonuclear%20War%22%2C%22style%22%3A%22danger%22%2C%22type%22%3A%22button%22%2C%22value%22%3A%22war%22%2C%22confirm%22%3A%7B%22title%22%3A%22Are%20you%20sure%3F%22%2C%22text%22%3A%22Wouldn%27t%20you%20prefer%20a%20good%20game%20of%20chess%3F%22%2C%22ok_text%22%3A%22Yes%22%2C%22dismiss_text%22%3A%22No%22%7D%7D%5D%7D%5D%7D
 */
public class Attachment {

    private String text;

    private String fallback;

    @JsonProperty("callback_id")
    private String callbackId;

    private String color;

    @JsonProperty("attachemnt_type")
    private String attachmentType;

    private List<Action> actions;

    public Attachment(){}

    public Attachment(String text, String fallback, String callbackId, String color, String attachmentType, List<Action> actions) {
        this.text = text;
        this.fallback = fallback;
        this.callbackId = callbackId;
        this.color = color;
        this.attachmentType = attachmentType;
        this.actions = actions;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFallback() {
        return fallback;
    }

    public void setFallback(String fallback) {
        this.fallback = fallback;
    }

    public String getCallbackId() {
        return callbackId;
    }

    public void setCallbackId(String callbackId) {
        this.callbackId = callbackId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAttachmentType() {
        return attachmentType;
    }

    public void setAttachmentType(String attachmentType) {
        this.attachmentType = attachmentType;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Attachment that = (Attachment) o;

        if (text != null ? !text.equals(that.text) : that.text != null) return false;
        if (fallback != null ? !fallback.equals(that.fallback) : that.fallback != null) return false;
        if (callbackId != null ? !callbackId.equals(that.callbackId) : that.callbackId != null) return false;
        if (color != null ? !color.equals(that.color) : that.color != null) return false;
        if (attachmentType != null ? !attachmentType.equals(that.attachmentType) : that.attachmentType != null)
            return false;
        return actions != null ? actions.equals(that.actions) : that.actions == null;
    }

    @Override
    public int hashCode() {
        int result = text != null ? text.hashCode() : 0;
        result = 31 * result + (fallback != null ? fallback.hashCode() : 0);
        result = 31 * result + (callbackId != null ? callbackId.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (attachmentType != null ? attachmentType.hashCode() : 0);
        result = 31 * result + (actions != null ? actions.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Attachment{" +
                "text='" + text + '\'' +
                ", fallback='" + fallback + '\'' +
                ", callbackId='" + callbackId + '\'' +
                ", color='" + color + '\'' +
                ", attachmentType='" + attachmentType + '\'' +
                ", actions=" + actions +
                '}';
    }
}
